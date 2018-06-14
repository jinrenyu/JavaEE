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
		// 解决post请求中的中文乱码问题
		// request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		HttpSession session = request.getSession();
		// 1. 获取用户名和密码
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		// 获取用户是否勾选了记住密码选项
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
			// 登录成功
			Integer count = (Integer) getServletContext().getAttribute(VISIT_COUNT);
			// 第一位用户成功登录ServletContext中肯定没有对应值
			if (null == count) {
				getServletContext().setAttribute(VISIT_COUNT, 1);
			} else {
				getServletContext().setAttribute(VISIT_COUNT, count + 1);
			}
			// 把登录成功后的用户名和密码存储到session中
			session.setAttribute(USER_KEY, username);
			session.setAttribute(PWD_KEY, password);
			Cookie cName = new Cookie(USER_KEY, URLEncoder.encode(username, "utf-8"));
			cName.setMaxAge(24 * 7 * 3600);
			response.addCookie(cName);
			// 说明用户勾选了记住密码选项
			if (null != rPwd) {
				// 创建Cookie用于保存用户登录的密码, 并把密码加密后存储进该Cookie
				Cookie cPwd = new Cookie(PWD_KEY, CreateMD5.getMd5(password));
				cName.setMaxAge(24 * 7 * 3600);
				response.addCookie(cPwd);
			} else {
				// 采用Cookie覆盖去把用户本地的存储用户密码的cookie进行覆盖
				Cookie cPwd = new Cookie(PWD_KEY, "");
				// 设置一个极短的过期时间
				cPwd.setMaxAge(1);
				response.addCookie(cPwd);
			}
			// 防止主界面刷新提交变量增加, 可以把下面的转发换成重定向
			request.getRequestDispatcher("/MainFrame.do")
				.forward(request, response);
		} else {
			// 登录不成功, 连同提示信息一起返回给登录界面
			// 1. forward转发 2. 使用重定向
			// 如果转发和重定向能够实现相同的功能, 则首选转发(forward)
			// 如果需要把提示重新返回给原先的页面, 则不能使用转发, 会造成
			// 刷新重新提交表单的问题, 只能使用重定向
			response.sendRedirect(path + "/LoginView?" + INFO_KEY + "=" + info);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
