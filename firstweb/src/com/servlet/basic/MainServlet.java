package com.servlet.basic;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ĭ�ϵ�response�ַ�������:" + response.getCharacterEncoding());
		System.out.println("Ĭ�ϵ�request����ַ�����" + request.getCharacterEncoding());
		response.setContentType("text/html;charset=utf-8");
		// �൱��<meta http-equiv="content-type" content="text/html;charset=utf-8">
		response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/HeaderServlet")
			.include(request, response);
		response.getWriter().println("�����������");
		request.getRequestDispatcher("/FooterServlet")
			.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = URLEncoder.encode("��������", "UTF-8");
		System.out.println(str);
		// tomcat���͸������destr
		String destr = URLDecoder.decode(str, "ISO-8859-1");
//		String temp = URLEncoder.encode(destr, "ISO-8859-1");
//		String temp02 = URLDecoder.decode(temp, "UTF-8");
		String temp02 = new String(destr.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(temp02);
	}

}
