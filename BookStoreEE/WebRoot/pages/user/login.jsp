<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<%-- <%@ page session="false"%> --%>
<!DOCTYPE html>
<html>
<head>
<title>尚硅谷会员登录页面</title>
<%@include file="/include/base.jsp" %>
<script type="text/javascript">
	// 页面加载完成之后
	$(function(){
		// 给注册按钮添加事件
		$("#sub_btn").click(function(){
			
			// 获取用户名
			var usernameValue = $("#username").val();
			// 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var usernameReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!usernameReg.test(usernameValue)) {
				// 提示用户
				alert("用户名不合法！");
				return false;
			}
			
			// 获取密码
			var passwordValue = $("#password").val();
			// 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var passwordReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!passwordReg.test(passwordValue)) {
				// 提示用户
				alert("密码不合法！");
				return false;
			}
			
			// 阻止表单提交
			return true;
		});
		
	});

</script>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
					
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
								<!-- 如果没有错误信息则显示用户名密码 否则显示错误信息 -->
								<!--使用三元运算符进行判断  -->
								<%-- <%=(String)request.getAttribute("msg")==null?"请输入用户名密码":(String)request.getAttribute("msg")%>	 --%>
								<!-- 使用el表达式 -->
								${msg==null?"请输入用户名密码":msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
								<!-- 加一个隐藏表达项 -->
								    <input type="hidden" name="method" value="login"/>
									<label>用户名称：</label>
									<!--表单回显 通常是使用el表达式  -->
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" 
										tabindex="1" name="username" id="username" 
										<%-- value="<%=request.getParameter("username")==null?""
												:request.getParameter("username") %>" --%>
										value="${param.username}"	
												/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" 
									 	tabindex="1" name="password" id="password"
									/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>