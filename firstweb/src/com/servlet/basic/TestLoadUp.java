package com.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestLoadUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestLoadUp() {
        super();
        System.out.println("�һ�����Ӧ�÷���������������ʵ������....");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("�һ�����Ӧ�÷��������������г�ʼ��...");
    	super.init();
    	// �˴�������дϵͳ��ʼ�����������߶�ʱ������
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
