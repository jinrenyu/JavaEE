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
		// �÷������Ի�ȡ�����webӦ�õ�����cookie����
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			// ֻ��ͨ�����������жϵķ�������ȡָ����Cookie����
			if ("name".equals(cookie.getName())) {
				System.out.println("cookie������:" + cookie.getName() 
				+ ", cookie��ֵ:" + URLDecoder.decode(cookie.getValue(), "utf-8"));
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
