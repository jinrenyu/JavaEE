package com.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class SecondFilter implements Filter {


	public SecondFilter() {
	}

	// ��webӦ�ùر�/����/���²����ʱ��, �ͻ���ø�destroy��������ɹ�����������
	public void destroy() {
		System.out.println("�ڶ���������������......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ����һ�зֽ��ߴ���, д�����д���֮ǰ��ʾ���û����͹������������һЩ����
		System.out.println("�ڶ������������������");
		chain.doFilter(request, response);
		// д�����д���֮��, ��ʾ�Է�������Ӧ����Ϣ���д���
		System.out.println("�ڶ�������������Ӧ����");
	}

	// ��servletһ��, ������filterͬ����Ҫ������ʼ�����ٵĹ���
	// ���ǵ�Ӧ�ó���������ʱ����������init��������ɶԹ������ĳ�ʼ��
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("�ڶ���������������.....");
	}

}
