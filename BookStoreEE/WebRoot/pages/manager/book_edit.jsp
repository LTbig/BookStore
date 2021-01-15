<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@include file="/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
		    <%@include file="/include/book_manager.jsp" %>
		</div>
		
		<div id="main">
			<form action="Manager/BookManagerServlet" method="post">
			<!-- 隐藏一个input标签   且动态获取value值 -->
			<%--  <input type="hidden" name="method" value="${param.m }"/>
			 <input type="hidden" name="id" value="${book.id }"/> --%>
			 <!-- 改进方法:这里也不需要再动态带参数  添加和修改都直接过update方法 -->
			  <input type="hidden" name="method" value="update"/>
			 <input type="hidden" name="id" value="${book.id}"/>
			 <input type="hidden" name="pn" value="${param.pn}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="title" type="text" value="${book.title }"/></td>
						<td><input name="price" type="text" value="${book.price }"/></td>
						<td><input name="author" type="text" value="${book.author }"/></td>
						<td><input name="sales" type="text" value="${book.sales }"/></td>
						<td><input name="stock" type="text" value="${book.stock }"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>