<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>尚硅谷会员注册页面</title>
<!-- 引入所需的资源路径 -->
<%@include file="/include/base.jsp" %>
<script type="text/javascript">
/* 
正则表达式
1.创建一个正则表达式
    var reg = /a/;
2.使用正则表达式的test方法验证传入的字符串是否符合规则 返回boolean
   reg.test("abc");
*
*/

	// 页面加载完成之后
	$(function(){
		
		// 给注册按钮添加事件
		$("#sub_btn").click(function(){
			
			// 获取用户名
			//var usernameValue = $("#username").val();
			var usernameValue = $(".itxt[name='username']").val();
			// 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var usernameReg = /^\w{5,15}$/;//正则表达式
			// 验证用户信息
			if (!usernameReg.test(usernameValue)) {
				// 提示用户
				//alert("用户名不合法！");
				$(".errorMsg").text("用户名不合法");
				return false;//当一旦碰到不合法时就告诉用户
			}
			
			// 获取密码
			var passwordValue = $("#password").val();
			//var usernameValue = $(".itxt[name='password']").val();
			// 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var passwordReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!passwordReg.test(passwordValue)) {
				// 提示用户
				//alert("密码不合法！");
				$(".errorMsg").text("密码不合法!");
				return false;
			}
			
			// 获取确认密码
			var repwdValue = $("#repwd").val();
			//var repwdValue = $(".itxt[name='repwd']").val();
			// 验证确认密码和密码一致
			if (passwordValue != repwdValue) {
				// 提示用户
				//alert("确认密码和密码不一致！");
				$(".errorMsg").text("密码不一致！");
				return false;
			}
			
			// 获取用户名
			var emailValue = $("#email").val();
			//var emailValue = $(".itxt[name='email']").val();
			// 验证邮件输入是否合法。
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if (!emailReg.test(emailValue)) {
				// 提示用户
				//alert("邮件输入不合法！");
				$(".errorMsg").text("邮件输入不合法！");
				return false;
			}
			
			
			// 获取验证码信息
			//var codeValue = $("#code").val();
			var codeValue = $(".itxt[name='code']").val();
			// 验证验证码不为空！
			if (codeValue=="") {
				//alert("验证码不能为空！请输入验证码");
				$(".errorMsg").text("验证码不能为空！请输入验证码！");
			}
	
			return true;
		});
		
	});

</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	 
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
								<!-- 如果没有错误信息则显示用户名密码 否则显示错误信息 -->
								<!--使用三元运算符进行判断  -->
								<%-- <%=(String)request.getAttribute("msg")==null?"请输入您的个人信息":(String)request.getAttribute("msg")%> --%>
								<!--使用el表达式  -->
								${msg==null?"请输入您的个人信息":msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
								<!-- 加一个隐藏表达项 -->
								    <input type="hidden" name="method" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" 
									<%-- value="<%=request.getParameter("username")==null?""
											:request.getParameter("username")%>"  --%>
									value="${param.username}"		
											/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"  />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" 
								<%-- 	value="<%=request.getParameter("email")==null?""
											:request.getParameter("email")%>"  --%>
										value="${param.email}"		
											/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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