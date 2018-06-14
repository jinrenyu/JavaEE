package com.tz.online.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/book/exit")
public class ExitLogin extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			//清空session
			req.getSession().invalidate();
			//重定向到登录界面
			resp.sendRedirect(req.getContextPath()+"/book/list");
	
}
	
}
