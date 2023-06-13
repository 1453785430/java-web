package com.web.servlet.context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/home.do")
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录成功之后才能访问的servlet
        //如何判断用户有没有登陆成功?  就是判断session作用域中的map有没有值  如果有 就说明用户登陆过 且成功
        //反之用户没有登陆,则不允许访问当前这个servlet 重定向到登录页
        System.out.println(req.getSession().getAttribute("map"));
        Map<String, String> userInfo = (Map<String, String>) req.getSession().getAttribute("map");
        if (userInfo == null){
            resp.sendRedirect("login1.jsp");
        }else{
            resp.getWriter().write("<h1 style='color:tomato'>hello:"+userInfo.get("userName")+"</h1>");
        }
    }
}
