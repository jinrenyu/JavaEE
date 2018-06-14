package com.ajax.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.service.AreaService;
import com.ajax.service.impl.AreaServiceImpl;

@WebServlet("/AreaAction")
public class AreaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AreaService areaService = new AreaServiceImpl();
       
    public AreaAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String code = request.getParameter("cCode");
		String areaInfo = areaService.getJSONAreaStr(code);
		response.getWriter().print(areaInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
