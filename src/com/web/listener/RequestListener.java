package com.web.listener;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 监听请求的监听器
 */

/**
 * ServletRequestListener: 监听请求的创建和销毁
 * ServletRequestAttributeListener: 监听请求中数据的变化
 */
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //当往request中存放数据的时候,可以监听到放的是什么
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
        System.out.println(srae.getServletRequest().getRemoteHost());
        HttpServletRequest servletRequest = (HttpServletRequest) srae.getServletRequest();
        System.out.println(servletRequest.getContextPath());
        System.out.println(servletRequest.getRequestURI());
        Enumeration<String> headerNames = servletRequest.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            System.out.println(servletRequest.getHeader(key));
        }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //当从request中移除数据的时候,可以监听到
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //当修改request中数据时 可监听到
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //当request销毁的时候 触发
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //当request初始化的时候 可以监听到
    }
}
