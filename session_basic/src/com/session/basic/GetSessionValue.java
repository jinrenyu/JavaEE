package com.session.basic;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSessionValue")
public class GetSessionValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSessionValue() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ȼ���request.getSession(true);
		// HttpSession session = request.getSession();
		// ���Ի�ȡ��ǰ�ͻ�������Ӧ��session����, 
		// ����Ҳ���, ��Ϊ��ǰ���û������µ�session�ռ�
		HttpSession session = request.getSession(false);
		// ���Ի�ȡsession������ָ����ֵ��value, ����Ҳ����ͷ���һ��null����
		/*Date date = (Date) session.getAttribute("time");
		System.out.println(date);*/
		Enumeration<String> enums = session.getAttributeNames();
		if (enums != null) {
			while(enums.hasMoreElements()) {
				String name = enums.nextElement();
				System.out.println("��������Ϊ: " + name + "������ֵΪ: " + session.getAttribute(name));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
