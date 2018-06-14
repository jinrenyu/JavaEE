<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
	border: 1px dashed #ccc;
	width: 80%;
	margin: auto;
}

table {
	border: 1px dashed #999;
	border-collapse: collapse;
	width: 100%;
}

table th, table td {
	border: 1px dashed #999;
	height: 20px;
}
</style>
<script type="text/javascript">
		function checkUserName(obj){
			//兼容性写法
			var xmlHttpRequest;
			var username = obj.value;
			var url = "${pageContext.request.contextPath}/checkUserName"
			if (window.XMLHttpRequest)
			{
				//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
				xmlHttpRequest=new XMLHttpRequest();
			}
			else
			{
				// IE6, IE5 浏览器执行代码
				xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
			}
			/* //1.创建xmlHttpRequest对象
			var xmlHttpRequest = new XMLHttpRequest(); */
			//2.注册一个回调函数,当readystate属性改变时,就会触发该回调函数.
			xmlHttpRequest.onreadystatechange = callback;
			//2-1.自定义回调函数
			function callback(){
				//2-2.当readystate==4的时候,说明响应已经完成.
				if(xmlHttpRequest.readyState==4){
					//2-3.并且http状态码等于200的时候,说明是一次成功的响应
					if(xmlHttpRequest.status==200){
						//2-4.获取服务器返回的文本数据
						var str = xmlHttpRequest.responseText;
						//2-5.业务操作.拿到后台返回的数据进行一些操作.
						//采用js的DOM操作.
						//document.getElementById("outer").innerHTML=str;
						//alert(str);
						document.getElementById("usernameInfo").innerHTML="";
						document.getElementById("usernameInfo").innerHTML=str;
					}
				}
			} 
			//3.设置连接的信息
			xmlHttpRequest.open("post",url,true);
			//设置请求头  为了向后台传中文参数
			xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//4.发送请求.
			xmlHttpRequest.send("username="+username);
		}
	</script>
</head>

<body>
	<div>
		<form action="" method="post">
			<table>
				<caption><h3>用户注册</h3></caption>
				<tr>
					<td>用户名:</td>
					<td><input type="text" id="uname" name="username" onblur="checkUserName(this)"/></td>
					<td><span id="usernameInfo">*用户名必须以小写字母开头,长度在6-8</span></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
					<td><span>*密码长度在6-8</span></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="text" name="pwd"/></td>
					<td><span>*和密码保持一致</span></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="注册"/>
						<input type="reset" value="重置"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>