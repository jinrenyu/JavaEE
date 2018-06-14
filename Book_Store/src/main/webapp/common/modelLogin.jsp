<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder,javax.servlet.http.Cookie"%>
<%
	Cookie[] cookies = request.getCookies();

	if(null!=cookies && cookies.length>0){	
		for(Cookie c:cookies){
			if("loginName".equals(c.getName())){
				String value = c.getValue();
				String uname = URLDecoder.decode(URLDecoder.decode(value.split(":")[0]));
				request.setAttribute("uname", uname);
			}
		}
	
	}
%>
<!-- 登录模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">用户登录</h4>
			</div>
			<div class="modal-body">
				
				<!--登录的form表单-->
				<form class="form-horizontal" role="form" action="${path}../book/login">
					<div class="form-group has-feedback">
						<label for="firstname" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-5">

							<input name="userName" value="${uname}" type="text" class="form-control" id="firstname"
								placeholder="请输入用户名" onblur="checklogin(this)"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						
						<div  class="col-sm-3" style="padding-top: 10px;">
							<label id="sp" class="alert-danger"></label> 
						</div> 
					</div>
					<div class="form-group has-feedback">
						<label for="lastname" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-5">
							<input name="passWord" type="password" value="${cookie.loginName.value.split(':')[1] }" class="form-control" id="lastname"
								placeholder="请输入密码" onblur="checkpassword(this)"> <span
								class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>
						 <div class="col-sm-3" style="padding-top: 10px;">
							<label id="spp" class="alert-danger"></label>
						</div> 
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input name="pwd" type="checkbox">请记住我
								</label>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input id="inp"  type="submit" class="btn btn-primary"  value="登录">
					</div>
				</form>
				<!--form结束-->
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
</div>
<!-- 登录modal end/.modal -->


<script type="text/javascript">
		   function checklogin(obj){
				var userName = obj.value;
				var url = "${pageContext.request.contextPath}/book/checkUserName";
				//alert(userName)
				var xmlHttpRequest = new XMLHttpRequest(); 
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
							//alert(str)
							document.getElementById("sp").innerHTML=str;
							
						}
					}
				} 
				//3.设置连接的信息
				xmlHttpRequest.open("post",url,true);
				//设置请求头  为了向后台传中文参数
				xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				//4.发送请求.
				xmlHttpRequest.send("userName="+userName);
			}
	</script>

<script type="text/javascript">
		   function checkpassword(obj){
			   	var userName = document.getElementById("firstname").value;
			   	//alert(userName)
				var passWord = obj.value;
				//alert(passWord)
				var url = "${pageContext.request.contextPath}/book/checkUserPassWord";
				//alert(userName)
				var xmlHttpRequest = new XMLHttpRequest(); 
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
							document.getElementById("spp").innerHTML=str;
							
						}
					}
				} 
				//3.设置连接的信息
				xmlHttpRequest.open("post",url,true);
				//设置请求头  为了向后台传中文参数
				xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				//4.发送请求.
				xmlHttpRequest.send("upd="+passWord+":"+userName);
			}
	</script>
