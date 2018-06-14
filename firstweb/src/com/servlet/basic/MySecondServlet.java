package com.servlet.basic;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MySecondServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public MySecondServlet() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("返回一个服务");
	}

}
