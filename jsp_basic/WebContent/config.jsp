<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    	<%= request.getParameter("test01") %>
    	<%= request.getParameter("test02") %>
		<%
			Enumeration<String> enums = config.getInitParameterNames();
			while(enums.hasMoreElements()) {
				String str = enums.nextElement();
				System.out.println(str);
			}
		%>
    </body>
</html>