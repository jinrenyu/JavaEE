<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>图书详情</title>
		<link type="text/css" rel="stylesheet" href="../dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../css/index.css" />
		<link rel="stylesheet" type="text/css" href="../css/animate.css" />
	</head>

	<body>
		<!-- 引入导航部分 -->
		<%@ include file="../common/nav.jsp" %>

		<!--外层div-->
		<div class="container">
			<!--左边-->
			<div class="col-md-8 col-sm-12">
				<ol class="breadcrumb">
					<li>
						<a href="#">图书详情</a>
					</li>
					<li>
						<a href="#">${bookDetails.name }</a>
					</li>
				</ol>

				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="thumbnail">
							<a><img src="../images/${bookDetails.imgUrl}" style="height: 200px;" alt="通用的占位符缩略图"></a>
							<div class="caption">
								<h3>${bookDetails.name }</h3>
								<p>双十一特价,包邮哟!亲<img src="../images/3.gif" style="width: 24px;height: 24px;"></p>
								<p>
									<div style="margin-bottom: 5px;width: 100px;">
										<input type="number" id="buynumber" name="buynumber" class="form-control" placeholder="购买数量" min="1" max="100" onclick="selectByCount(this)">
									</div>
									<div style="clear: both;">
										<!--<input type="number" class="form-control" placeholder="请输入" min="1" max="100" onclick="selectByCount(this)">-->
										<a href="confirm_order.jsp" class="btn btn-default" role="button">
											<span class="glyphicon glyphicon-usd"></span> 立即购买
										</a>
										<a  class="btn btn-default" type="button" onclick="addBook(this)">
											<span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车
										</a>
										<%-- <a href="${path }/book/addtocart?bookId=${bookDetails.bookId}" class="btn btn-default" role="button">
											<span class="glyphicon glyphicon-shopping-cart"></span> 加入购物车
										</a> --%>
									</div>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-6">
						<div class="thumbnail">
							<ul class="list-group">
								<li class="list-group-item"><span class="text-success">图书名称:${bookDetails.name }</span></li>
								<li class="list-group-item"><span class="text-info">作者:</span>${bookDetails.author }</li>
								<li class="list-group-item"><span class="text-info">出版日期:${bookDetails.publish_date }</span></li>
								<li class="list-group-item"><span class="text-info">出版社:</span>:${bookDetails.publisher }</li>
								<li class="list-group-item"><span class="text-info" style="text-decoration: line-through;">原价:</span><span style="text-decoration: line-through;">${bookDetails.oldPrice }</span></li>
								<li class="list-group-item"><span class="text-info">现价:</span>${bookDetails.newPrice }</li>
								<li class="list-group-item"><span class="text-info">说明:</span> ${bookDetails.info }
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!--<hr>-->
				<!--折叠部分 begin-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
							展开详细信息
						</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse">
						<div class="panel-body">
							<!--tab选项卡 begin-->
							<ul id="myTab" class="nav nav-tabs">
								<li class="active">
									<a href="#home" data-toggle="tab">
										商品详情
									</a>
								</li>
								<li>
									<a href="#ios" data-toggle="tab"> <span class="badge pull-right">50</span>累计评价</a>
								</li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="home">
									<p>
										<em>产品参数：</em>
									</p>
									<div class="row">
										<div class="col-sm-12 col-md-6">
											<ul class="nav navbar-collapse" style="line-height: 3;">
												<li class="text-info">产品名称：${bookDetails.name }</li>
												<li class="text-info">是否是套装:${bookDetails.suit }</li>
												<li class="text-info">书名:${bookDetails.name }</li>
												<li class="text-info">定价: ${bookDetails.oldPrice }</li>
												<li class="text-info">出版社名称:${bookDetails.publisher }</li>
												<li class="text-info">出版时间:${bookDetails.publish_date }</li>
												<li class="text-info">作者:${bookDetails.author }</li>
												<li class="text-info">作者地区:${bookDetails.author_loc }</li>
												<li class="text-info">书名: ${bookDetails.name }</li>
												<li class="text-info">ISBN编号:${bookDetails.isbn }</li>
											</ul>
										</div>
										<span class="visible-sm visible-xs"><hr></span>
										
									</div>
									</p>
								</div>
								<div class="tab-pane fade" id="ios">
									<p>
										<ul class="list-group">
											<li class="list-group-item"><span class="text-info">小明:</span><span class="text-success ">这真的是一本好书<img src="${path }../images/emotions/1.gif "></span></li>
											<li class="list-group-item"><span class="text-info">success:</span><span class="text-danger ">书的质量很差<img src="${path }../images/emotions/2.gif "></span></li>
											<li class="list-group-item"><span class="text-info">叶老师:</span><span class="text-success ">很值得初学者学习<img src="${path }../images/emotions/13.gif "></span></li>
											<li class="list-group-item"><span class="text-info">amdin:</span><span class="text-danger ">被坑大发了.<img src="${path }../images/emotions/17.gif "></span></li>
											<li class="list-group-item"><span class="text-info">rose:</span><span class="text-danger ">卖家态度恶劣.<img src="${path }../images/emotions/11.gif "></span></li>
										</ul>
									</p>
									<p>
										<ul class="pager">
											<li>
												<a href="# ">&larr;上一页</a>
												<a href="# ">下一页 &rarr;</a>
											</li>
										</ul>
									</p>
								</div>
							</div>
							<!--tab选项卡 end-->
						</div>
					</div>
				</div>
				<!--折叠部分end-->
			</div>

			<!--右边-->
			<div class="col-md-4 col-sm-3 col-xs-8">
				<ol class="breadcrumb ">
					<li>
						<a href="../jsp/cart.jsp " class="text-success "><span class="glyphicon glyphicon-shopping-cart "></span>我的购物车</a>
					</li>
					<li>
						<a href="# " id="bookcount">${cart.count }个商品</a> 
					</li>
					<li>
						 <a href="# " id="bookprice">总价${cart.total }元</a> 
					</li>
				</ol>

				<!--猜您喜欢-->
				<div>
					<span class="text-info"><span class="glyphicon glyphicon-heart"></span><span style="font-size: 20px; ">猜您喜欢</span></span>
					<div class="row" id="love">
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail">
								<a href="details.html"><img src="../images/xiaodaolifencunzhijian.jpg " style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>小道理：分寸之间</h3>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail ">
								<a href="details.html"><img src="../images/NO SECRETS.jpg " style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>名创优品没有秘密</h3>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-12 wow fadeInRight animated">
							<div class="thumbnail ">
								<a href="details.html"><img src="../images/maichanpinjiushimaiziji.jpg" style="height: 200px; " alt="通用的占位符缩略图 "></a>
								<div class="caption ">
									<h3>卖产品就是卖自己</h3>
								</div>
							</div>
						</div>
						<div>
							<ul class="pager ">
								<li>
									<a href="# " onclick="pageUp() ">&larr;上一页</a>
									<a href="# " onclick="pageDown() ">下一页 &rarr;</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="container">
			<!--首页底部信息 begin-->
			<div class="container ">
				<div class="row ">
					<div class="col-md-offset-2 col-md-8 ">
						<div class="row ">
							<div class="col-md-offset-2 col-md-2 ">
								<img src="../images/logo.png ">
							</div>
							<div class="col-md-6 ">
								<div class="row ">
									<div class="col-md-offset-2 col-md-10 ">
										<a href="http://www.sztzedu.com ">威思登软件科技有限公司&copy;所有</a>
									</div>
								</div>
								<div class="gap "></div>
								<div class="row ">
									<div class="col-md-offset-2 col-md-10 ">
										<span class="text-info ">天智教育&reg; |&nbsp;</span>
										<span class="text-info ">项目实训管理平台 |&nbsp;</span>
										<span class="text-info ">2012－2020 </span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<script src="../dist/js/jquery.min.js"></script>
		<script src="../js/wow.js"></script>
		<script src="../js/carousel.js" type="text/javascript"></script>
		<script src="../dist/js/bootstrap.min.js"></script>
		<script src="../js/details.js" type="text/javascript" charset="utf-8"></script>
		<script type="../text/javascript">
			if(!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
				new WOW().init();
			};
		</script>
	</body>
</html>

