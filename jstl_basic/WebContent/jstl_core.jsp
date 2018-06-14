<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.jsp.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL通用标签</title>
    </head>
    <body>
    	<!-- 原理等价于out.write(value值) -->
    	<!-- 默认情况下, 使用c:out输出会对一些敏感符号自动进行转义 -->
    	<!-- <(&lt;)>(&gt;)'(&apos;)"(&quot;)&(&amp;) -->
    	<!-- 如果不需要对value内的值进行转义, 则可以使用属性escapeXml(默认true), 设置成false表不转义 -->
    	<%
    		// String str = "testStr";
    		String str = null;
    		request.setAttribute("strTest", str);
    		List<String> list = new ArrayList<>();
    		list.add("AAAA01");
    		list.add("BBBB02");
    		list.add("CCCC03");
    		list.add("DDDD04");
    		list.add("EEEE05");
    		list.add("FFFF06");
    		request.setAttribute("t001", list);
    		Map<String, String> map = new HashMap<>();
    		map.put("s1", "jack");
    		map.put("s2", "tom");
    		request.setAttribute("m1", map);
    		User user = new User();
    		user.setUsername("u1");
    		user.setPwd("p1");
    		request.setAttribute("u1", user);
    		request.setAttribute("score", 91);
    		request.setAttribute("sum", 0);
    	%>
    	<!-- 当value属性中的值为null的时候, 此时default属性会生效 -->
		<c:out default="default value" value="${str}" escapeXml="false"></c:out>
		<!-- 相当于pageContent.setAttribute()带3个参数的那个方法 -->
		<!-- 表示设置值之后的变量名 -->
		<!-- 默认情况下, 相当于如下代码pageContent.setAttribute("test", "123456", PageContext.PAGE_SCOPE) -->
		<!-- 如果需要改变放置的web域 -->
		<c:set var="test" value="123456" scope="request"></c:set>
		<c:set target="${u1}" property="pwd" value="666666"></c:set>
		<c:set target="${m1}" property="s3" value="33333"></c:set>
		${requestScope.test} | ${pageScope.test} | ${u1.pwd} | ${m1} <br/>
		<!-- 默认类似于pageContext.removeAttribute("参数名称"); -->
		<!-- 添加上scope属性之后, 可以指定只移除某个web域中对应的值 -->
		<c:remove var="u1" scope="session" />
		${u1}|<br/>
		<c:catch var="ex">
			<%
				int i = 9 / 0;
			%>
		</c:catch>
		${ex}
		<!-- 条件控制语句, test属性内书写一个判断表达式, 该表达式返回true/false -->
		<%-- 当test判断语句返回false的时候, 就会执行<c:if>标签内的语句 --%>
		<c:if test="${3 > 4}" var="flag" scope="request">
			<p>you are right!</p>
		</c:if>
		${requestScope.flag}
		<!-- choose标签就是作为when和otherwise的父标签, 类似于Java内的Switch -->
		<c:choose>
			<c:when test="${score > 90}">
				<p>you are good!</p>
			</c:when>
			<c:when test="${score lt 90 and score ge 60}">
				<p>just so so!</p>
			</c:when>
			<c:otherwise>
				<p>wrong input!</p>
			</c:otherwise>
		</c:choose><hr/>
		<!-- 实现1 + 3 + 5 + ... + 9 = ? -->
		<!-- var属性就表示当前被迭代的对象变量, 默认step是1 -->
		<c:forEach var="item" begin="1" step="2" end="10">
			<c:out value="${item}"></c:out>
			<c:set var="sum" value="${sum + item}"></c:set>
		</c:forEach><hr/>
		${sum}<hr/>
		<!-- items表示要迭代的对象, 此时该表达式类似于Java中的foreach循环 -->
		<!-- begin默认从0开始, 表示要迭代的元素的下标 -->
		<!-- varStatus的first属性返回true/false, 如果是true表示当前是被迭代的第一个元素 -->
		<!-- 记录当前被迭代对象的状态属性: 是否是第一个/是否是最后一个/当前下标/当前行号 -->
		<c:forEach items="${t001}" var="item" varStatus="vs" begin="3">
			<c:if test="${vs.first}">正在迭代第一个元素: </c:if>
			<c:out value="当前被迭代的元素成员为: ${item}, "></c:out>
			<c:out value="被迭代的元素下标为: ${vs.index}, "></c:out>
			<c:out value="被迭代的元素在当前中输出的行号: ${vs.count}, "></c:out>
			<c:if test="${vs.last}">正在迭代最后一个元素: </c:if><br/>
		</c:forEach><hr/>
		<!-- 如果被迭代的元素是map类型的, var表示Map.Entry<K, V> -->
		<c:forEach items="${m1}" var="item">
			<c:out value="${item.key}"></c:out>
			<c:out value=", ${item.value}"></c:out><br/>
		</c:forEach><hr/>
		<c:set value="西瓜，苹果-梨-香蕉，西红柿，芒果-水蜜桃-栗子，菠萝，橙子-樱桃，葡萄-柿子" var="fruits"></c:set>
		<!--以"-"为分隔符, 类似于Java中split -->
		<c:forTokens var="fruit" delims="-" items="${fruits}" varStatus="ss">
			${ss.count}: ${fruit}<br/>
		</c:forTokens><hr/>
		<!--以"-,"为分隔符-->
		<c:forTokens var="fruit" delims="-，" items="${fruits}" varStatus="ss" step="3"><br/>
			${ss.count}: ${fruit}
		</c:forTokens>
    </body>
</html>