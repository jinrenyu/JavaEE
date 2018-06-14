package com.session.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    // ��ServletContext�������ٵ�ʱ������ø÷���
    public void contextDestroyed(ServletContextEvent se)  { 
    	System.out.println("ServletContext����������....");
    }

    // ��webӦ��������ʱ��, ���ʼ��һ��ServletContext����
    // ��ServletContext���󱻳�ʼ����ʱ������ø÷���
    // 3������ĳ�ʼ��˳��(������->������->Servlet)
    public void contextInitialized(ServletContextEvent se)  { 
    	// ���Ի�ȡ��ServletContext����
    	// se.getServletContext();
    	System.out.println("ServletContext���󱻳�ʼ����....");
    }
	
}
