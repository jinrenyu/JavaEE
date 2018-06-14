<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page import="com.jsp.entity.User" errorPage="errorPage.jsp" info="测试页面" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP的第一个实例</title>
	</head>
	<body>
		<!-- html注释 -->
		
		
		
		
		
		<p>welcome learning JSP!</p>
		<%
			// int o = 1/0;
			User user = new User();
			user.setUsername("u1");
			user.setPwd("p1");
			Date date = new Date();
			String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
			// abc
			int i = 0;
			/*
			 * hahah
			 */
			int j = 1;
			System.out.println("JAVA SERVER PAGE");
			if (i > j) {
		%>
		<%-- JSP --%>
		<p>i is greater than j</p>
		<%
			} else {
		%>
		<p>i is less than j</p>
		<%
			}
			info();
		%>
		<%= getServletInfo() %>
		<%= user %>
		<%= now %>
		<%= str %>
		<%= j %>
		<%= i + j %>
		<%= "teststr" %>
		<%! 
			public String str = "ccccccc";
			public void info() {
				System.out.print("info");
			}
		%>
		<p>当前JSP页面的版本是:</p>
		<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
	</body>
</html>