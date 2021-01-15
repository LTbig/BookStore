<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<%-- <%@ page session="false"%> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 所有页面要引入的资源 
base标签的链接需要按动态获取,而不是指定的
使用绝对路径
http://localhost:8080/BookStoreEE/
协议：//主机名：端口号/项目路径/
-->
<base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%>/<%=request.getContextPath()%>/"/>
<base href="http://localhost:8080/BookStoreEE"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
