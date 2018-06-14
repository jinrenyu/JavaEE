<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>校验用户名是否重复</title>
    </head>
    <body>
		<form action="">
			username: <input id="uname" type="text" name="uname" onblur="checkname();">
			<span id="msg"></span><br/>
			<input id="rbt" type="submit" value="注册">
		</form>
		<script type="text/javascript">
			function getXHR() {
				// 该方法用于获取Ajax通信对象
				var xhr = null;
				if (window.XMLHttpRequest != null &&
						window.XMLHttpRequest != undefined) {
					xhr = new XMLHttpRequest();
				} else {
					// 兼容早期的IE浏览器
					xhr = new ActiveXObject("Microsoft.XMLHTTP");
				}
				return xhr;
			}
			function checkname() {
				var xhr = getXHR();
				var uinput = document.getElementById("uname").value;
				xhr.open("get", "/Ajax_basic/UserAction?uname=" + uinput);
				xhr.send();
				xhr.onreadystatechange = function() {
					// 我们需要和后台进行交互, 交互的时机:
					// 当"交互完成"时并且"交互成功"才可以获取后台的响应信息
					if (xhr.readyState == 4 && xhr.status == 200) {
						// responseText属性可以获取后台发送回来的响应字符串
						var node = document.getElementById("msg");
						var msg = xhr.responseText;
						if (msg == "success") {
							node.innerHTML = "该用户名可用";
							node.style.color = "green";
							document.getElementById("rbt").disabled = false;
						} else {
							node.innerHTML = "该用户名已存在";
							node.style.color = "red";
							document.getElementById("rbt").disabled = true;
						}
					}
				}
				return false;
			}
		</script>
    </body>
</html>