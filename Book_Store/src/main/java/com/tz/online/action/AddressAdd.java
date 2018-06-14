package com.tz.online.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;

/**
 * Servlet implementation class AddressAdd
 */
@WebServlet("/address/add")
public class AddressAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = (IUserService) BeanFactory.createBeans("userService");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		/**
		 * 获取页面发过来的信息
		 */
		String province =req.getParameter("province");
		String city =req.getParameter("city");
		String area =req.getParameter("area");
		String baseAddress=province+","+city+","+area;
		String detailAddress=req.getParameter("address_detail");
		String reciver = req.getParameter("reciverName");
		//邮编
		String code =req.getParameter("code");
		System.out.println("city:"+city);
		String tel =req.getParameter("tel");
		String isDefault=req.getParameter("defaultaddress");
		isDefault = isDefault==null?"0":isDefault;
		//获取缓存中的user对象
		User user =(User) req.getSession().getAttribute("user");
		List<Address> addrs =userService.getAddressByUserId(user.getUserId());
		if(null!=addrs){
			for(int i=0;i<=addrs.size()-1;i++){
				addrs.get(i).setIsDefault("0");
				userService.updAddress(addrs.get(i));
			}
		}
			// 创建一个地址对象,并且封装对象
			Address address = new Address();
			address.setEmailCode(code);
			address.setReciver(reciver);
			address.setDetailAddress(detailAddress);
			address.setTel(tel);
			address.setArea(baseAddress);
			address.setIsDefault(isDefault);
			address.setUser(user);
			
			userService.addAddress(address);
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
