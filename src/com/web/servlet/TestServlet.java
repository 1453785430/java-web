package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 实现servlet
 * 1. 创建java类
 * 2. 实现servlet规范,继承HttpServlet类
 * 3. 重写servlet方法,用来处理请求
 * 4. 设置注解,指定访问的路径
 */
//@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取URL端口后的资源路径
        String requestURI = req.getRequestURI();
        //
        StringBuffer requestURL = req.getRequestURL();
        String contextPath = req.getContextPath();
        //req.getHeader();
        String method = req.getMethod();

        System.out.println("requestURI"+requestURI);
        System.out.println("requestURL"+requestURL);
        System.out.println("contextPath"+contextPath);
        System.out.println("method"+method);

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }


        if ("asdasd".equals(username)&&"123456".equals(password)){
            //接到用户请求之后给的响应信息
            resp.getWriter().write("登陆成功");
        }else {
            resp.getWriter().write("登陆失败");
        }

        //接到用户请求后,给出一个响应信息
//        resp.getWriter().write("hello Servlet...");
//        resp.getWriter().write("username"+username);
//        resp.getWriter().write("password"+password);


    }
}
