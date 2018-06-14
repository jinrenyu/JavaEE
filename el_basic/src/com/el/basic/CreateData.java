package com.el.basic;

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

import com.el.entity.Address;
import com.el.entity.User;

@WebServlet("/CreateData")
public class CreateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User("u001", "1234567");
		Address address = new Address("P001", "C001");
		user.setAddress(address);
		List<User> list = new ArrayList<>();
		list.add(user);
		Map<String, User> map = new HashMap<>();
		map.put("user01", user);
		map.put("1", user);
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(2, "HHHHHH");
		Map<Long, String> map3 = new HashMap<>();
		map3.put(new Long(3), "HHHHHH");
		request.setAttribute("list01", list);
		request.setAttribute("u1", user);
		request.setAttribute("m1", map);
		request.setAttribute("m2", map2);
		request.setAttribute("m3", map3);
		request.getRequestDispatcher("/el_basic.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
