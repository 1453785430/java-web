package com.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("八嘎牙路");
        //filterChain.doFilter(servletRequest,servletResponse);



        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendRedirect("paging.do");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
