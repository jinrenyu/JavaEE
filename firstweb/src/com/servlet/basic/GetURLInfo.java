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
		// ��"http://localhost:8085/firstweb/GetURLInfo"Ϊ��
		// 1. ��ȡ����·����webӦ�õ�����
		String webPath = request.getContextPath();
		System.out.println("webӦ�õ�·��Ϊ:" + webPath);
		// 2. ��ȡ���URI·��
		String web01 = request.getRequestURI();
		System.out.println("web���URI·��Ϊ:" + web01);
		// 3. ��ȡ���URL·��
		StringBuffer web02 = request.getRequestURL();
		System.out.println("webURL·��Ϊ:" + web02.toString());
		// 4. ��ȡ����ķ�ʽ
		String web03 = request.getScheme();
		System.out.println("����ķ�ʽΪ:" + web03.toString());
		// 5. ��ȡ����ľ���Э��
		String web04 = request.getProtocol();
		System.out.println("�����Э��:" + web04.toString());
		// http1.1Э���ֳ�֮Ϊ������
		// (ͨ�Ž���, ������ͨ���ᱣ��һ��ʱ��(30s), ��ֹ�û��ڶ�ʱ�����ٴη���)
		// http1.0�����ӷ�ʽ(ͨ�Ž���֮������Ҷ�)
		
		// ��ȡ�ͻ��˵ĵ�ַ
		String addr = request.getRemoteAddr();
		if ("192.168.0.111".equals(addr)) {
			response.getWriter().println("you are confused!");
			return;
		}
		// ��ȡ�ͻ��˵�������
		String rehost = request.getRemoteHost();
		System.out.println(addr + ", " + rehost);
		// ��ȡ�ͻ��˵Ķ˿�
		System.out.println("�ͻ��˵Ķ˿�:" + request.getRemotePort());
		// ��ȡ���ط�������������ַ
		// request.getLocalAddr();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
