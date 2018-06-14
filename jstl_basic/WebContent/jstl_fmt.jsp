<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>4个主要fmt标签</title>
    </head>
    <body>
    	<%
    		pageContext.setAttribute("now", new Date());
    	%>
    	<!-- 使用默认的模板对日期进行格式化: yyyy-MM-dd -->
		<fmt:formatDate value="${pageScope.now}" /><br/>
		<fmt:formatDate var="strNow" value="${pageScope.now}" pattern="yyyy-MM-dd HH:mm:ss" /><br/>
		<fmt:formatDate type="both" value="${pageScope.now}" dateStyle="short" timeStyle="long"/><br/>
		<fmt:parseDate value="${strNow}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate><hr/>
		<!-- 使用默认的格式来格式化数字 -->
		<fmt:formatNumber value="12312312.123221"></fmt:formatNumber>
		<fmt:formatNumber value="12312312.123221" pattern="$#,##00.0#"></fmt:formatNumber><br/>
		<fmt:formatNumber value="2.123221" maxFractionDigits="3" minFractionDigits="1" 
			maxIntegerDigits="3" minIntegerDigits="2"></fmt:formatNumber>
		<fmt:formatNumber value="123.123" type="currency"></fmt:formatNumber>
		<fmt:formatNumber value="123.123" type="percent"></fmt:formatNumber><br/>
		<!-- 默认从左到右解析出浮点数 -->
		<fmt:parseNumber value="12321.231abdfd"></fmt:parseNumber>
		<!-- 其他属性表示对解析出的数字做进一步的格式化处理 -->
		<fmt:parseNumber value="12321.231abdfd" integerOnly="true"></fmt:parseNumber>
		<!-- 自定义标签 -->
    </body>
</html>