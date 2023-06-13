package com.web.servlet.jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/jspTest")
public class JspServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("name","小美");

        req.getRequestDispatcher("test.jsp").forward(req,resp);


    }
}
