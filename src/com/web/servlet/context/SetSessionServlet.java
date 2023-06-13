package com.web.servlet.context;

import com.web.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/setSession.do")
public class SetSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("虎比");
        userInfo.setUserName("ouDei");
        userInfo.setPassword("123456");
        userInfo.setTel("15623212653");
        userInfo.setAddress("河南国宝花园");
        userInfo.setIdCard("123251233326251251");
        userInfo.setCreateTime(new Date());
        userInfo.setStatus(1);
        //往session作用域中存放数据
        session.setAttribute("user",userInfo);
        resp.getWriter().write("session data add yes");
    }
}
