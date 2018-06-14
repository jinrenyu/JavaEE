package com.session.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetContext
 */
@WebServlet("/GetContext")
public class GetContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = (String) getServletContext().getAttribute("test");
		response.getWriter().println(str);
		System.out.println(getServletContext().getInitParameter("global"));
		// 因为它自动以web应用目录(WebContent)为根路径, 所以此处可以写绝对路径也可以写先相对路径(相对于WebContent)
		InputStream in = getServletContext().getResourceAsStream("/jdbc.properties");
		Properties prop = new Properties();
		prop.load(in);
		System.out.println(prop.getProperty("url"));
		System.out.println(getServletContext().getRealPath("/jdbc.properties"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
