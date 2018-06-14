package com.session.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    // 当ServletContext对象被销毁的时候便会调用该方法
    public void contextDestroyed(ServletContextEvent se)  { 
    	System.out.println("ServletContext对象被销毁了....");
    }

    // 当web应用启动的时候, 会初始化一个ServletContext对象
    // 当ServletContext对象被初始化的时候便会调用该方法
    // 3个组件的初始化顺序(监听器->过滤器->Servlet)
    public void contextInitialized(ServletContextEvent se)  { 
    	// 可以获取到ServletContext对象
    	// se.getServletContext();
    	System.out.println("ServletContext对象被初始化了....");
    }
	
}
