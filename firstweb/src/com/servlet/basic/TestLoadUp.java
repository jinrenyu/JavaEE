package com.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLoadUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestLoadUp() {
        super();
        System.out.println("我会随着应用服务器启动而进行实例创建....");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("我会随着应用服务器启动而进行初始化...");
    	super.init();
    	// 此处可以书写系统初始化任务代码或者定时器代码
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
