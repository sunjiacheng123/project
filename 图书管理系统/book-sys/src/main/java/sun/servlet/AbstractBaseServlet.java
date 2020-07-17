package sun.servlet;

import sun.exception.BaseException;
import sun.model.ResponsResult;
import sun.util.CountHolder;
import sun.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//针对请求体设置编码,注意对url中的请求数据无效
        resp.setCharacterEncoding("UTF-8");//针对响应体涉及编码
        resp.setContentType("application/json");//设置响应数据格式:响应偷content-type告诉浏览器怎么响应
        ResponsResult r=new ResponsResult();
        try {
            Object data=process(req,resp);
            r.setSuccess(true);
            r.setCode("000000");
            r.setMessage("操作成功");
            r.setTotal(CountHolder.get());//可能使分页的接口，get可以获取到值，
            r.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            //判断e是否属于BaseException
            if(e instanceof BaseException){
                BaseException be=(BaseException)e;
                r.setCode(be.getCode());
                r.setMessage(be.getMessage());
            }else{
                r.setCode("500");
                r.setMessage("未知错误");
            }
            StringWriter sw=new StringWriter();
            PrintWriter pw=new PrintWriter(sw);
            //将错误堆栈信息输入到StringWriter中
            e.printStackTrace(pw);
            r.setStackTrace(sw.toString());
        }finally {
            CountHolder.remove();//threadlocal规范做法：线程结束前，一定要remove，否则可能出现内存泄漏

        }
        PrintWriter pw=resp.getWriter();
        pw.println(JSONUtil.write(r));
        pw.flush();
    }
    public abstract Object process(HttpServletRequest req,HttpServletResponse resp) throws Exception;
}
