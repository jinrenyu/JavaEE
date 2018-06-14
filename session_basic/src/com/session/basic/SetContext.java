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
		// ��ȡServletContext����ķ���.servlet�кܶ�ط����ṩ��
		// getServletContext����, ����������᷵��webӦ��Ψһ
		// ��һ��"WEBӦ�������Ķ���"
		getServletContext().setAttribute("test", "testtest");
		// ��������ݴ�Ž�һ��webӦ�ü����ڴ�����, ��ͬ�ĻỰ�����Է������е�����
		// ��ΪServletContext(��������)�е�����ֻ����webӦ������/�ر�/���·���
		// webӦ�÷�����(tomcat)�ر�/������ʱ��Ż���ʧ, ��Ҫ��ServletContext
		// ���Ź���Ķ���(�м�).
		// ServeltContextҲ����ʵ��ת����include, ��Ч����
		// request�ĵȼ�
		// getServletContext().getRequestDispatcher("").forward(arg0, arg1);
		System.out.println(getServletContext().getInitParameter("global"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
