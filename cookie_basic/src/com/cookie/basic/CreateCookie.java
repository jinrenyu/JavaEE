package com.cookie.basic;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateCookie")
public class CreateCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 创建一个Cookie对象
		// Cookie对象只有一个需要传递两个参数的构造方法,
		// 两个参数都只能是String类型的值
		// 参数1: cookie的键值, 参数2: key所对应的值
		Cookie cookie = new Cookie("name", URLEncoder.encode("中文字符", "utf-8"));
		Cookie cookie2 = new Cookie("age", "123");
		// Cookie cookie2 = new Cookie("name", "tom");
		// 2. 如果需要让cookie在浏览器端长时间保存, 则必须为其
		// 设置存活的时间(秒)
		cookie.setMaxAge(60*60);
		cookie2.setMaxAge(-1);
		// 3. 一定要把创建的cookie对象添加给response响应对象
		response.addCookie(cookie);
		response.addCookie(cookie2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
