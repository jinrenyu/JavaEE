package com.ajax.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.service.CityService;
import com.ajax.service.impl.CityServiceImpl;

@WebServlet("/CityAction")
public class CityAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CityService cityService = new CityServiceImpl();
       
    public CityAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String code = request.getParameter("pCode");
		String citiesInfo = cityService.getJSONCityStr(code);
		response.getWriter().print(citiesInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
