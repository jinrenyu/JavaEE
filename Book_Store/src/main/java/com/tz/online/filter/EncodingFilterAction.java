package com.tz.online.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

/**
 * 利用Filter过滤器来处理编码
 * 
 * /*是过滤所有的请求..
 * 
 * @author teacher
 * 
 * @version 1.0
 * @createDate 2017年2月22日 上午10:54:17
 * @description 此类的功能性描述
 */
@WebFilter(filterName="EncodingFilterAction",urlPatterns="/*")
public class EncodingFilterAction implements Filter{

	String encoding;
	String contentType;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁过滤器对象");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		//专门处理post乱码
		req.setCharacterEncoding("utf-8");
		//设置文档类型.
		resp.setContentType("text/html;charset=utf-8");
		
		//放行
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("创建过滤器对象");
		
		encoding = config.getInitParameter("encoding");
		contentType = config.getInitParameter("contentType");
		
	}
}
