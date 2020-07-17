//package sun.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//
//@WebServlet("/user/login2")
//public class UserLoginServelet2 extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");//针对请求体设置编码,注意对url中的请求数据无效
//        resp.setCharacterEncoding("UTF-8");//针对响应体涉及编码
//
//        resp.setContentType("application/json");//设置响应数据格式:响应偷content-type告诉浏览器怎么响应
//        //json数据，需要通过io流获取
//        HashMap json=new ObjectMapper().readValue(req.getInputStream(), HashMap.class);
//        System.out.println(json);
//        //System.out.printf("用户名=%s,密码=%s\n",username,password);
//        HashMap<String,Object> r=new HashMap<>();
//        r.put("success",true);
//        r.put("code",200);
//        PrintWriter pw=resp.getWriter();
//        pw.println(new ObjectMapper().writeValueAsString(r));
//        pw.flush();
//    }
//}
