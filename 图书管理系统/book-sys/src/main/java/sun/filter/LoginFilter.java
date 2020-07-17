package sun.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")//所有都过滤
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        String url=req.getServletPath();
        //访问首页/public/page/main.html  没有登录重定向到登录页面
        //访问后台的敏感资源，servlet的敏感服务，返回json数据
        if("/login.html".equals(url) || url.startsWith("/public/")|| url.startsWith("/static/")||
                "/user/login".equals(url)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //false；没有就不创建
            HttpSession session=req.getSession(false);
            if(session==null){
                //访问敏感资源，没有登录，需要跳转到登录页面

                String schema=req.getScheme();//http
                String host=req.getServerName();//服务器ip或域名
                int port=req.getServerPort();//服务器端口号
                String contextpath=req.getContextPath();
                String basepath=schema+"://"+host+":"+port+contextpath;
                //重定向
                ((HttpServletResponse)servletResponse).sendRedirect(basepath+"/public/index.html");

                return;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
