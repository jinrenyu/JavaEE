package com.tz.online.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Address;
import com.tz.online.entity.OrderItem;
import com.tz.online.entity.User;
import com.tz.online.service.IShoppingCart;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;

/**
 * Servlet implementation class addressList
 */
@WebServlet("/address/list")
public class addressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IShoppingCart shoppingCart =(IShoppingCart) BeanFactory.createBeans("shoppingCart");
	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addressList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("ids");

		String[] arr = ids.split(":");// 把接收到的ID分开成数组
		/**
		 * 构建一个商品详情的集合，遍历Id数组，通过id查找每个商品详情
		 * 并且将得到的商品详情放入商品详情的集合，并且转发到确认订单的页面
		 */
		Map<Long,OrderItem> items = new HashMap<>();
		for (String id : arr) {
			OrderItem item =shoppingCart.find(Long.valueOf(id));
			items.put(Long.parseLong(id), item);
		}
		req.getSession().setAttribute("ids", ids);
		req.getSession().setAttribute("items", items);
		//获取缓存中的user对象
		User user =(User) req.getSession().getAttribute("user");
		List<Address> addre =userService.getAddressByUserId(user.getUserId());	
		//addrs.add(address);
		req.getSession().setAttribute("addre", addre);
		req.getRequestDispatcher("/jsp/confirm_order.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
