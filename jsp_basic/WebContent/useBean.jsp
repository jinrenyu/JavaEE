<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>usebean动作指令</title>
    </head>
    <body>
    	<!-- 
    		下面标签相当于, 
    		com.jsp.entity.User u1 = null;
	        u1 = (com.jsp.entity.User) _jspx_page_context.getAttribute("u1", javax.servlet.jsp.PageContext.PAGE_SCOPE);
	        if (u1 == null){
	            u1 = new com.jsp.entity.User();
	            _jspx_page_context.setAttribute("u1", u1, javax.servlet.jsp.PageContext.PAGE_SCOPE);
	        }
	        其功能更是尝试从当前pageContext中获取属性为'u1'对象的参数值,
	        如果不存在则创建一个新的对象, 并把该对象放入到pageContext域中
	        属性名使用id的值, 即u1
    	-->
    	<!-- 放入的域范围可以通过scopse属性进行改变 -->
    	<%
    		String cName = "com.jsp.entity.User";
    	%>
		<jsp:useBean id="u1" class="com.jsp.entity.User" scope="session"></jsp:useBean>
		<!-- 如果使用beanName, 它使用的反射的机制去尝试获取一个对象 -->
		<jsp:useBean id="u2" type="com.jsp.entity.User" beanName="<%=cName%>"></jsp:useBean>
		<jsp:setProperty property="username" name="u1" value="user001" />
		<%-- <jsp:setProperty property="username" name="u2" param="tname" /> --%>
		<jsp:setProperty property="*" name="u2" />
		<%= pageContext.getAttribute("u1") %><br/>
		<%= session.getAttribute("u1") %><br/>
		<%= pageContext.getAttribute("u2") %><br/>
		<!-- 使用类似于PageContext.findAttribute("参数名")去获取对应的值 -->
		<!-- out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.jsp.entity.User)_jspx_page_context.findAttribute("u1")).getUsername()))); -->
		<jsp:getProperty property="username" name="u1"/>
    </body>
</html>