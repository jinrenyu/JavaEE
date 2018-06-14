<%@ page language="java" import="java.net.URLEncoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--导航部分  begin-->
<div class="container" style="margin-top: 5px;">
	<nav class="navbar navbar-default well-sm" style="padding-left: 0px;"
		role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">在线书城</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav pull-left">
					<li><a href="${path }../book/list">首页</a></li>

					<li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> 图书类型 <b class="caret"></b>
					</a>
						<ul id="selection" class="dropdown-menu">
							<li name="style1"><a href="../book/style?fly=1">精选图书</a></li>
							<li class="divider"></li>
							<li name="style2"><a href="../book/style?fly=2">推荐图书</a></li>
							<li class="divider"></li>
							<li name="style3"><a href="../book/style?fly=3">特价图书</a></li>
							<li class="divider"></li>
						</ul></li>
					<c:if test="${null==user }">
					</li>
					<li><a href="#" data-toggle="modal" data-target="#myModal">登录</a>
					</li>
					</c:if>
					
					<c:if test="${null!=user }">
					<li><a href="#" >${user.userName}</a></li>
					</c:if>
					
					
					<li><a href="../book/exit">安全退出</a></li>
					
					
					<c:if test="${null==user }">
					<li><a href="#" data-toggle="modal" data-target="#register">注册</a></li>
					</c:if>
					
					
					<li><a href="../jsp/order_list.jsp">我的订单</a></li>
					<li><a href="../jsp/cart.jsp"><span
							class="glyphicon glyphicon-shopping-cart"> </span>我的购物车</a></li>
					
							
				</ul>
				<div class="input-group col-md-3 pull-right"
					style="positon: relative; padding: 7px;">
					<input type="text" class="form-control" value="${bookName }"
						name="bookQueryName" placeholder="请输入图书名" /> <span
						class="input-group-btn">
						<button class="btn btn-info btn-search">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</nav>
</div>
<!--导航部分 end-->

<!--最顶端轮播图片 begin-->
<div id="gcarouse" class="container">
	<!--轮播-->
	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<a href="../jsp/detail.jsp"><img
					src="../images/advert1.jpg" class="pull-left"
					alt="First slide"></a>

			</div>
			<div class="item">
				<a href="../jsp/detail.jsp"><img
					src="../images/advert2.jpg" class="pull-left"
					alt="First slide"></a>

			</div>
			<div class="item">
				<a href="../jsp/detail.jsp"><img
					src="../images/advert3.jpg" class="pull-left"
					alt="First slide"></a>

			</div>
		</div>

		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
</div>
<!--最顶端轮播图片 end-->





