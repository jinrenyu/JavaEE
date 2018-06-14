package com.session.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���᳢�Ի�ȡ��ǰ�ͻ�������Ӧ��session����
		// �����ǰ�ͻ�����web�������ڲ�û�ж�Ӧ��session����, �򴴽�һ��session����
		// ��Ϊ��ǰ�Ŀͻ��˽��̵����ڷ���������һ���ڴ�������洢��Ϣ
		HttpSession session = request.getSession();
		// ����1: key����(String����), ����2: Object����(key����Ӧ��valueֵ)
		// session.setAttribute("time", new Date());
		session.setAttribute("time", "time");
		session.setAttribute("age", 13);
		// ���õ�ǰsession��������ʱ��Ϊ30��
		// session.setMaxInactiveInterval(10);
		// session.removeAttribute("time");
		// ��ô��ȡsession��JSEESIONID��ֵ
		String sid = session.getId();
		// ���Cookie��name��ֻ��ʹ��JSEESIONID
		Cookie cookie = new Cookie("JSESSIONID", sid);
		cookie.setMaxAge(5 * 60);
		response.addCookie(cookie);
		// ���ڽ��ǰsession���й����Ĳ���, ������"��ȫ�˳�"
//		session.invalidate();
		String url = response.encodeURL("/session_basic/GetSessionValue");
		response.getWriter().println("<a href='"+url+"'>go</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
