package com.servlet.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.service.LoginService;
import com.servlet.service.impl.LoginServiceImpl;
import com.servlet.util.CreateMD5;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String INFO_KEY = "info";
	public static final String USER_KEY = "userkey";
	public static final String PWD_KEY = "pwdkey";
	public static final String VISIT_COUNT = "count";
	private LoginService loginService = new LoginServiceImpl();

	public LoginAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���post�����е�������������
		// request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		// 1. ��ȡ�û���������
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		// ��ȡ�û��Ƿ�ѡ�˼�ס����ѡ��
		String rPwd = request.getParameter("rPwd");
		String md = request.getParameter("md");
		String token = request.getParameter("ctoken");
		String rtoken = (String) session.getAttribute("token");
		if (rtoken != null && token != null && 
				token.equals(rtoken)) {
		} else {
			response.sendRedirect(path + "/LoginView?" + INFO_KEY + "=" + LoginService.TOKEN_ERROR);
			return;
		}
		String info = loginService.checkUser(username, password, md);
		if (info != null && LoginService.LOGIN_SUCCESS.equals(info)) {
			// ��¼�ɹ�
			Integer count = (Integer) getServletContext().getAttribute(VISIT_COUNT);
			// ��һλ�û��ɹ���¼ServletContext�п϶�û�ж�Ӧֵ
			if (null == count) {
				getServletContext().setAttribute(VISIT_COUNT, 1);
			} else {
				getServletContext().setAttribute(VISIT_COUNT, count + 1);
			}
			// �ѵ�¼�ɹ�����û���������洢��session��
			session.setAttribute(USER_KEY, username);
			session.setAttribute(PWD_KEY, password);
			Cookie cName = new Cookie(USER_KEY, URLEncoder.encode(username, "utf-8"));
			cName.setMaxAge(24 * 7 * 3600);
			response.addCookie(cName);
			// ˵���û���ѡ�˼�ס����ѡ��
			if (null != rPwd) {
				// ����Cookie���ڱ����û���¼������, ����������ܺ�洢����Cookie
				Cookie cPwd = new Cookie(PWD_KEY, CreateMD5.getMd5(password));
				cName.setMaxAge(24 * 7 * 3600);
				response.addCookie(cPwd);
			} else {
				// ����Cookie����ȥ���û����صĴ洢�û������cookie���и���
				Cookie cPwd = new Cookie(PWD_KEY, "");
				// ����һ�����̵Ĺ���ʱ��
				cPwd.setMaxAge(1);
				response.addCookie(cPwd);
			}
			// ��ֹ������ˢ���ύ��������, ���԰������ת�������ض���
			request.getRequestDispatcher("/MainFrame.do")
				.forward(request, response);
		} else {
			// ��¼���ɹ�, ��ͬ��ʾ��Ϣһ�𷵻ظ���¼����
			// 1. forwardת�� 2. ʹ���ض���
			// ���ת�����ض����ܹ�ʵ����ͬ�Ĺ���, ����ѡת��(forward)
			// �����Ҫ����ʾ���·��ظ�ԭ�ȵ�ҳ��, ����ʹ��ת��, �����
			// ˢ�������ύ��������, ֻ��ʹ���ض���
			response.sendRedirect(path + "/LoginView?" + INFO_KEY + "=" + info);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
