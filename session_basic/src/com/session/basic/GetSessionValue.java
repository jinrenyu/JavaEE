package com.session.basic;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSessionValue")
public class GetSessionValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSessionValue() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 等价于request.getSession(true);
		// HttpSession session = request.getSession();
		// 尝试获取当前客户端所对应的session对象, 
		// 如果找不到, 不为当前的用户开辟新的session空间
		HttpSession session = request.getSession(false);
		// 尝试获取session对象中指定键值的value, 如果找不到就返回一个null对象
		/*Date date = (Date) session.getAttribute("time");
		System.out.println(date);*/
		Enumeration<String> enums = session.getAttributeNames();
		if (enums != null) {
			while(enums.hasMoreElements()) {
				String name = enums.nextElement();
				System.out.println("参数名称为: " + name + "参数的值为: " + session.getAttribute(name));
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
