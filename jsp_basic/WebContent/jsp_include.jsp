<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>include动作指令</title>
    </head>
    <body>
    	<%
    		int num1 = 2;
    		String str = "common/common.jsp";
    	%>
    	<jsp:include page="<%=str%>">
    		<jsp:param value="test" name="test"/>
    	</jsp:include>
		<jsp:include page="common/header.jsp"></jsp:include>
		<p style="color:green;">主体部分</p>
		<jsp:include page="common/footer.jsp"></jsp:include>
		<%
    		System.out.println(num1);
    	%>
    </body>
</html>