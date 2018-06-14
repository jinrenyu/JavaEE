package com.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FirstFilter implements Filter {

	public FirstFilter() {
	}

	// 当web应用关闭/重启/重新部署的时候, 就会调用该destroy方法来完成过滤器的销毁
	public void destroy() {
		System.out.println("第一个过滤器被销毁......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 这是一行分界线代码, 写在这行代码之前表示对用户发送过来的请求进行一些处理
		System.out.println("第一个过滤器的请求过滤");
		chain.doFilter(request, response);
		// 写在这行代码之后, 表示对服务器响应的信息进行处理
		System.out.println("第一个过滤器的响应过滤");
	}

	// 和servlet一样, 过滤器filter同样需要经过初始化销毁的过程
	// 但是当应用程序启动的时候便会调用这个init方法来完成对过滤器的初始化
	public void init(FilterConfig fConfig) throws ServletException {
		String name = fConfig.getInitParameter("name");
		System.out.println("第一个过滤器启动了....." + name);
	}

}
