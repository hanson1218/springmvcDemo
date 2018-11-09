package com.snow.www.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * servletcontext 需要有在web.xml中配置监听器，在web.xml配置这个监听器，启动容器时，就会默认执行它实现的方法
 * 可以在启动时加载某些共享数据，其他的servlet就可以通过ServletContext.getAttribute("dept")获取到
 * Servlet 容器启动Web--》调用该方法初始化bean -->对Filter 初始化
 * 销毁所有的Servlet 和Filter 过滤器-->contextDestroyed
 * ServletContext servletContext = this.getServletContext();继承
	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	cmailWebService = (CmailWebService) ctx.getBean("cmailWebService");
 * @author LiHuaSheng
 *
 */
public class ContextListenerTest1 implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent event) {
        System.out.println("*************destroy ContextListener1*************");
    }
    
    @SuppressWarnings("unused")
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("*************init ContextListener1*************");
        ServletContext servletContext = event.getServletContext();
        System.out.println("key:"+servletContext.getInitParameter("key"));
    }

}
