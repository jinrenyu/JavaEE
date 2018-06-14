package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.service.impl.MemoryCart;

@WebServlet(urlPatterns="/book/delete")
public class OrderItemDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6157443083693645432L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session作用域中的cart
		MemoryCart cart = (MemoryCart) req.getSession().getAttribute("cart");
		
		PrintWriter out = resp.getWriter();
		
		try {
			//获取接收数据
			String ids = req.getParameter("ids");
			
			//将id进行切割成id数组
			String[] arr = ids.substring(0, ids.length()-1).split(":");
			
			for(String id : arr){
				cart.delete(Long.parseLong(id));
				
			}
			
			out.print("1");
			
		} catch (Exception e) {
			out.print("0");
			e.printStackTrace();
		}
	}
}
