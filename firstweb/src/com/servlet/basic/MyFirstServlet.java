package com.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFirstServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("该servlet被销毁");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("servlet的init方法被调用.....");
	}

	@Override
	public void service(ServletRequest res, ServletResponse req) throws ServletException, IOException {
		req.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		Date date = new Date();
		PrintWriter out = req.getWriter();
		out.println("<p style='color:red;'>一段段落文字</p>");
		out.println(date);
	}

}
