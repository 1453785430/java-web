package com.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 小红帽的外婆
 */
public class WaiPoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("外婆不在家");
        //门上有张告示,写着外婆今天不在家,有事找牛爷爷  (转发器)
        RequestDispatcher dispatcher = req.getRequestDispatcher("niuYeYe.do");
        //拿到提示信息,去找牛爷爷
        dispatcher.forward(req,resp);
//          System.out.println("外婆搬家啦,去新家找找吧");
//        resp.sendRedirect("newHome.do");
    }
}
