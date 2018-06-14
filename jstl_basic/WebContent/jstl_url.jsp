<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL中与URL相关的标签</title>
    </head>
    <body>
    	<!-- 用于生成url地址, 它可以支持自动的中文BASE64编码 -->
    	<!-- 改变其参考的web应用路径, 默认以本地的web应用名为参考 -->
		<c:url value="/show.jsp" var="url">
			<c:param name="test" value="中文参数"></c:param>
		</c:url>
		${url}
		<!-- 它是jsp:include的强化版本, 可以导入外部链接的页面 -->
		<!-- 可以使用charEncoding改变导入页面的页面编码 -->
		<c:import url="http://www.baidu.com" charEncoding="UTF-8">
		</c:import>
		<!-- 相当于response.sendRedirect();升级版, 支持自动URL重写 -->
		<c:redirect url="${url}" context="/"></c:redirect>
    </body>
</html>