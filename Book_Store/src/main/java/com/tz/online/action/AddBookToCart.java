package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.entity.OrderItem;
import com.tz.online.service.IBookService;
import com.tz.online.service.impl.MemoryCart;
import com.tz.online.util.BeanFactory;

@WebServlet(urlPatterns = "/book/addtocart")
public class AddBookToCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5358884126996342690L;
	private IBookService bookService = (IBookService) BeanFactory.createBeans("bookService");

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// 获得购买数量
		String buynumbers = req.getParameter("buynumber");
		int buynumber = Integer.parseInt(buynumbers);

		Book bookDetail = (Book) req.getSession().getAttribute("bookDetails");

		System.out.println("bookDetail" + bookDetail.toString());

		// 获取此次购买图书的总价格
		double allprice = bookDetail.getNewPrice() * (buynumber);
		OrderItem orderItem = new OrderItem();

		MemoryCart cart = (MemoryCart) req.getSession().getAttribute("cart");

		int count = cart == null ? 0 : cart.getCount();

		double total = cart == null ? 0 : cart.getTotal();

		if (null == cart) {

			cart = new MemoryCart();
			count = cart.getCount();
			total = cart.getTotal();

			count = buynumber;
			total = allprice;

			orderItem.setBook(bookDetail);
			orderItem.setAllPrice(allprice);
			orderItem.setCount(buynumber);

			cart.addCart(orderItem);

			req.getSession().setAttribute("total", total);
			req.getSession().setAttribute("cart", cart);

			out.print(count + ":" + total);

		} else {

			Map<Long, OrderItem> map = cart.getItems();

			if (map.containsKey(bookDetail.getBookId())) {
				OrderItem order = cart.find(bookDetail.getBookId());
				int ordercount = order.getCount();
				buynumber = ordercount + buynumber;

				count = count + buynumber - ordercount;
				total = total + bookDetail.getNewPrice() * (buynumber - ordercount);

				orderItem.setBook(bookDetail);
				orderItem.setAllPrice(allprice + order.getAllPrice());
				orderItem.setCount(buynumber);

				cart.addCart(orderItem);
				req.getSession().setAttribute("cart", cart);

			} else {
				count = count + buynumber;
				total = total + bookDetail.getNewPrice() * (buynumber);

				orderItem.setBook(bookDetail);
				orderItem.setAllPrice(allprice);
				orderItem.setCount(buynumber);

				cart.addCart(orderItem);

				req.getSession().setAttribute("cart", cart);

			}

			out.print(count + ":" + total);

			System.out.println("items对象" + cart.getItems());

			// 转发到jap/detail.jap页面
			 req.getRequestDispatcher("/jsp/cart.jsp").forward(req, resp);

		}
	}
}
