package com.tz.online.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

@WebServlet(urlPatterns="/book/style")
public class BooksList extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IBookService bookservice = (IBookService) BeanFactory.createBeans("bookService");
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fly = req.getParameter("fly");
		List<Book> book = null;
		if(null != fly && "1".equals(fly)){
			book = bookservice.fingByCategory("精选图书");
		}else if("2".equals(fly)){
			book = bookservice.fingByCategory("推荐图书");
		}else if("3".equals(fly)){
			book = bookservice.fingByCategory("特价图书");
		}
		
//		System.out.println("book:"+book);
		req.setAttribute("book", book);
		req.setAttribute("fly", fly);
		//转发到
		req.getRequestDispatcher("/jsp/books_list.jsp").forward(req, resp);
	}
}
