<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>分页显示案例</title>
        <style type="text/css">
        	table, th, td {
        		border: 1px solid red;
        		text-align: center;
        	}
        	table {
        		width: 300px;
        		margin: 0px auto;
        	}
        	div {
        		text-align: center;
        		word-spacing: 1em;
        	}
        </style>
    </head>
    <body>
		<!-- 根据后台传过来的数据产生动态数据的表格 -->
		<c:forEach items="${provinces}" var="province" varStatus="vs">
			<c:if test="${vs.first}">
				<table>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>CODE</th>
					</tr>
			</c:if>
			<tr>
				<td>${province.id}</td>
				<td>${province.name}</td>
				<td>${province.code}</td>
			</tr>
			<c:if test="${vs.last}">
				</table>
			</c:if>
		</c:forEach>
		<div>
			<c:if test="${currentPage ne 1}">
				<a href="/Ajax_basic/province/main.html?page=${currentPage - 1}">&lt;上一页</a>
			</c:if>
			<c:forEach begin="${begin}" end="${end}" var="page">
				<c:choose>
					<c:when test="${currentPage eq page}">
						<a style="font-size: 25px; color:green;" href="/Ajax_basic/province/main.html?page=${page}">${page}</a>
					</c:when>
					<c:otherwise>
						<a href="/Ajax_basic/province/main.html?page=${page}">${page}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${currentPage ne totalPage}">
				<a href="/Ajax_basic/province/main.html?page=${currentPage + 1}">下一页&gt;</a>
			</c:if>
		</div>
    </body>
</html>