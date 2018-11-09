<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/core.js"></script>
	<script src="http://cdn.bootcss.com/vue/2.1.10/vue.js"></script>
	<script src="http://cdn.bootcss.com/vue-router/2.2.0/vue-router.js"></script>
	<script src="http://cdn.bootcss.com/vue-resource/1.1.0/vue-resource.js"></script>
	<div id="app">
		<p>{{ message }}</p>
	</div>

	<script>
		new Vue({
			el : '#app',
			data : {
				message : 'Hello Vue.js!'
			}
		})
	</script>

	<div id="vue_det">
		<h5>site : {{site}}</h5>
		<h5>url : {{url}}</h5>
		<h5>{{details()}}</h5>
	</div>
	<script type="text/javascript">
		var vm = new Vue({
			el : '#vue_det',
			data : {
				site : "菜鸟教程",
				url : "www.runoob.com",
				alexa : "10000"
			},
			methods : {
				details : function() {
					return this.site + " - test";
				}
			}
		})
	</script>
	<div class="form-group">
		<div class="row">
			<div class="col-sm-8">
				<input type="text" id="code" class="form-control" placeholder="验证码"
					data-toggle="tooltip" data-placement="top">
			</div>
			<div class="col-sm-4">
				<img id="codeImg"
					src="/springmvcDemo/kaptcha.jpg"
					class="img-responsive"
					style="display: block; width: 200px; height: 32px">
			</div>
		</div>
		<%-- <li id="liUserNum">
			<div class="loginIpt loginIpt-focus" id="userNumBox"
				style="z-index: 2;">
				<i id="userLoginIco" class="i-uid"></i>
				<c:choose>
					<c:when
						test="${domain.realDomain != null && domain.realDomain != ''}">
						<div class="mail-addr">
							<input autocomplete="off" class="login-txt"
								style="width: 147px; font-weight: bold; color: #333;"
								tabIndex="1" id="usernumber" name="usernumber" class="log_txt"
								type="text" value="" />
							<p id="default_domain" style="width: 80px; text-align: center"
								class="ym">
								@
								<c:out value='${domain.realDomain}' />
							</p>
						</div>
					</c:when>
					<c:otherwise>
						<input autocomplete="off" style="font-weight: bold; color: #333;"
							tabIndex="1" id="usernumber" class="login-txt" type="text"
							value="" />
					</c:otherwise>
				</c:choose>
				<span class="pswtip" id="mail_acotip">邮箱帐号</span>
				<ul class="uid-slt" id="loginPannel"
					style="display: none; height: 212px;">
				</ul>
			</div>
		</li>
		<!-- 密码 -->
		<li>
			<div class="loginIpt" id="pwdBox">
				<i class="i-psw"></i> <input id="password"
					style="font-weight: bold; color: #333;" name="password"
					tabIndex="2" class="login-txt" type="password" autocomplete="off"
					value="" /> <span class="pswtip" id="mail_pswtip">密码</span>
			</div>
		</li> --%>

		<!-- 验证码 -->
		<li style="z-index: 800; display: none; padding-bottom: 5px;"
			id="li_verifyCode">
			<div class="loginIpt" id="pwdBox">
				<input id="txtVerifyCode"
					style="font-weight: bold; color: #333; left: 10px;"
					name="validateCode" tabIndex="3" class="login-txt" type="text"
					autocomplete="off" value=""
					style="font-weight: bold; color: #333;ime-mode: disabled;" /> <span
					class="pswtip" id="mail_vctip" style="left: 7px;">图片验证码</span>
			</div>
			<div style="padding-top: 14px;" class="clear">
				<img style="display: block; float: left;"
					onClick="/springmvcDemo/kaptcha.jpg;return false;" id="imgRnd"
					alt="点击更换" src="">
				<p
					style="color: #666; display: block; margin-top: 0; margin-left: 176px; line-height: 18px;">
					请填入图片对应的字母或数字<br> <a
						href="javascript:/springmvcDemo/kaptcha.jpg;void(0);"
						id="a_imageRnd" style="font-size: 12px; margin-top: 2px;">看不清,换一张</a>
				</p>
			</div>
		</li>
	</div>
</body>
</html>