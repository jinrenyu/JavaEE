<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
		<%
			pageContext.setAttribute("data01", "value001");
			request.setAttribute("data01", "value002");
			session.setAttribute("data01", "value003");
			application.setAttribute("data01", "value004");
			// 或者
			pageContext.setAttribute("data02", "value00A", PageContext.PAGE_SCOPE);
			pageContext.setAttribute("data02", "value00B", PageContext.REQUEST_SCOPE);
			pageContext.setAttribute("data02", "value00C", PageContext.SESSION_SCOPE);
			pageContext.setAttribute("data02", "value00D", PageContext.APPLICATION_SCOPE);
			// pageContext.forward("/getAttribute.jsp");
		%>
		<!-- 该方法表示从pageContext开始寻找需要移除的指定属性名只要找到了就移除 -->
		<!-- 该动作一致持续到application域 -->
		<%-- <%pageContext.removeAttribute("data01"); %> --%>
		<%pageContext.removeAttribute("data01", PageContext.APPLICATION_SCOPE); %>
		<%=pageContext.getAttribute("data01")%>
		<%=request.getAttribute("data01")%>
		<%=session.getAttribute("data01")%>
		<%=application.getAttribute("data01")%>
		<%=pageContext.getAttribute("data02", PageContext.PAGE_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.REQUEST_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.SESSION_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.APPLICATION_SCOPE)%>
		<%=pageContext.findAttribute("data01") %>
		<%=pageContext.findAttribute("data02") %>
    </body>
</html>