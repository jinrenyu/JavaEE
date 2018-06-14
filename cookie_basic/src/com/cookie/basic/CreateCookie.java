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
		// 1. ����һ��Cookie����
		// Cookie����ֻ��һ����Ҫ�������������Ĺ��췽��,
		// ����������ֻ����String���͵�ֵ
		// ����1: cookie�ļ�ֵ, ����2: key����Ӧ��ֵ
		Cookie cookie = new Cookie("name", URLEncoder.encode("�����ַ�", "utf-8"));
		Cookie cookie2 = new Cookie("age", "123");
		// Cookie cookie2 = new Cookie("name", "tom");
		// 2. �����Ҫ��cookie��������˳�ʱ�䱣��, �����Ϊ��
		// ���ô���ʱ��(��)
		cookie.setMaxAge(60*60);
		cookie2.setMaxAge(-1);
		// 3. һ��Ҫ�Ѵ�����cookie������Ӹ�response��Ӧ����
		response.addCookie(cookie);
		response.addCookie(cookie2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
