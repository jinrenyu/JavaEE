package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.action.LoginAction;

public class MainFrame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 作为存储用户上一次访问时间cookie中的name属性的值
	public static final String LVISIT_KEY = "lvisit";
       
    public MainFrame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 1. 获取当期的时间, 并按照yyyy-MM-dd HH:mm:ss的方式转换成字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strNow = sdf.format(new Date());
		// 获取客户端发送过来的所有cookie信息
		Cookie[] cookies = request.getCookies();
		// 设置一个标识变量, 假设用户是第一次登录
		boolean isFirst = true;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				// 去尝试获取存储上一次访问的时间的cookie字段
				if(LVISIT_KEY.equals(cookie.getName())) {
					isFirst = false;
					out.println("您的主机上一次访问该网站的时间为: " + cookie.getValue());
					// 需要更新cookie中存储的上一次的访问时间
					cookie.setValue(strNow);
					// 大部分浏览器在发送cookie信息的时候并不会附带cookie的过期时间
					// 所以如果设置了value而不设置其存活时间, 就会造成其存活时间被覆盖
					// 为"当前会话结束", 如果需要发送可以使用js操作cookie进行发送
					cookie.setMaxAge(7 * 24 * 3600);
					// 必须把更新好的cookie重新返回给客户端
					response.addCookie(cookie);
				}
			}
		}
		// 如果是第一次登录则输出对应的提示信息, 并把当前时间存储到cookie中返回给用户
		if (isFirst) {
			out.println("这是您主机第一次访问我们的站点");
			Cookie lTime = new Cookie(LVISIT_KEY, strNow);
			// 让cookie存活一周的时间
			lTime.setMaxAge(7 * 24 * 3600);
			response.addCookie(lTime);
		}
		out.println("<p>您是本网站的第" + getServletContext().getAttribute(LoginAction.VISIT_COUNT) + "位访客</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
