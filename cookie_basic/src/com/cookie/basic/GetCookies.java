package com.cookie.basic;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookies
 */
@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 该方法可以获取到这个web应用的所有cookie对象
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			// 只能通过遍历加上判断的方法来获取指定的Cookie对象
			if ("name".equals(cookie.getName())) {
				System.out.println("cookie的属性:" + cookie.getName() 
				+ ", cookie的值:" + URLDecoder.decode(cookie.getValue(), "utf-8"));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
