package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;

@WebServlet("/book/checkUserName")
public class CheckUserLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5309778707800562303L;
	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String userName = req.getParameter("userName");
		
		//System.out.println(userName);
		boolean flag=userService.validate(userName);
		if(flag || "".equals(userName)){
			out.print("ok");
		}else{
			out.print("用户不存在!");
		}
	
		
	}
}
