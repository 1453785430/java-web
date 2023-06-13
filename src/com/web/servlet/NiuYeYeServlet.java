package com.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NiuYeYeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("name","牛大哥");
        System.out.println("牛爷爷在家");
        String liWu = req.getParameter("liWu");
        System.out.println("这是小红帽带的礼物:"+liWu);
        resp.getWriter().write("牛爷爷给的礼物");
    }
}
