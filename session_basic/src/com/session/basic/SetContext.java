package com.session.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetContext")
public class SetContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetContext() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取ServletContext对象的方法.servlet中很多地方都提供了
		// getServletContext方法, 这个方法都会返回web应用唯一
		// 的一个"WEB应用上下文对象"
		getServletContext().setAttribute("test", "testtest");
		// 它会把数据存放进一个web应用级的内存里面, 不同的会话都可以访问其中的数据
		// 因为ServletContext(生命周期)中的数据只有在web应用重启/关闭/重新发布
		// web应用服务器(tomcat)关闭/重启的时候才会消失, 不要往ServletContext
		// 里存放过多的东西(切记).
		// ServeltContext也可以实现转发和include, 其效果和
		// request的等价
		// getServletContext().getRequestDispatcher("").forward(arg0, arg1);
		System.out.println(getServletContext().getInitParameter("global"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
