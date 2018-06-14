package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.action.LoginAction;

public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʹ��getContextPathȥ��ȡ�û����͹�����webӦ������
		// ��ֹ���webӦ�������ܷ����ı�, ������Զ��������
		String path = request.getContextPath();
		String info = request.getParameter(LoginAction.INFO_KEY);
		String uname = "";
		String uPwd = "";
		String uInput = "";
		// ��ȡ�û����͹���������cookies������Ϣ
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// ȡ���û�������Ϣ
				if (LoginAction.USER_KEY.equals(cookie.getName())) {
					uname = URLDecoder.decode(cookie.getValue(), "utf-8");
				}
				if (LoginAction.PWD_KEY.equals(cookie.getName())) {
					uPwd = cookie.getValue();
					uInput = "12345678";
				}
			}
		}
		// 1. �����Ӧ����������
		// response.setContentType("text/html;charset=utf-8");
		// response.setCharacterEncoding("utf-8");
		// 2. �õ����ͻ��˷����ַ������������
		PrintWriter out = response.getWriter();
		// 3. ʹ���ַ����������ʼ��дҳ�����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�û���¼ҳ��ʵ��</title>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("/HeaderServlet")
			.include(request, response);
		out.println("<h2>�û���¼ҳ��</h2>");
		out.println("<form action='" + path + "/LoginAction' method='post'>");
		out.println("�û���:<input type='text' name='uname' value='" + uname + "'>");
		if (null != info && "101".equals(info)) {
			out.println("<span style='color:red;'>�û���������</span>");
		}
		out.println("<br/>");
		out.println("��&nbsp;��:<input type='password' id='uinPwd' value='" + uInput + "' onchange='clearPwd();'>");
		out.println("<input type='hidden' name='pwd' value='" + uPwd + "'>");
		out.println("<input type='hidden' name='md'>");
		if (null != info && "102".equals(info)) {
			out.println("<span style='color:red;'>�û��������</span>");
		}
		out.println("<br/>");
		out.print("��֤��:<input type='text' name='ctoken'><img src='"+path+"/token' onclick='huan();'>");
		if (null != info && "103".equals(info)) {
			out.println("<span style='color:red;'>��֤�����</span>");
		}
		out.println("<br/>");
		out.println("<input type='checkbox' name='rPwd'>�Ƿ��ס����<br/>");
		out.println("<input type='submit' value='�ύ' onclick='takePwd();'>");
		out.println("</form>");
		request.getRequestDispatcher("/FooterServlet")
			.include(request, response);
		out.println("<script type='text/javascript'>");
		out.println("function takePwd() {");
		out.println("var nodePwd = document.forms[0].pwd;");
		out.println("if(nodePwd.value == '') {nodePwd.value = document.getElementById('uinPwd').value}");
		out.println("else {document.forms[0].md.value = '1'}");
		out.println("}");
		out.println("function clearPwd() {");
		out.println("document.forms[0].pwd.value='';");
		out.println("document.forms[0].md.value='';");
		out.println("}");
		out.println("function huan() {");
		out.println("document.images[0].src='"+path+"/token#' + new Date().getTime();");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
