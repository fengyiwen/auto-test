<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<title>主页</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">
<jsp:include page="/WEB-INF/include.jsp"></jsp:include>
</head>
<body class="no-skin">
        <tiles:insertAttribute name="header"/>
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<tiles:insertAttribute name="menu"/>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="main-content-inner">
					 <tiles:insertAttribute name="body"/>
				</div>
			</div><!-- /.main-content -->

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<!-- /.main-container -->
		
</body>
</html>