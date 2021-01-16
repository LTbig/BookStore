<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@include file="/include/base.jsp"%>
<script type="text/javascript">
    $(function(){
    	//点击删除的逻辑实现
    	$(".delBtn").click(function(){
    		//this代表当前被点击的a标签
    		//alert("删除");
    		//找到a标签的祖父节点tr的第一个子元素td
    		var td=$(this).parent().parent().children(":first");
    		//alert(td.text());
    		if(!confirm("确认删除【"+td.text()+"】吗？")){
    			//图书管理员用户点击取消(不删除)
    			return false;
    		};
    	});
    });
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%@include file="/include/book_manager.jsp" %>	
	</div>
	<%-- ${requestScope.list } 这个是所有图书的集合 现在需要友好的在页面显示 --%>
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
		<!--遍历  -->	
		<c:forEach items="${requestScope.page.pageData }" var="book">
			 <tr>		
				<td>${book.title}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<%-- <td><a href="Manager/BookManagerServlet?method=getBook&id=${book.id}&m=update">修改</a></td> --%>
				<!-- 不带参数(param)的改进方法 -->
				<td><a href="Manager/BookManagerServlet?method=getBook&id=${book.id}&pn=${page.pageNo}">修改</a></td>
				<td><a class="delBtn" href="Manager/BookManagerServlet?method=delete&id=${book.id}&pn=${page.pageNo}">删除</a></td>
			</tr>		
		</c:forEach>
		   <tr>	
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<!-- <td><a href="pages/manager/book_edit.jsp?m=add">添加图书</a></td> -->
			<!-- 不带参数(param)的改进方法 -->
			<!--我们这里page.totalPage+1   是为了当页数为整数页时添加一个图书信息数据后会使totalPage+1-->
			<!-- 而且当页数不为整数页时  因为在bean层进行了pageNo和totalPage的边界判断所以仍然是返回totalPage -->
			<td><a href="pages/manager/book_edit.jsp?&pn=${page.totalPage+1}">添加图书</a></td>
			</tr>	
		</table>		
<%@include  file="/include/page.jsp"%>
	</div>
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>