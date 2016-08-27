<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<link href="stat/bootstrap/css/bootstrap.min.css?_r=20151111.v0.11.5.dev" rel="stylesheet"></link>
<link href="stat/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="stat/jqgrid/js/jquery-1.11.0.min.js">
</script>
<script src="stat/bootstrap/js/bootstrap.min.js?_r=20151111.v0.11.5.dev" type="text/javascript"></script>
<link rel="stylesheet" href="stat/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="stat/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />


<!-- ace settings handler -->
<script src="stat/assets/js/ace-extra.js"></script>

<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='stat/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>
 
<script src="stat/assets/js/jquery-ui.custom.js"></script>
<script src="stat/assets/js/jquery.ui.touch-punch.js"></script>
<script src="stat/assets/js/jquery.easypiechart.js"></script>
<script src="stat/assets/js/jquery.sparkline.js"></script>
<script src="stat/assets/js/flot/jquery.flot.js"></script>
<script src="stat/assets/js/flot/jquery.flot.pie.js"></script>
<script src="stat/assets/js/flot/jquery.flot.resize.js"></script>

<!-- ace scripts -->
<script src="stat/assets/js/ace/elements.scroller.js"></script>
<script src="stat/assets/js/ace/elements.colorpicker.js"></script>
<script src="stat/assets/js/ace/elements.fileinput.js"></script>
<script src="stat/assets/js/ace/elements.typeahead.js"></script>
<script src="stat/assets/js/ace/elements.wysiwyg.js"></script>
<script src="stat/assets/js/ace/elements.spinner.js"></script>
<script src="stat/assets/js/ace/elements.treeview.js"></script>
<script src="stat/assets/js/ace/elements.wizard.js"></script>
<script src="stat/assets/js/ace/elements.aside.js"></script>
<script src="stat/assets/js/ace/ace.js"></script>
<script src="stat/assets/js/ace/ace.ajax-content.js"></script>
<script src="stat/assets/js/ace/ace.touch-drag.js"></script>
<script src="stat/assets/js/ace/ace.sidebar.js"></script>
<script src="stat/assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="stat/assets/js/ace/ace.submenu-hover.js"></script>
<script src="stat/assets/js/ace/ace.widget-box.js"></script>
<script src="stat/assets/js/ace/ace.settings.js"></script>
<script src="stat/assets/js/ace/ace.settings-rtl.js"></script>
<script src="stat/assets/js/ace/ace.settings-skin.js"></script>
<script src="stat/assets/js/ace/ace.widget-on-reload.js"></script>
<script src="stat/assets/js/ace/ace.searchbox-autocomplete.js"></script>
 
