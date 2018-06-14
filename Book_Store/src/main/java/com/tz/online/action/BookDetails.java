package com.tz.online.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

@WebServlet(urlPatterns="/book/details")
public class BookDetails extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7390713132643659726L;

	private IBookService bookService = (IBookService) BeanFactory.createBeans("bookService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookId = req.getParameter("bookId");
		
		Book bookDetails = bookService.findById(Long.parseLong(bookId));
		
		req.getSession().setAttribute("bookDetails", bookDetails);
		
		//转发到jap/detail.jap页面
		req.getRequestDispatcher("/jsp/detail.jsp").forward(req, resp);
	}
}
