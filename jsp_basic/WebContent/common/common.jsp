<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
		<%
			System.out.println(request.getParameter("test"));
			int num1 = 3;
			System.out.println(num1);
		%>
    </body>
</html>