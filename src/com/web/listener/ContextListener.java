package com.web.listener;

import javax.servlet.*;

/**
 * 全局作用域 监听器
 */
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeAdded(scae);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeRemoved(scae);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContextAttributeListener.super.attributeReplaced(scae);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
