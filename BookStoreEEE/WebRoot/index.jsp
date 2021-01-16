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
<!-- 转发到真正的index页面(booklist.jsp) -->
<jsp:forward page="/Client/BookClientServlet?method=page"></jsp:forward>
</body>
</html>