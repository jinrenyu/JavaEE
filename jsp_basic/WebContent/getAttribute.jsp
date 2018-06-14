<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
		<%=pageContext.getAttribute("data01")%>
		<%=request.getAttribute("data01")%>
		<%=session.getAttribute("data01")%>
		<%=application.getAttribute("data01")%>
		<%=pageContext.getAttribute("data02", PageContext.PAGE_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.REQUEST_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.SESSION_SCOPE)%>
		<%=pageContext.getAttribute("data02", PageContext.APPLICATION_SCOPE)%>
		<%pageContext.removeAttribute("data01"); %>
		<%=pageContext.findAttribute("data01") %>
		<%=pageContext.findAttribute("data02") %>
    </body>
</html>