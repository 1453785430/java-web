package com.web.servlet.context;

import com.google.gson.Gson;
import com.web.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/getSession.do")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //.castvar
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        System.out.println("获取的session数据为:"+userInfo);
        resp.getWriter().write(new Gson().toJson(userInfo));
    }
}
