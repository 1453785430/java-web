package com.web.servlet.forward1;

import com.web.dao.Impl.UserInfoDaoImpl;
import com.web.dao.UserInfoDao;
import com.web.entity.UserInfo;
import com.web.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        String encrypted = MD5Utils.encryptMD5(password);
        UserInfo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName,encrypted);
        if (userInfo == null){
            //重定向登陆页面
            resp.sendRedirect("index.jsp");
        }else {
            resp.sendRedirect("home.html");
        }
    }
}
