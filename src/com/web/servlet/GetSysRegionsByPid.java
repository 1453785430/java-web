package com.web.servlet;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;
import com.web.dao.Impl.SysRegionDaoImpl;
import com.web.dao.SysRegionDao;
import com.web.entity.SysRegion;
import com.web.utils.BaseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getSysRegionsByPid.do")
public class GetSysRegionsByPid extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BaseResult result= null;
        String pid = req.getParameter("pid");
        if(StringUtils.isNullOrEmpty(pid)){
            result=BaseResult.error(2001,"请求参数错误");
        }else {
            SysRegionDao sysRegionDao = new SysRegionDaoImpl();
            List<SysRegion> list = sysRegionDao.getSysRegionsByPid(pid);
            result=BaseResult.success(list);
        }

        resp.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(result));
    }
}
