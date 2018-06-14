<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
<link type="text/css" rel="stylesheet" href="../dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/index.css" />
<link rel="stylesheet" type="text/css" href="../css/animate.css" />
</head>
<body>

		<!-- 引入导航部分 -->
		<%@ include file="../common/nav.jsp" %>
	
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">图书列表</a></li>
			<c:if test="${fly==1 }">
			<li><a href="#">精选图书</a></li>
			</c:if>
			<c:if test="${fly==2 }">
			<li><a href="#">推荐图书</a></li>
			</c:if>
			<c:if test="${fly==3 }">
			<li><a href="#">特价图书</a></li>
			</c:if>
		</ol>
	</div>


	<!--图书列表 begin-->
	<div class="container">
		<div class="row">
	 	<c:forEach items="${book }" var="b">
		<div class="col-sm-6 col-md-3 wow fadeInLeft animated">
				<div class="thumbnail">
					<a href="../book/details?bookId=${b.bookId}"><img src="${path}../images/${b.imgUrl}"
						alt="通用的占位符缩略图"></a>
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
		
		</div>
	</div>
	<!--图书列表end-->
	
 
	<!-- 引入分页 -->
	<%@ include file="../common/page.jsp" %>
	
	<!--地址-->
	<div class="container">
		<hr>
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
	<!--end-->
	<script src="../dist/js/jquery.min.js"></script>
	<script src="../js/carousel.js" type="text/javascript" charset="utf-8"></script>
	<script src="../dist/js/bootstrap.min.js"></script>
	<script src="../js/wow.js"></script>
	

</body>
</html>