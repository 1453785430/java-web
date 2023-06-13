package com.web.servlet.fenye;

import com.web.dao.Impl.SysRegionDaoImpl;
import com.web.dao.SysRegionDao;
import com.web.entity.SysRegion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/paging.do")
public class PagingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer pageIndex = 1;
        String indexStr = req.getParameter("pageIndex");
        if (indexStr != null) {
            pageIndex = Integer.parseInt(indexStr);
        }
        //定义每页显示条数
        Integer pageSize = 10;
        //获取总记录数(要查数据库就要dao的对象来操作)
        SysRegionDao sysRegionDao = new SysRegionDaoImpl();
        Integer count = sysRegionDao.countAll();
        //计算总页数
        //总页数的计算公式: 总页数=(count % pageSize == 0 ? count/pageSize : count/pageSize + 1);
        Integer pageCount = (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        //计算起始下标 计算公式:起始下标=(当前页-1)*每页显示条数
        Integer startIndex = (pageIndex - 1) * pageSize;
        //根据计算好的数据查询数据库
        List<SysRegion> list = sysRegionDao.getSysRegions(startIndex,pageSize);
        req.setAttribute("list",list);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("pageIndex",pageIndex);
        req.setAttribute("count",count);
        //转发器
        req.getRequestDispatcher("table.jsp").forward(req,resp);
    }
}
