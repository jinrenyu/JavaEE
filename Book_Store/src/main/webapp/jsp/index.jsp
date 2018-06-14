<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在线书城首页</title>
<link type="text/css" rel="stylesheet"
	href="../dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<link rel="stylesheet" type="text/css" href="../css/animate.css" />
</head>

<body onload="formSubmit()">

	<!-- 引入导航部分 -->
	<%@ include file="../common/nav.jsp"%>

	<!--图书内容部分 begin-->
	<div class="container">
		<!--精选图书 begin-->
		<div>
			<div class="text-primary">
				<img src="../images/bullet1.gif" alt="" title=""> <a
					href="#">精选图书</a>
			</div>
			<div class="row">

				<c:forEach items="${pageBean1.list }" var="b">
					<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="../book/details?bookId=${b.bookId}"><img
								src="../images/${b.imgUrl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h3>${b.name }</h3>
								<p>价格:${b.newPrice }&nbsp;&nbsp;作者:${b.author }&nbsp;&nbsp;</p>
								<p>
									<a href="../book/details?bookId=${b.bookId}"> 更多信息 </a>
								</p>
							</div>
						</div>

					</div>
				</c:forEach>

				<!--分页-->
				<div class="container">
					<ul class="pager">


						<c:if test="${pageBean1.pageNow-1==0}">
							<li class="disabled"><a>&larr;上一页</a></li>
						</c:if>

						<c:if test="${pageBean1.pageNow-1!=0}">
							<li><a
								href="../book/list?pageNow=${pageBean1.pageNow-1}&flag=1">&larr;上一页</a>
							</li>
						</c:if>

						<c:if test="${pageBean1.pageNow==pageBean1.pageCount}">
							<li class="disabled"><a>下一页 &rarr;</a></li>
						</c:if>

						<c:if test="${pageBean1.pageNow<pageBean1.pageCount}">
							<li><a
								href="../book/list?pageNow=${pageBean1.pageNow+1}&flag=1">下一页
									&rarr;</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
		<!--精选图书 end-->

		<!--推荐图书 begin-->
		<div>
			<div class="text-primary">
				<img src="../images/bullet1.gif" alt="" title=""> <a
					href="#">推荐图书</a>
			</div>
			<div class="row">

				<c:forEach items="${pageBean2.list }" var="b">
					<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="../book/details?bookId=${b.bookId}"><img
								src="../images/${b.imgUrl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h3>${b.name }</h3>
								<p>价格:${b.newPrice }&nbsp;&nbsp;作者:${b.author }&nbsp;&nbsp;</p>
								<p>
									<a href="../book/details?bookId=${b.bookId}"> 更多信息 </a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>

				<!--分页-->
				<div class="container">
					<ul class="pager">

						<c:if test="${pageBean2.pageNow-1==0}">
							<li class="disabled"><a>&larr;上一页</a></li>
						</c:if>

						<c:if test="${pageBean2.pageNow-1!=0}">
							<li><a
								href="../book/list?pageNow=${pageBean2.pageNow-1}&flag=2">&larr;上一页</a>
							</li>
						</c:if>

						<c:if test="${pageBean2.pageNow==pageBean2.pageCount}">
							<li class="disabled"><a>下一页 &rarr;</a></li>
						</c:if>

						<c:if test="${pageBean2.pageNow<pageBean2.pageCount}">
							<li><a
								href="../book/list?pageNow=${pageBean2.pageNow+1}&flag=2">下一页
									&rarr;</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
		<!--推荐图书end..-->

		<!--特价图书 begin-->
		<div>
			<div class="text-primary">
				<img src="../images/bullet1.gif" alt="" title=""> <a
					href="#">特价图书</a>
			</div>
			<div class="row">

				<c:forEach items="${pageBean3.list }" var="b">
					<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
						<div class="thumbnail">
							<a href="../book/details?bookId=${b.bookId}"><img
								src="../images/${b.imgUrl}" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h3>${b.name }</h3>
								<p>价格:${b.newPrice }&nbsp;&nbsp;作者:${b.author }&nbsp;&nbsp;</p>
								<p>
									<a href="../book/details?bookId=${b.bookId}"> 更多信息 </a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--分页-->
				<div class="container">
					<ul class="pager">
						<<c:if test="${pageBean3.pageNow-1==0}">
							<li class="disabled"><a>&larr;上一页</a></li>
						</c:if>

						<c:if test="${pageBean3.pageNow-1!=0}">
							<li><a
								href="../book/list?pageNow=${pageBean3.pageNow-1}&flag=3">&larr;上一页</a>
							</li>
						</c:if>

						<c:if test="${pageBean3.pageNow==pageBean3.pageCount}">
							<li class="disabled"><a>下一页 &rarr;</a></li>
						</c:if>

						<c:if test="${pageBean3.pageNow<pageBean3.pageCount}">
							<li><a
								href="../book/list?pageNow=${pageBean3.pageNow+1}&flag=3">下一页
									&rarr;</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
		<!--特价图书 end-->
		<hr>
		<!--首页底部信息 begin-->
		<div class="container">
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<div class="row">
						<div class="col-md-offset-2 col-md-2">
							<img src="../images/logo.png">
						</div>
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-offset-2 col-md-10">
									<a href="http://www.sztzedu.com">威思登软件科技有限公司&copy;所有</a>
								</div>
							</div>
							<div class="gap"></div>
							<div class="row">
								<div class="col-md-offset-2 col-md-10">
									<span class="text-info">天智教育&reg; |&nbsp;</span> <span
										class="text-info">项目实训管理平台 |&nbsp;</span> <span
										class="text-info">2012－2020 </span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--首页底部信息end->
		<!--图书内容部分end-->

<!-- 引入登录模态 -->
	 <%@ include file="../common/modelLogin.jsp" %>
 
<!-- 模态注册开始 -->
		<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
						<h4 class="modal-title" id="myModalLabel">
					用户注册
				</h4>
					</div>
					<div class="modal-body">
						<!--登录的form表单-->
						<form  action="${pageContext.request.contextPath}/book/register" class="form-horizontal" role="form" method="get" onsubmit="return checkk()">

								<div class="form-group has-feedback">
									<label for="firstname" class="col-sm-2 control-label">用户名：</label>
									<div class="col-md-5">
										<input type="text" class="form-control" name="user"  id="user" onblur="checkName(this)" placeholder="请输入名字">
										<span class="glyphicon glyphicon-user form-control-feedback"></span>
									</div>
									<span id="spr" >*用户名以小写字母开头,长度在6-8位</span>
								</div>
								<div class="form-group has-feedback">
									<label for="lastname" class="col-sm-2 control-label">密码：</label>
									<div class="col-md-5">
										<input  type="password" class="form-control" name="pwd" id="pwd" placeholder="请输入密码">
										<span class="glyphicon glyphicon-lock form-control-feedback"></span>
									</div>
									<span >*密码为6-8位</span>
								</div>
								<div class="form-group has-feedback">
									<label for="lastname" class="col-sm-2 control-label">确认密码：</label>
									<div class="col-md-5">
										<input  type="password" class="form-control" name="pwds" id="pwds" placeholder="请再次输入密码">
										<span class="glyphicon glyphicon-lock form-control-feedback"></span>
									</div>
									<span > *密码一致</span>
								</div>
								<div class="form-group has-feedback">
									<label for="lastname" class="col-sm-2 control-label">邮箱：</label>
									<div class="col-md-5">
										<input  type="email" class="form-control" name="email" id="email" placeholder="请输入邮箱">
										<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
									</div>
									<span >*请填写正确邮箱地址</span>
								</div>
								<div class="form-group has-feedback">
									<label for="lastname" class="col-sm-2 control-label">手机号码：</label>
									<div class="col-md-5">
										<input  type="tel" class="form-control" name="phone" id="phone" placeholder="请输入手机号码">
										<span class="glyphicon glyphicon-earphone form-control-feedback"></span>
									</div>
									<span >*请填写手机号码正确格式</span>
								</div>
								<div class="form-group has-feedback">
								<label class="col-sm-2 control-label">公司</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="company" id="company" placeholder="请输入公司名称">
									<span class="glyphicon glyphicon-home form-control-feedback"></span>
								</div>
								<span >*请填写公司名称</span>
							</div>
							
							<div class="form-group has-feedback">
								<label class="col-sm-2 control-label">地址</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" name="address" id="address" placeholder="请输入收货地址">
									<span class="glyphicon glyphicon-home form-control-feedback"></span>
								</div>
								<span >*请填写正确地址</span>
							</div>
							<div class="modal-footer" id="anniu">
								<button type="submit"  class="btn btn-default">提交注册</button>
								<button type="reset" onclick="reloads()" class="btn btn-default">取消</button>
							</div>
						</form>
						<!--form结束-->
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
		</div>
		
		<script  type="text/javascript" >
			
			//*******
			 /**取消按钮刷新页面**/
		  		function reloads() {
				window.location.reload();
			    }
		  	function formSubmit(param){
		  		
				//1.依次获取input对象.
				//var username = document.getElementById("user");
				var pword = document.getElementById("pwd");
				var pwd = document.getElementById("pwds");
				var email = document.getElementById("email");
				var tel = document.getElementById("phone");
				var company=document.getElementById("company");
				var adress=document.getElementById("adress");
				//定义一个boolean
				var flag = true;
			
				//判断pword
				checkData(pword,"*密码长度在6-8位",function(val){
					
					var reg = /^[0-9a-zA-Z]{6,8}$/;
					
					if(reg.test(val)){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
				//判断pwd
				checkData(pwd,"*密码一致",function(val){
					var reg = /^[0-9a-zA-Z]{6,8}$/;
					if(pwd.value==pword.value&reg.test(val)){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
				//判断email
				checkData(email,"*请填写正确邮箱地址",function(val){
					
					var reg = /^\w+([-+._]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					
					if(reg.test(val)){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
				//判断tel
				checkData(tel,"*请填写手机号码正确格式",function(val){
					
					//var reg = /^(\+86)?\s?\d{11}$/;
					var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
					if(reg.test(val)){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
				
				//判断company
				checkData(company,"*请填写公司名称",function(val){
					
				//	var reg = /^\w+$/;
				
					
					if(val!=null ){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
				//判断address
				checkData(address,"*请填写正确地址",function(val){
					
					//var reg = /^\w+$/;
					
					if(val!=null){
						return true;
					}else{
						flag = false;
						return false;
					}
					
				},param);
  			  return flag;
		  }
		  	
		  
		  	
		  		
		  		
			
			/**定义一个函数,用来判断指定控件的数据
			 * obj,指的就是当前的input
			 * info,指的是span的innerHTML
			 * fun,指的是具体的判断数据是否合法.返回类型是boolean,要么是true,要么是false.它是回调函数,作为一个参数被传入到checkData的参数列表中
			 * param
			 * **/
			function checkData(obj,info,fun,param,id){
				//获取对应控件的span对象
				var sp = obj.parentNode.nextElementSibling;
				
				//控件获取焦点事件...
				obj.onfocus = function(){
					sp.className="black";
				}
				
				//控件失去焦点事件...
				obj.onblur = function(){
					if(fun(obj.value)){
						sp.className="right";
						sp.innerHTML="<img src='${pageContext.request.contextPath}/images/timg.gif' style='width: 30px; height: 30px;'/>";
					}else{
						sp.className="error";
						sp.innerHTML = info;
					}
				}
				
				if(param=='p'){
					obj.onblur();
				}
			}
			function checkk(){
				 return formSubmit('p')&&flag1;
			}
			
			var flag1=false;
		  	function checkName(obj){
				var userName = obj.value;
				var url = "${pageContext.request.contextPath}/book/checkUserName"
				
				//1.创建xmlHttpRequest对象
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
							if(xmlHttpRequest.responseText=="ok"){
							document.getElementById("spr").className="red";
							document.getElementById("spr").innerHTML="用户已存在或用户名不能为空 ";
						
							flag1=false;
							}else{
							document.getElementById("spr").className="right";
							document.getElementById("spr").innerHTML="<img src='${pageContext.request.contextPath}/images/timg.gif' style='width: 30px; height: 30px;'/>";
							flag1=true;
							}
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

<!-- 	<div class="modal fade" id="register" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户注册</h4>
				</div>
				<div class="modal-body">
					登录的form表单
					<form action="" class="form-horizontal" role="form">
						<div class="form-group has-feedback">
							<label for="firstname" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="firstname" required
									placeholder="小写字母开头,不含中文."> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="col-sm-3" style="padding-top: 10px;">
									<label class="alert-danger">用户名不合法</label>
								</div>
						</div>
						<div class="form-group has-feedback">
							<label for="lastname" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="lastname"
									placeholder="密码长度6-8位" minlength="6" maxlength="8"> <span
									class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
							<div class="col-sm-3" style="padding-top: 10px;">
									<label class="alert-danger">密码不正确</label>
								</div>
						</div>
						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="lastname2"
									minlength="6" maxlength="8" placeholder="和密码保持一致"> <span
									class="glyphicon glyphicon-lock form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-5">
								<input type="email" class="form-control" id="email"
									placeholder="合法邮箱格式"> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">电话</label>
							<div class="col-sm-5">
								<input type="tel" class="form-control" id="email"
									placeholder="合法手机格式"> <span
									class="glyphicon glyphicon-earphone form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">公司</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="email"
									placeholder="请输入公司地址"> <span
									class="glyphicon glyphicon-home form-control-feedback"></span>
							</div>
						</div>

						<div class="form-group has-feedback">
							<label class="col-sm-2 control-label">地址</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="email"
									placeholder="请输入收货"> <span
									class="glyphicon glyphicon-home form-control-feedback"></span>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<input type="submit" class="btn btn-primary" value="注册">
						</div>
					</form>
					<!-- form结束 -->
				</div>
			</div>
			<!-- .modal-content -->
		</div>
	</div> -->

		
	
	<script src="../dist/js/jquery.min.js"></script>
	<script src="../js/carousel.js" type="text/javascript"
		charset="utf-8"></script>
	<script src="../dist/js/bootstrap.min.js"></script>
	<script src="../js/wow.js"></script>
	<script type="text/javascript">
		if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
			new WOW().init();
		};
		</script>
</body>
</html>