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

@WebServlet("/book/checkUserPassWord")
public class CheckUserLoginpwd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String upd = req.getParameter("upd");
		String passWord = upd.split(":")[0];
		String userName =upd.split(":")[1];
//		System.out.println("upd..."+upd);
//		System.out.println("username"+userName);
//		System.out.println("passWord"+passWord);
		try {
			User u =userService.login(userName, null);
			boolean b = (u.getPassWord().equals(passWord)?true:false);
			System.out.println("bbbbb"+b);
			if(b){
				out.print("ok");
			}else{
				out.print("密码不正确!");
			}
			
			
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
