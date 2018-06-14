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
		System.out.println("权限拦截器销毁......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 只是去查询对应的session, 不进行创建
		HttpSession session = req.getSession(false);
		if (session != null 
				&& session.getAttribute(LoginAction.USER_KEY) != null 
				&& session.getAttribute(LoginAction.PWD_KEY) != null) {
			// 说明访问的用户是合法的, 放行
			chain.doFilter(request, response);
		} else {
			// 跳转到登录界面
			res.sendError(380);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("权限拦截器启动......");
	}

}
