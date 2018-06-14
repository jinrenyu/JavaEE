package com.ajax.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.entity.User;
import com.alibaba.fastjson.JSON;

@WebServlet("/HelloAjax")
public class HelloAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloAjax() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		System.out.println("doGet方法被调用了....");
		response.getWriter().println("hello ajax");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		response.getWriter().println("post: ");
		doGet(request, response);
	}
	
	public static void main(String[] args) {
		User user = new User(1, "jack", "abcd");
		String str = JSON.toJSONString(user);
		System.out.println(str);
		User user2 = JSON.parseObject(str, User.class);
		System.out.println(user2.getPassword());
	}

}
