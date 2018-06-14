<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    	<%
    		String str = "common/common.jsp";
    	%>
    	<%@ include file="common/common.jsp" %>
    	<%
    		num1 = 2;
    	%>
    	<%@ include file="common/header.jsp" %>
		<p style="color:green;">主体部分</p>
		<%@ include file="common/footer.jsp" %>
		<%
			System.out.println(num1);
		%>
    </body>
</html>