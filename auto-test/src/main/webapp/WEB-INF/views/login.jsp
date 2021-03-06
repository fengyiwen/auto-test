<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>登录</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
       <jsp:include page="/WEB-INF/include.jsp"></jsp:include>

		<!-- text fonts -->
		<link rel="stylesheet" href="stat/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="stat/assets/css/ace.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.css" />
		<![endif]-->
		<link rel="stylesheet" href="stat/assets/css/ace-rtl.css" />
		<script type="text/javascript">
			window.jQuery || document.write("<script src='stat/assets/js/jquery.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='stat/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
          $(function(){
             $("#loginBtn").click(function(){
            /*      if($("#username").val()==''||$("#username").val()==null){
                     alert("请输入用户名");
                     $("#username").focus();
                     return;
                 }
                 if($("#password").val()==''||$("#password").val()==null){
                     alert("请输入密码");
                     $("#password").focus();
                     return;
                 } */
                 $("#loginForm").submit();
             });
          });
		</script>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">凹凸</span>
								<span class="white" id="id-text2">自动化测试平台</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; atzuche</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> 请输入您的信息
										</h4>

										<div class="space-6"></div>

										<form name="loginForm" id="loginForm" action="login" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" name="username" id="username" required="required"data-msg-required="请填写登录账号"  placeholder="用户名" /> <i
														class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" name="password" id="password" required="required" data-msg-required="请填写登录密码"  placeholder="密码" />
														<i class="ace-icon fa fa-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> 记住我</span>
													</label>

													<button type="button" id="loginBtn"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">登录</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>