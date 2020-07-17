package sun.servlet;

import sun.dao.UserDAO;
import sun.exception.BusinessException;
import sun.model.User;
import sun.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServelet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //req.getParameter("");这个方式只能获取url和请求体，k=v形式的数据
        User user= JSONUtil.read(req.getInputStream(),User.class);//http请求解析的用户数据
        User queryuser= UserDAO.query(user);//通过请求的用户名密码在数据库查询，获取用户
        if(queryuser==null)
            throw new BusinessException("00001","用户密码校验失败");
        HttpSession session=req.getSession();
        session.setAttribute("user",queryuser);
        return null;
    }
}
