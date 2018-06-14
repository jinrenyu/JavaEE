package com.servlet.basic;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ʹ�ü̳�HttpServlet�ķ�ʽ, ����Ҫ��дservice()����
// �������û��������������˸���ϸ�µĻ���,doGet/doPost..�ײ���õĻ���service()����
public class MyThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ��Ϊservlet������һ����������, ���Ի�Ӧ����������
	// ����ʹ��ͬ����������ͬ�����������޵���Դ���м���
	private int i = 0;

	public MyThirdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		i++;
		// ����ͷ���Referer��ʶ�����ӵ���Դ, ���ǿ���ͨ������ͷ��������Ե�
		// ֵ���б�һ���������Դ�Ƿ��ǿɿ���
		String referer = request.getHeader("Referer");
		if (referer.startsWith("http://localhost:8085")) {
			System.out.println("��������ǿɿ��Ϸ���");
		}
		// ����Ҳ�����Ӧ�Ĳ���, �򷵻�null�ַ���
		String uname = request.getParameter("uname");
		System.out.println("�û�����:" + uname);
		System.out.println("get��ʽ���ύ������.....");
		System.out.println(i);
		// response.setHeader("refresh", "5; url=http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*// ��ȡΪ��ǰservlet���õĳ�ʼ������
		String author = getServletConfig().getInitParameter("anthor");
		// �÷������Է����ɳ�ʼ������<param-name>����ɵ�ö�����ͼ���
		Enumeration<String> enums = getServletConfig().getInitParameterNames();
		// ������ʼ�������ķ���
		while(enums.hasMoreElements()) {
			String name = enums.nextElement();
			String value = getServletConfig().getInitParameter(name);
			System.out.println("��ʼ��������������:" + name + "��ʼ��������ֵ��:" + value);
		}
		// ȡ���ض���ĳһ����ʼ������
		System.out.println("author: " + author);*/
		// ������request.getParameter֮ǰȥ���ý���ʱ���ñ���
		request.setCharacterEncoding("UTF-8");
		System.out.println("post��ʽ���ύ������.....");
		// ��Ա�Ԫ��(һ��name��Ӧһ��value����ֻ����һ���Է��͹���һ������)
		// �����ȡ����Ҳ����null����
		String uname = request.getParameter("uname");
		System.out.println("�û�����:" + uname);
		if("1".equals(uname)) {
			// ת��, ת��(�ض���)
			/*String string = "���û���������!";
			request.setAttribute("info", string);
			request.getRequestDispatcher("/ShowName")
				.forward(request, response);*/
			// �������д���ȼ��ڵ����д���
			/*response.setStatus(302);
			response.addHeader("Location", "/firstweb/ShowName?uname="+uname);*/
			response.sendRedirect("/firstweb/ShowName?uname="+uname);
			
		}
		// ����ǰ̨һ��nameӵ�ж��ֵ��������ҿ���ͬʱ�ύ�ı�Ԫ��, 
		// ����ʹ������ķ�����ȡ��ֵ, ����Ҳ�����Ӧ���ύ��������һ��null����
		/*String[] hobbies = request.getParameterValues("hobby");
		if (null != hobbies && hobbies.length > 0) {
			for (String string : hobbies) {
				System.out.println("��ѡ���ֵ:" + string);
			}
		}*/
		/*// ǰ̨���͹����Ĳ����ı���
		Map<String, String[]> parameters = request.getParameterMap();
		// map�ı���, ͨ��keySet()ȥѭ������, Ч������µ�, ����ı�����ʽ����õ�
		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
			System.out.println("ѭ�������Ĳ���������Ϊ:" + entry.getKey());
			String[] values = entry.getValue();
			if (null != values && values.length != 0) {
				for (String value : values) {
					System.out.print("��Ӧ�Ĳ���ֵΪ:" + value + ", ");
				}
			}
			System.out.println();
		}*/
		// ͨ��request.getParameterNames();����Ҳ���Ի�ȡ�����е�����
		// ��name���Ե�ֵ, ��ͨ��name���Ա���Ի�����еĲ���
		// doGet(request, response);
	}

}
