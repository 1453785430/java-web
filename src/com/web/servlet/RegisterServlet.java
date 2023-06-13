package com.web.servlet;

import com.mysql.cj.util.StringUtils;
import com.web.dao.Impl.RegisterDaoImpl;
import com.web.dao.RegisterDao;
import com.web.entity.UserInfo;
import com.web.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    private RegisterDao registerDao = new RegisterDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(req.getParameter("userName"));
        userInfo.setPassword(MD5Utils.encryptMD5(req.getParameter("password")));
        userInfo.setName(req.getParameter("name"));
        userInfo.setTel(req.getParameter("tel"));
        userInfo.setAddress(req.getParameter("address"));
        userInfo.setIdCard(req.getParameter("idcard"));
        resp.setContentType("text/html;charset=UTF-8");
        if (StringUtils.isNullOrEmpty(userInfo.getUserName()) ||
                StringUtils.isNullOrEmpty(userInfo.getPassword()) ||
                        StringUtils.isNullOrEmpty(userInfo.getName()) ||
                        StringUtils.isNullOrEmpty(userInfo.getTel()) ||
                        StringUtils.isNullOrEmpty(userInfo.getAddress())||
                        StringUtils.isNullOrEmpty(userInfo.getIdCard())

        ) {
            resp.getWriter().write("<h1 style='color:red;'>用户名不能为空</h1>");
        }else {
            if (registerDao.isCheckUserName(userInfo)){
                if (registerDao.register(userInfo)){
                    resp.getWriter().write("<h1 style='color:green;'>注册成功</h1>");
                }else {
                    resp.getWriter().write("<h1 style='color:red;'>注册失败</h1>");
                }
            }else {
                resp.getWriter().write("<h1 style='color:red;'>用户名已存在</h1>");
            }
        }

    }
}
