package com.web.listener;

import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener,
        HttpSessionAttributeListener,
        HttpSessionBindingListener,
        HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSessionActivationListener.super.sessionWillPassivate(se);
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSessionActivationListener.super.sessionDidActivate(se);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeRemoved(se);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSessionBindingListener.super.valueBound(event);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSessionBindingListener.super.valueUnbound(event);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
