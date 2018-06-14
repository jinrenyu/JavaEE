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
		// 它会尝试获取当前客户端所对应的session对象
		// 如果当前客户端在web服务器内部没有对应的session对象, 则创建一个session对象
		// 即为当前的客户端进程单独在服务器开辟一块内存区域供其存储信息
		HttpSession session = request.getSession();
		// 参数1: key名称(String类型), 参数2: Object类型(key所对应的value值)
		// session.setAttribute("time", new Date());
		session.setAttribute("time", "time");
		session.setAttribute("age", 13);
		// 设置当前session的最大空闲时间为30秒
		// session.setMaxInactiveInterval(10);
		// session.removeAttribute("time");
		// 怎么获取session的JSEESIONID的值
		String sid = session.getId();
		// 这个Cookie的name的只能使用JSEESIONID
		Cookie cookie = new Cookie("JSESSIONID", sid);
		cookie.setMaxAge(5 * 60);
		response.addCookie(cookie);
		// 用于解绑当前session所有关联的参数, 多用于"安全退出"
//		session.invalidate();
		String url = response.encodeURL("/session_basic/GetSessionValue");
		response.getWriter().println("<a href='"+url+"'>go</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
