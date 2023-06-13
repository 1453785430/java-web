package com.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilters implements Filter {
    public MyFilters() {
        System.out.println("小日本正在计划刺杀");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("小日本埋伏,准备刺杀");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("八嘎牙路");
        filterChain.doFilter(servletRequest,servletResponse);
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.sendRedirect("paging.do");
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("小日本,嘎了");
    }
}
