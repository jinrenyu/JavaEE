package com.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetURLInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetURLInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 以"http://localhost:8085/firstweb/GetURLInfo"为例
		// 1. 获取请求路径的web应用的名字
		String webPath = request.getContextPath();
		System.out.println("web应用的路径为:" + webPath);
		// 2. 获取相对URI路径
		String web01 = request.getRequestURI();
		System.out.println("web相对URI路径为:" + web01);
		// 3. 获取相对URL路径
		StringBuffer web02 = request.getRequestURL();
		System.out.println("webURL路径为:" + web02.toString());
		// 4. 获取请求的方式
		String web03 = request.getScheme();
		System.out.println("请求的方式为:" + web03.toString());
		// 5. 获取请求的具体协议
		String web04 = request.getProtocol();
		System.out.println("请求的协议:" + web04.toString());
		// http1.1协议又称之为长连接
		// (通信结束, 服务器通道会保持一段时间(30s), 防止用户在短时间内再次访问)
		// http1.0短连接方式(通信结束之后立马挂断)
		
		// 获取客户端的地址
		String addr = request.getRemoteAddr();
		if ("192.168.0.111".equals(addr)) {
			response.getWriter().println("you are confused!");
			return;
		}
		// 获取客户端的主机名
		String rehost = request.getRemoteHost();
		System.out.println(addr + ", " + rehost);
		// 获取客户端的端口
		System.out.println("客户端的端口:" + request.getRemotePort());
		// 获取本地服务器的主机地址
		// request.getLocalAddr();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
