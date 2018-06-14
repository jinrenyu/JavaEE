<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax基础</title>
</head>
<body>
	<!-- 需求: 在不提交表单的情况下, 依然能够和后台的HelloAjax发生通信 -->
	<form action="/Ajax_basic/HelloAjax" onsubmit="return postHi();">
		<input type="submit" value="提交">
	</form>
	<script type="text/javascript">
		// 实现需求的第一步, 阻止表单的提交, 相当于阻止提交的默认动作
		// 第二步, 使用Ajax技术实现页面与后台的局部通信, (XMLHttpRequest)
		function getXHR() {
			// 该方法用于获取Ajax通信对象
			var xhr = null;
			if (window.XMLHttpRequest != null
					&& window.XMLHttpRequest != undefined) {
				xhr = new XMLHttpRequest();
			} else {
				// 兼容早期的IE浏览器
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			return xhr;
		}
		function hi() {
			// a. 获取用于异步通信的js对象
			var xhr = getXHR();
			// b. 告知异步通信的对象的通信地址和通信方法
			// 类比: 告诉寄送零件的地址和寄送方式(到付, 先付款)
			// 使用get的方式去连接地址'/Ajax_basic/HelloAjax'
			xhr.open("get", "/Ajax_basic/HelloAjax?name=tom&age=23");
			// c. 传送一些数据
			xhr.send();
			// d. 在Ajax对象和服务器发生通信的时候, 通信会有以下几个状态
			// 状态值: 0=未初始化;1=正在加载;2=已经加载;3=交互中;4=完成.
			// onreadystatechange事件可以监听状态值的改变, 每当通信状态有改变的时候
			// 该事件就会被触发一次
			xhr.onreadystatechange = function() {
				// 我们需要和后台进行交互, 交互的时机:
				// 当"交互完成"时并且"交互成功"才可以获取后台的响应信息
				if (xhr.readyState == 4 && xhr.status == 200) {
					// responseText属性可以获取后台发送回来的响应字符串
					alert(xhr.responseText);
				}
			}
			return false;
		}
		function postHi() {
			var xhr = getXHR();
			xhr.open("post", "/Ajax_basic/HelloAjax");
			// 如果需要可以让xhr模拟一个表单提交, 发送一些数据给后台
			// 类似于response.addHeader();
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xhr.send("name=jack&age=123456");
			xhr.onreadystatechange = function() {
				// 我们需要和后台进行交互, 交互的时机:
				// 当"交互完成"时并且"交互成功"才可以获取后台的响应信息
				if (xhr.readyState == 4 && xhr.status == 200) {
					// responseText属性可以获取后台发送回来的响应字符串
					alert(xhr.responseText);
				}
			}
			return false;
		}
	</script>
</body>
</html>