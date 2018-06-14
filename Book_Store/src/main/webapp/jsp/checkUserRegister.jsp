<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<style type="text/css">
	div {
	/* border: 1px dashed #ccc; */
	width: 60%;
	margin: auto;
}

h3{
	color: white;
	text-shadow: 2px 2px 4px #000000;
	font-size: 32px;
}

table {
	border: 1px solid #999;
	border-collapse: collapse;
	width: 100%;
}

table th, table td {
	border: 1px solid #999;
	height: 30px;
}

span{
	color: #ccc;
	font-size: 14px;
}

/**input获得焦点时,span对应的样式**/
.s1{
	color: black;
}
			
.s2{
	color: green;
}
			
.s3{
	color: red;
	}
</style>
</head>

<body onload="formSubmit()">
	<div>
		<form action="http://www.baidu.com" method="get" onsubmit="return formSubmit('p')">
			<table>
				<caption><h3>用户注册</h3></caption>
				<tr>
					<td>用户名:</td>
					<td><input type="text" id="username" name="username"/></td>
					<td><span>*用户名必须以小写字母开头,长度在6-8</span></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" id="password" name="password"/></td>
					<td><span>*密码长度在6-8</span></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" id="pwd" name="pwd"/></td>
					<td><span>*和密码保持一致</span></td>
				</tr>
				<tr>
					<td>邮箱:</td>
					<td><input type="email" id="email"/></td>
					<td><span>*邮箱格式要合法</span></td>
				</tr>
				<tr>
					<td>手机号:</td>
					<td><input type="tel" id="tel"/></td>
					<td><span>*手机号格式要合法</span></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="3">
						<input type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="${path}../js/register.js" ></script>
</body>
</html>