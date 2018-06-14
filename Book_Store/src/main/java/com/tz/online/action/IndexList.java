package com.tz.online.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;


@WebServlet(urlPatterns = "/book/list")
public class IndexList extends HttpServlet{

	private static final long serialVersionUID = -3462708461510192504L;

	private IBookService bookservice = (IBookService) BeanFactory.createBeans("bookService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String flag = req.getParameter("flag");
		
		PageBean<Book> pageBean1=null;
		if(flag!=null && "1".equals(flag)){			
			String pageNow = req.getParameter("pageNow");		
				pageBean1= bookservice.findByPage(null, "精选图书", Long.parseLong(pageNow), 4);
		}else{
			    pageBean1= bookservice.findByPage(null, "精选图书", 1, 4);
		}
			
		
		PageBean<Book> pageBean2 = null;
		if(flag !=null && "2".equals(flag)){
			String pageNow = req.getParameter("pageNow");
			pageBean2= bookservice.findByPage(null, "推荐图书", Long.parseLong(pageNow), 4);
			
		}else{
			pageBean2= bookservice.findByPage(null, "推荐图书", 1, 4);
			
		}
		
		PageBean<Book> pageBean3 = null;
		if(flag !=null && "3".equals(flag)){
			String pageNow = req.getParameter("pageNow");
			pageBean3= bookservice.findByPage(null, "特价图书", Long.parseLong(pageNow), 4);
		}else{
			pageBean3= bookservice.findByPage(null, "特价图书", 1, 4);
		}
		
		
		
			
		req.setAttribute("pageBean1", pageBean1);
		req.setAttribute("pageBean2", pageBean2);
		req.setAttribute("pageBean3", pageBean3);
		
		//转发到/book/index
		req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
	}
}
