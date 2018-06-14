package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.action.LoginAction;

public class PermissionFilter implements Filter {

    public PermissionFilter() {
    }

	public void destroy() {
		System.out.println("Ȩ������������......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// ֻ��ȥ��ѯ��Ӧ��session, �����д���
		HttpSession session = req.getSession(false);
		if (session != null 
				&& session.getAttribute(LoginAction.USER_KEY) != null 
				&& session.getAttribute(LoginAction.PWD_KEY) != null) {
			// ˵�����ʵ��û��ǺϷ���, ����
			chain.doFilter(request, response);
		} else {
			// ��ת����¼����
			res.sendError(380);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Ȩ������������......");
	}

}
