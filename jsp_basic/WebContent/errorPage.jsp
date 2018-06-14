<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>错误页面</title>
    </head>
    <body>
    	<h1>服务器正忙</h1>
		<%
			exception.printStackTrace();
		%>
    </body>
</html>