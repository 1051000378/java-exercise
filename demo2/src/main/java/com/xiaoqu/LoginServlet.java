package com.xiaoqu;

import com.xiaoqu.bean.User;
import com.xiaoqu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.调用service查询
        User user = userService.login(username,password);
        //3.判断
        if(user != null){
            //登录成功，跳转到查询所有的BrandServlet

            //将登录成功后的user对象，存储到session
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/selectAllServlet");

        }else {
            //登录失败
            req.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
