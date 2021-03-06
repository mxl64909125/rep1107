<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>品优购运营商运营管理后台</title>


    <link rel="stylesheet" type="text/css" href="css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="css/pages-login-manage.css" />
</head>

<body>
	<div class="loginmanage">
		<div class="py-container">
			<h4 class="manage-title">电商网站运营管理后台</h4>
			<div class="loginform">

				<ul class="sui-nav nav-tabs tab-wraped">
					
					<li class="active">
						<a href="#profile" data-toggle="tab">
							<h3>账户登录</h3>
						</a>
					</li>
					
				</ul>
				<div class="tab-content tab-wraped">
					<c:if test="${not empty loginError}">
						<p style="color:red;">${loginError}</p>
					</c:if>
					
					<div id="profile" class="tab-pane  active">
						<form class="sui-form" action="userServlet?oper=login" method="post">
							<div class="input-prepend"><span class="add-on loginname"></span>
								<input id="prependedInput" type="text" name="uaccount" placeholder="请输入您的账号" class="span2 input-xfat">
							</div>
							<div class="input-prepend"><span class="add-on loginpwd"></span>
								<input id="prependedInput" type="password" name="upwd" placeholder="请输入密码" class="span2 input-xfat">
							</div>
							<!-- <div class="setting">
								 <div id="slider">
									<div id="slider_bg"></div>
									<span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
									</div>
							</div> -->
							<div class="logined">
								<!-- <a class="sui-btn btn-block btn-xlarge btn-danger" href="admin/index.html" target="_blank">登&nbsp;&nbsp;录</a> -->
								<input type="submit" value="登&nbsp;&nbsp;录" class="sui-btn btn-block btn-xlarge btn-danger"/>
							</div>
						</form>

					</div>
					
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>


	<!--foot-->
	<div class="py-container copyright">
		<ul>
			<li>关于我们</li>
			<li>联系我们</li>
			<li>联系客服</li>
			<li>商家入驻</li>
			<li>营销中心</li>
			<li>手机品优购</li>
			<li>销售联盟</li>
			<li>品优购社区</li>
		</ul>
		<div class="address">地址：东新区建材嘻嘻嘻嘻嘻嘻嘻x办公楼一层 邮编：100096 电话：600-618-4000 传真：010-666666</div>
		<div class="beian">ICP备086666号公网安备11010455666702
		</div>
	</div>


<script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script src="js/pages/jquery.slideunlock.js"></script>
<script>
	$(function(){
		var slider = new SliderUnlock("#slider",{
				successLabelTip : "欢迎访问品优购"	
			},function(){
				// alert("验证成功,即将跳转至首页");
            	// window.location.href="index.html"
        	});
        slider.init();
	})
	</script>
</body>

</html>
