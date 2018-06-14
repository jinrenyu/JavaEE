package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.service.impl.MemoryCart;

@WebServlet(urlPatterns="/book/number")
public class OrderItemChangeNumber extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1545967775302462660L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		//从坐拥域中获取cart
		MemoryCart cart = (MemoryCart) req.getSession().getAttribute("cart");
		//接收number和id
		String number = req.getParameter("number");
		String idkey = req.getParameter("idkey");
		//System.out.println("等级三级:"+number+"jds:"+idkey);
		try {
			cart.modityCount(Long.parseLong(idkey), Integer.parseInt(number));
			String str = cart.getCount()+":"+cart.getTotal()+":"+
					cart.getItems().get(Long.parseLong(idkey)).getAllPrice();
					
			
			out.print(str);
			req.getSession().setAttribute("cart", cart);
		} catch (Exception e) {
			// TODO: handle exception
			out.print("0");
			e.printStackTrace();
		}
	}
}
