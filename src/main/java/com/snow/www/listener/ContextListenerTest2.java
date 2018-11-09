package com.snow.www.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest2 implements ServletContextListener{

	@SuppressWarnings("unused")
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("===================init ContextListener2============");
        ServletContext servletContext = event.getServletContext();
        
        System.out.println("key:"+servletContext.getInitParameter("key"));
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==================Destroyed ContextListener2============");
		
	}

}
