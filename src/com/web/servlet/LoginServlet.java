package com.web.servlet;

import com.mysql.cj.util.StringUtils;
import com.web.dao.Impl.UserInfoDaoImpl;
import com.web.dao.UserInfoDao;
import com.web.entity.UserInfo;
import com.web.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login3.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式为UTF-8 防止乱码
        req.setCharacterEncoding("UTF-8");
        //获取请求参数  用户输入的账号和密码
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        //设置响应的编码格式为UTF-8
        resp.setContentType("text/html;charset=UTF-8");
        //对请求参数进行非空校验
        if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password)){
            resp.getWriter().write("<h1 style='color:tomato;'>用户名和密码不能为空</h1>");
        }else {
            //查询数据库
            UserInfoDao userInfoDao=new UserInfoDaoImpl();
            //给密码加密
            String encrypted = MD5Utils.encryptMD5(password);
            //使用用户名和加密后的密码去数据库查询
            UserInfo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName, encrypted);
            //如果userInfo对象为空,说明账号或密码不正确 如果不为空登陆成功
            if (userInfo==null){
                resp.getWriter().write("<h1 style='color:red;'>账号或密码错误</h1>");
            }else {
                resp.getWriter().write("<h1 style='color:green;'>登陆成功</h1>");
            }
        }
    }
}
