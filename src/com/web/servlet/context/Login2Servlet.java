package com.web.servlet.context;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/login2.do")
public class Login2Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if ("admin".equals(userName) &&"123456".equals(password)){
            System.out.println("登陆成功!");
            Map<String,String> map = new HashMap<>();
            map.put("userName",userName);
            map.put("password",password);

            //如果登陆成功,用户信息存放到session中
            HttpSession session  = req.getSession();
            session.setAttribute("map",map);
            //重定向到 主页
            resp.sendRedirect("home.do");
        }else {
            req.setAttribute("msg","用户名或密码错误");
            //获取转发器
            RequestDispatcher dispatcher = req.getRequestDispatcher("login1.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
