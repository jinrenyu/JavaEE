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
		// ��ֹ��������
		response.setCharacterEncoding("utf-8");
		// ��������·���г���web��Դ��Ϣ�Լ���ѯ��Ϣ֮��Ķ�����Ϣ·��
		// ����http://localhost:8085/ajax_basic/province/getall?name=123&age=23
		// ����http://localhost:8085/ajax_basic/province/main.html
		// getPathInfo()�������Է���/getall, ͨ���õ���ֵ�Ϳ���������ͬ����Ӧ
		String pathInfo = request.getPathInfo();
		if ("/getAll".equals(pathInfo)) {
			String jsonStr = provinceService.getJSONProvincesStr();
			// ����ʡ����Ϣ��JSON�ַ���
			response.getWriter().print(jsonStr);
		} else if ("/main.html".equals(pathInfo)) {
			// ȡ�����е�ʡ�ݶ����¼, �����ظ�չʾ��ǰ̨ҳ��
			// ��ʾ��ǰ��ҳ��
			int currentPage = 1;
			// ÿҳ��ʾ�ļ�¼��
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
				System.out.println("��������...");
			}
			
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("provinces", provinces);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("begin", begin);
			request.setAttribute("end", end);
			request.getRequestDispatcher("/data.jsp").forward(request, response);
		} else {
			System.out.println("URL�Ķ���·����ϢΪ:" + pathInfo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
