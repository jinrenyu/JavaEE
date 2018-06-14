package com.servlet.basic;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 使用继承HttpServlet的方式, 不需要重写service()方法
// 它根据用户的请求类型做了更加细致的划分,doGet/doPost..底层调用的还是service()方法
public class MyThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 因为servlet创建的一个单例对象, 所以会应发并发问题
	// 可以使用同步代码块或者同步方法对有限的资源进行加锁
	private int i = 0;

	public MyThirdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		i++;
		// 请求头里的Referer标识了链接的来源, 我们可以通过请求头的这个属性的
		// 值来判别一个请求的来源是否是可靠的
		String referer = request.getHeader("Referer");
		if (referer.startsWith("http://localhost:8085")) {
			System.out.println("这次请求是可靠合法的");
		}
		// 如果找不到对应的参数, 则返回null字符串
		String uname = request.getParameter("uname");
		System.out.println("用户名是:" + uname);
		System.out.println("get方式的提交被处理.....");
		System.out.println(i);
		// response.setHeader("refresh", "5; url=http://www.baidu.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*// 获取为当前servlet配置的初始化参数
		String author = getServletConfig().getInitParameter("anthor");
		// 该方法可以返回由初始化参数<param-name>所组成的枚举类型集合
		Enumeration<String> enums = getServletConfig().getInitParameterNames();
		// 遍历初始化参数的方法
		while(enums.hasMoreElements()) {
			String name = enums.nextElement();
			String value = getServletConfig().getInitParameter(name);
			System.out.println("初始化参数的名称是:" + name + "初始化参数的值是:" + value);
		}
		// 取出特定的某一个初始化参数
		System.out.println("author: " + author);*/
		// 必须在request.getParameter之前去设置解码时所用编码
		request.setCharacterEncoding("UTF-8");
		System.out.println("post方式的提交被处理.....");
		// 针对表单元素(一个name对应一个value或者只可能一次性发送过来一个数据)
		// 如果获取不到也返回null对象
		String uname = request.getParameter("uname");
		System.out.println("用户名是:" + uname);
		if("1".equals(uname)) {
			// 转发, 转向(重定向)
			/*String string = "该用户名不存在!";
			request.setAttribute("info", string);
			request.getRequestDispatcher("/ShowName")
				.forward(request, response);*/
			// 下面两行代码等价于第三行代码
			/*response.setStatus(302);
			response.addHeader("Location", "/firstweb/ShowName?uname="+uname);*/
			response.sendRedirect("/firstweb/ShowName?uname="+uname);
			
		}
		// 对于前台一个name拥有多个值的情况并且可能同时提交的表单元素, 
		// 必须使用下面的方法获取其值, 如果找不到对应的提交参数返回一个null对象
		/*String[] hobbies = request.getParameterValues("hobby");
		if (null != hobbies && hobbies.length > 0) {
			for (String string : hobbies) {
				System.out.println("复选框的值:" + string);
			}
		}*/
		/*// 前台传送过来的参数的遍历
		Map<String, String[]> parameters = request.getParameterMap();
		// map的遍历, 通过keySet()去循环遍历, 效率最低下的, 下面的遍历方式是最常用的
		for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
			System.out.println("循环遍历的参数的名称为:" + entry.getKey());
			String[] values = entry.getValue();
			if (null != values && values.length != 0) {
				for (String value : values) {
					System.out.print("对应的参数值为:" + value + ", ");
				}
			}
			System.out.println();
		}*/
		// 通过request.getParameterNames();方法也可以获取到所有的请求
		// 中name属性的值, 再通过name属性变可以获得所有的参数
		// doGet(request, response);
	}

}
