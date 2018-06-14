<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP动作指令forward</title>
    </head>
    <body>
    	<!-- 动作指令可以使用JSP表达式 -->
    	<!-- param动作标签不能单独使用, 需要配合include/forward/plugins指令使用 -->
		<jsp:forward page="config.jsp">
			<jsp:param name="test01" value="test001"/>
			<jsp:param name="test02" value="test002"/>
		</jsp:forward>
		<p>我是JSP转发指令之后的内容</p>
		<!-- forward指令相当于如下代码:
		request.getRequestDispatcher("").forward(req, res);
		return;
		 -->
    </body>
</html>