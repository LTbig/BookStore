<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<%-- <%@page session="false"%>  --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--用户未登录显示这个菜单  -->
<c:if test="${empty user }">
<!--用户未登录  -->
<div>
		<a href="pages/user/login.jsp">登录</a>  
		<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
		<a href="pages/cart/cart.jsp">购物车</a>
		<a href="pages/manager/manager.jsp">后台管理</a>
	</div>
</c:if>
<!--用户登录后显示下面这个菜单  -->
<c:if test="${!empty user }">
<div>
	<span>欢迎<span class="um_span">${user.username}</span>光临尚硅谷书城</span>
	<a href="pages/order/order.jsp">我的订单</a>
	<a href="UserServlet?method=logout">注销</a>&nbsp;&nbsp;
	<a href="index.jsp">返回</a>
	</div>
</c:if>					