package com.web.servlet.forward1;

import com.google.gson.Gson;
import com.web.dao.Impl.UserInfoDaoImpl;
import com.web.dao.UserInfoDao;
import com.web.entity.UserInfo;
import com.web.utils.BaseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/userAll.do")
public class UserInfoAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfoDao userInfoDao = new UserInfoDaoImpl();
        List<UserInfo> list = userInfoDao.getUserAll();
        resp.setContentType("text/html;charset=UTF-8");

        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(BaseResult.success(list)));
    }
}
