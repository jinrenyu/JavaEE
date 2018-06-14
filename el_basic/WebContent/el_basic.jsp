<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL表达式(JSP2.0之后才支持)</title>
    </head>
    <body>
		<!-- 对于常量的访问, JSP页面的前提下注意EL表达式可以用在HTML代码和js代码中 -->
		${1} | ${1 + 2}<br/>
		<!-- el表达式中算术运算符除了可以使用+、-、*、/、%以外还支持一些英文简写的方式 -->
		<!-- div相对于'/', mod相当于'%' -->
		${3 / 1} | ${3 div 1} | ${1 % 3} | ${1 mod 3}<br/>
		<!-- EL表达式中的算术运算, 它只进行算符的计算 -->
		<!-- 转换的时候底层会对于非数字, 调用Long.valueOf("字符串")和Long.parseLong("字符串"),-->
		<%-- 对字符串进行转换, 如果转换不了则报错, 所以${"a" + 1 }会报错 --%>
		${-1 + "2"} | ${"2" + 1}<br/>
		<!-- 逻辑运算: >(gt) <(lt) !=(ne) ==(eq) >=(ge) <=(le) &&(and) ||(or) !(not) -->
		${3 > 4} | ${3 gt 4} | ${1 + 2 > 2 && 3 < 1} | ${1 + 2 > 2 and 3 < 1}
		<!-- empty运算符, 表示判断某一个值是否为null或者""字符串 -->
		${empty ""} | ${empty null} | ${empty "3"}<br/>
		${"" == null} | ${"" eq null} | ${!empty null}
		| ${not empty null} | ${null ne null or null ne ""}<br/>
		<!-- 三目运算符 -->
		${3 > 4? "yes" : "no"}<br/>
		<!-- 当直接使用EL表达式获取数据时, 其采用的是类似于PageContext中findAttribute()方法的方式获取值 -->
		<!-- 且只能取WEB域中的数据, 被取对象需要是一个javabean -->
		<%
			request.setAttribute("p1", "province");
		%>
		${u1}<br/>
		${u1.username} | ${u1["username"]} | ${u1.address.province}|
		<!-- 方括号取值语法除了可以包含普通的字符串之外, 还可以包含变量, 变量会使用pageContext.findAttribute("变量")取值 -->
		${u1["address"]["province"]} | ${u1["address"][p1]}<br/>
		<%-- | ${u1["address"].p1} --%>
		${list01[0].pwd} | ${m1.user01.pwd} | ${m1["user01"]["pwd"]}<br/>
		<%-- 如果map键是一个数字字符串 --%>
		${m1["1"].pwd}<br/>
		<!-- 对于map结构建议其key全部使用string, EL表达式取值时会方便许多 -->
		${m2[2]} | ${m3[3]}
		<%
			pageContext.setAttribute("t1", "ttttttt");
		%>
		<hr/>
		<!-- 虽然EL表达式中也有隐式对象pageContext, 但是该pageContext没有取page域中的参数的功能
		它只能用于获取诸如request/session/ServletContextPath等变量 -->
		<%-- ${request.t1}相当于jsp中request.getParameter("t1"); --%>
		${pageScope.t1} | ${requestScope.m3} | ${pageContext.servletContext.contextPath}<br/>
		${pageContext.session.id}<br/>
		${pageContext.request.scheme}<br/>
		<!-- 相当于request.getParameter(参数名) -->
		${param.tname} | ${paramValues.tname[0]}<br/>
		<!-- 获取请求头中的信息 -->
		${header.host} | ${header["user-agent"]} | 
		${headerValues["accept"][0]}<br/>
		<%
			Cookie cookie = new Cookie("cname", "testname");
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		%>
		${cookie.cname.name} | ${cookie.cname.value}<br/>
		${cookie.JSESSIONID.value} | ${initParam.p001}
    </body>
</html>