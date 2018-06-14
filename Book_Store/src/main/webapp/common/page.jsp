<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="url" value="${path}../book/list?bookQueryName=${bookName}&selection=${styleId}&pageSize=${pageBean.pageSize}"></c:set>

<div class="container" style="text-align: center">
	<ul class="pagination">
		<li><a href="${url}&pageNow=1">首页</a></li>
						

		<!-- 判断是否到达首页 -->
		<c:if test="${pageBean.pageNow==1 }">
			<li class="disabled"><a>&laquo;</a></li>			
		</c:if>
		
		<c:if test="${pageBean.pageNow!=1 }">
			<li><a href="${url}&pageNow=${pageBean.pageNow-1}">&laquo;</a></li>		
		</c:if>
		
		<!-- 进行边界值的判断 -->
		<c:choose>
			<c:when test="${pageBean.pageNow+2<=pageBean.pageCount }">
				<c:set value="${pageBean.pageNow}" var="beg"></c:set>
			</c:when>
			<c:when test="${pageBean.pageNow+2>pageBean.pageCount }">
				<c:set value="${pageBean.pageCount-2}" var="beg"></c:set>
			</c:when>
		</c:choose>
		
		<!-- 具体的标签页 -->
		<c:forEach var="v" begin="${beg<=0?1:beg}" end="${beg+2}">
			<c:if test="${pageBean.pageNow==v}">
				<li class="active"><a href="${url}&pageNow=${v}">${v}</a></li>
			</c:if>
			<c:if test="${pageBean.pageNow!=v}">
				<li><a href="${url}&pageNow=${v}">${v}</a></li>
			</c:if>
		</c:forEach>
	
		<!-- 判断是否到达了尾页 -->
		<c:if test="${pageBean.pageNow==pageBean.pageCount }">			
			<li class="disabled"><a>&raquo;</a></li>
		</c:if>
		<c:if test="${pageBean.pageNow!=pageBean.pageCount }">			
			<li><a href="${url}&pageNow=${pageBean.pageNow+1}">&raquo;</a></li>
		</c:if>
		
		<li><a href="${url}&pageNow=${pageBean.pageCount}">尾页</a></li>
		<li><a href="#">当前页${pageBean.pageNow }/${pageBean.pageCount }总页</a></li>
		<li>	
			<div id="gp" class="input-group col-md-3 col-xs-6 pull-left"
				style="positon: relative;margin-left: 2px">
				<input id='goPage' type="text" class="form-control" placeholder="跳转页" /> <span
					class="input-group-btn">
					<div id="outer">
					<button onmouseover="go()" class="btn btn-info btn-search">
						<span>GO</span>
					</button>
					</div>
					<!-- <button class="btn btn-info" title="Popover title"  
						data-container="body" data-toggle="popover" data-placement="right" 
							data-content="右侧的 Popover 中的一些内容">
						<span>GO</span>
					</button> -->
				</span>
			</div>
		</li>
		<li>
			<div class="col-md-3 pull-right">
				<label style="display:inline">每页显示</label>
				<select id="size" class="form-control" onchange="displaySize(this)" style="display: inline;width: 100px">
					<option value="2" <c:if test="${pageBean.pageSize==2 }">selected</c:if>>2</option>
					<option value="4" <c:if test="${pageBean.pageSize==4 }">selected</c:if>>4</option>
					<option value="6" <c:if test="${pageBean.pageSize==6 }">selected</c:if>>6</option>
					<option value="8" <c:if test="${pageBean.pageSize==8 }">selected</c:if>>8</option>
				</select><label>条</label>
			</div>
		</li>
	</ul>
</div>