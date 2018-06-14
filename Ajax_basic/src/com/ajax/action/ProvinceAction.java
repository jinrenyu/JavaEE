package com.ajax.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.service.ProvinceService;
import com.ajax.service.impl.ProvinceServiceImpl;
import com.ajax.vo.Province;

@WebServlet("/province/*")
public class ProvinceAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProvinceService provinceService = new ProvinceServiceImpl();

	public ProvinceAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 防止中文乱码
		response.setCharacterEncoding("utf-8");
		// 返回请求路径中除了web资源信息以及查询信息之外的额外信息路径
		// 比如http://localhost:8085/ajax_basic/province/getall?name=123&age=23
		// 比如http://localhost:8085/ajax_basic/province/main.html
		// getPathInfo()方法可以返回/getall, 通过得到的值就可以做出不同的响应
		String pathInfo = request.getPathInfo();
		if ("/getAll".equals(pathInfo)) {
			String jsonStr = provinceService.getJSONProvincesStr();
			// 返回省份信息的JSON字符串
			response.getWriter().print(jsonStr);
		} else if ("/main.html".equals(pathInfo)) {
			// 取出所有的省份对象记录, 并返回给展示的前台页面
			// 表示当前的页面
			int currentPage = 1;
			// 每页显示的记录数
			int pageCount = 5;
			String temp = request.getParameter("page");
			if (null != temp) {
				currentPage = Integer.parseInt(temp);
			}
			List<Province> provinces = provinceService.getProvincesByPage(currentPage, pageCount);
			int totalPage = provinceService.getTotalPage(pageCount);
			
			
			int fixedNum = 2;
			int begin = 1;
			int end = totalPage;
			if (currentPage - fixedNum > 0 && currentPage + fixedNum <= totalPage) {
				begin = currentPage - fixedNum;
				end = currentPage + fixedNum;
			} else if (currentPage - fixedNum > 0 && currentPage + fixedNum > totalPage) {
				if (totalPage - 2 * fixedNum > 0) {
					begin = totalPage - 2 * fixedNum;
				}
			} else if (currentPage - fixedNum <= 0 && currentPage + fixedNum < totalPage){
				if (2 * fixedNum + 1 < totalPage) {
					end = 2 * fixedNum + 1;;
				}
			} else {
				System.out.println("另外的情况...");
			}
			
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("provinces", provinces);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("begin", begin);
			request.setAttribute("end", end);
			request.getRequestDispatcher("/data.jsp").forward(request, response);
		} else {
			System.out.println("URL的额外路径信息为:" + pathInfo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
