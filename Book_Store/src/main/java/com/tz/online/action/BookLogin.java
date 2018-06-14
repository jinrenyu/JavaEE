package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;

@WebServlet(urlPatterns = "/book/login")
public class BookLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String userName = req.getParameter("userName");
		
		String passWord = req.getParameter("passWord");
		// 判断是否选中了密码
		String pwd = req.getParameter("pwd");
		// 调取业务层逻辑的方法
		try {
			User user = userService.login(userName, null);

			// 判断学生是否存在...
			if (null != user) {
				// 判断学生密码是否正确.
				if (user.getPassWord().equals(passWord)) {

					// 将user对象放入到session作用域
					HttpSession ses = req.getSession();

					ses.setAttribute("user", user);

					if (null != pwd) {
						// 利用cookie来实现记住密码.
						String login = "loginName";
						String value = URLEncoder.encode(userName) + ":" + passWord;
						// 创建一个cookie
						Cookie c = new Cookie(login, value);
						// 设置最大有效期
						c.setMaxAge(60 * 60 * 24 * 7);
						// 设置路径
						c.setPath("/");
						// 通过httpServletResponse对象[通过响应头信息]将cookie写入到客户端
						resp.addCookie(c);
					}
					// 登录成功...
					// 进行二级编码
					resp.sendRedirect(req.getContextPath() + "/book/list");
					
					req.setAttribute("user", user);
				} else {
				
				}
			} else {
			
			}
		} catch (LoginException e) {

			e.printStackTrace();
		}

	
	}

}
