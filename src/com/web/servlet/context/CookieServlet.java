package com.web.servlet.context;

import com.google.gson.Gson;
import com.web.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        Cookie cookie = new Cookie("java_web_cookie", "法外狂徒");
//        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        resp.getWriter().write("success");
    }
}
