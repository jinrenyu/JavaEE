package com.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {
	
	private final String DEFALUE_ENCODING = "UTF-8";
	private final String DEFALUE_CONTENT_TYPE = "text/html";
	private final String ENCODING_KEY = "encode";
	private final String CONTENT_TYPE_KEY = "contentType";
	private String encode;
	private String contentType;

	public EncodeFilter() {
	}

	public void destroy() {
		encode = null;
		contentType = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encode);
		response.setContentType(contentType);
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encode = fConfig.getInitParameter(ENCODING_KEY);
		contentType = fConfig.getInitParameter(CONTENT_TYPE_KEY);
		if (null == encode) {
			encode = DEFALUE_ENCODING;
		}
		if (null == contentType) {
			contentType = DEFALUE_CONTENT_TYPE;
		}
	}

}
