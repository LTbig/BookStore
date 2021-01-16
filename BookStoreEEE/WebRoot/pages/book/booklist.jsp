<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@include file="/include/base.jsp"%>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<!--这里是操作菜单(几乎所有页面都会共用) 故进行单独抽取  -->
		      <%@include file="/include/user_info.jsp" %>
		    <%--   ${page.pageData } --%>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="Client/BookClientServlet?method=pageByPrice" method="post">
					价格<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有
				<c:out value="${cart.totalCount}" default="0"></c:out>件商品</span>
				<div>
					您刚刚将<span style="color: red">${book.title }</span>加入到了购物车中
				</div>
			</div>
			<c:forEach items="${page.pageData}" var="book">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="static/img/default.jpg"/>
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author }</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price }</span>
					</div>
					<div class="book_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${book.sales }</span>
					</div>
					<div class="book_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${book.stock }</span>
					</div>
					<div class="book_add">
					<a style="color: blue;" href="Client/CartServlet?method=add&id=${book.id }">加入购物车</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
<%@include  file="/include/page.jsp"%>		
	</div>
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>