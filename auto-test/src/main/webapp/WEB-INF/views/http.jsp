<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HTTP API测试</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">
<script type="text/javascript" src="stat/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script type="text/javascript" src="stat/jqgrid/js/jquery.jqGrid.min.js"></script>
<link href="stat/jqgrid/css/ui.jqgrid-bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="stat/js/jquery.json.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootbox.js/4.4.0/bootbox.min.js"></script>
<style type="text/css">
html {
	height: 100%;
	margin: 0;
}

body {
	height: 100%;
	margin: 0;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
</style>

<script type="text/javascript">
 
$(function(){
	$("#inputURL").blur(function(){
          if($.trim($(this).val())==""||$.trim($(this).val())==null){
               return;
           }
          $('#requestTreeGrid').jqGrid({
        			hoverrows:false,
        			viewrecords:false,
        			gridview:true,
        			styleUI:"Bootstrap",
        			url:"getRequestJqGridTree?url="+$.trim($(this).val()),
        			editurl : "clientArray",
        			ExpandColumn:"name",
        			//height:"auto",
        			sortname:"id",
        			/* "sortorder":"desc", */
        			width:1100,
        			height:"auto",
        			autoScroll: true,  
        			scrollrows:true,
        			treeGrid:true,
        			treedatatype:"json",
        			treeGridModel:"adjacency",
        			loadonce:true,
        			rowNum:1000,
        			treeReader:{
        				parent_id_field:"parent_id",
        				level_field:"level",
        				leaf_field:"isLeaf",
        				expanded_field:"expanded",
        				loaded:"loaded",
        				icon_field:"icon"
        			},
        			datatype:"json",
        			colModel:[
                       // {name: 'operator',label:"操作", width:80, fixed:true, sortable:false, resize:false, formatter:'actions', formatoptions:{keys:true}},
        				{   name:"id",
        					key:true,
        					hidden:true
        				},{
        					name:"name",
        					label:"字段",
        					width:100,
        					editable:false,
        					edittype:"text",
        					editrules:{required:true}
        				},{
        					name:"type",
        					label:"类型",
        					width:100,
        					edittype:"select",//设定格式为下拉表单
        					editrules:{required:true},
        					editoptions:{value: { 1: 'string', 2: 'number',3:'object',4:'boolean',5:'array<string>',6:'array<number>',7:'array<object>',8:'array<boolean>',9:'array'}},
        					editable:false
        				},{
        					name:"description",
        					label:"描述",
        					width:150,
        					align:"right",
        					editable:false
        				},{
        					name:"remark",
        					label:"备注",
        					width:170,
        					align:"right",
        					editable:false
        				},{
        					name:"value",
        					label:"请求值",
        					width:100,
        					align:"right",
        					editable:true,
        					edittype:"text"
        				},{
        					name:"parent_id",
        					hidden:true
        				}
        			],
        			//"rownumbers":true,
        			pager:"#requestPager",
          			cellEdit:true,
          			cellsubmit: "clientArray",
          			afterEditCell:function(rowid,name,val,iRow,iCol){
          				     var rowdata = $("#tree").jqGrid("getRowData",rowid);
          				     var id = rowid+"_"+name;
          				    // alert(id);
          				     if(name=="value"){
          				     $("#"+id).keyup(function(e){
          				     var amt = $(this).val();
          				     var fee = rowdata["value"];
          				    // alert(fee);
          				   //  var total = parseFloat(amt) + parseFloat(fee);
          				   //  $("#tree").jqGrid("setRowData",rowid,{"total":total});
          				     });
          				 }
          		    }
        		});
        		// nable add
        		$('#requestTreeGrid').jqGrid('navGrid','#requestPager',{
        			edit:false,
        			add:true,
        			del:false,
        			search:false,
        			refresh:true,
        			view:false,
        			excel:false,
        			pdf:false,
        			csv:false,
        			columns:true 
        		},
        		{drag:true,resize:true,closeOnEscape:true,dataheight:250},
        		{drag:true,resize:true,closeOnEscape:true,dataheight:250}
        		);
        		$('#requestTreeGrid').jqGrid('bindKeys');
          
          $('#responseTreeGrid').jqGrid({
  			hoverrows:false,
  			viewrecords:false,
  		    gridview:true,
  			styleUI:"Bootstrap",
  			url:"getResponseJqGridTree?url="+$.trim($(this).val()),
  			editurl: "clientArray",
  			ExpandColumn:"name",
  			//height:"auto",
  			sortname:"id",
  			width:1100,
  			height:"auto",
  			autoScroll: true,  
  			scrollrows:true,
  			treeGrid:true,
  			treedatatype:"json",
  			treeGridModel:"adjacency",
  			loadonce:true,
  		    multiselect:true,
  		   // rownumbers: true, 
            //rownumWidth: 25, 
  			rowNum:1000,
  			treeReader:{
  				parent_id_field:"parent_id",
				level_field:"level",
				leaf_field:"isLeaf",
				expanded_field:"expanded",
				loaded:"loaded",
				icon_field:"icon"
  			},
  			datatype:"json",
  			//"rownumbers":true,
  			colModel:[
  			        {name : 'operator',index : '是否返回',width : 60,editable : true,edittype : "checkbox",editoptions : {value : "Yes:No"}},
  				{
  					name:"id",
  					key:true,
  					hidden:true
  				},{
  					name:"name",
  					label:"字段",
  					width:100,
  					edittype:'text',
  					editrules:{required:true},
  					editable:true
  				},{
  					name:"type",
  					label:"类型",
  					width:100,
  					editrules:{required:true},
  					editable:true,edittype:"select",//设定格式为下拉表单
					editoptions:{value: { 1: 'string', 2: 'number',3:'object',4:'boolean',5:'array<string>',6:'array<number>',7:'array<object>',8:'array<boolean>',9:'array'}},
					editable:true,
  					sortable:false
  				},{
  					name:"description",
  					label:"描述",
  					width:150,
  					align:"right",
  					editable:true
  					,sortable:false
  				},{
  					name:"remark",
  					label:"备注",
  					width:170,
  					align:"right",
  					editable:true
  					,sortable:false
  				},{
  					name:"value",
  					label:"预期返回值",
  					width:170,
  					align:"right",
  					editable:true
  					,sortable:false
  				},{
  					name:"parent_id",
  					hidden:true
  				}
  			],
  			pager:"#responsePager",
  			cellEdit:true,	
  			cellsubmit: "clientArray",
  			afterEditCell:function(rowid,name,val,iRow,iCol){
  				     var rowdata = $("#tree").jqGrid("getRowData",rowid);
  				     var id=rowid+"_"+name;
  				     if(name=="value"){
	  				     $("#"+id).keyup(function(e){
	  				     var amt = $(this).val();
	  				     var fee = rowdata["value"];
  				    // alert(fee);
  				   //  var total = parseFloat(amt) + parseFloat(fee);
  				   //  $("#tree").jqGrid("setRowData",rowid,{"total":total});
  				     });
  				 }
  		    }
  		});
  		// nable add
  		$('#responseTreeGrid').jqGrid('navGrid','#responsePager',{
  			edit:false,
			add:false,
			del:false,
			search:false,
			refresh:true,
			view:false,
			excel:false,
			pdf:false,
			csv:false,
			columns:true 
  		},
  		{"drag":true,"resize":true,"closeOnEscape":true,"dataheight":250},
  		{"drag":true,"resize":true,"closeOnEscape":true,"dataheight":250}
  		);
  		$('#responseTreeGrid').jqGrid('bindKeys');

	});
	$("#isave").click(function(){
		bootbox.setLocale("zh_CN");  
		var rquestData = $('#requestTreeGrid').jqGrid('getRowData');
		var responseData = $('#responseTreeGrid').jqGrid('getRowData');
		var messages = "";
		var param = {rquestData:rquestData,responseData:responseData};
		var requestFlag = false;
		for(var i = 0;i<rquestData.length;i++){
			if(rquestData[i].value.indexOf("input")!=-1){
				requestFlag = true;
				break;
			}
		}
		var responseFlag = false;
		for(var i = 0;i<responseData.length;i++){
			if(responseData[i].value.indexOf("input")!=-1){
				responseFlag = true;
				break;
			}
		}
		if(requestFlag){
			bootbox.alert("请求参数列表处如编辑状态，请先对编辑的数据进行保存或者取消，然后再进行保存");
			return;
		}
		if(responseFlag){
			bootbox.alert("响应参数列表处如编辑状态，请先对编辑的数据进行保存或者取消，然后再进行保存");
			return;
		}
		//找到请求字段中为必填而没填值得行
		for(var i = 0;i<rquestData.length;i++){
			if(rquestData[i].remark.indexOf("必填")!=-1){
			  if(rquestData[i].value==""||rquestData[i].value==null){
                  messages+="字段"+rquestData[i].name+",是必填字段，不能为空！";
                
			   }
			}
		}
		if(messages!=""&&messages!=null){
			alert(messages);
			return;
		}
		 $.ajax({
			type : "POST",
			url : "saveInterface?url="+$("#inputURL").val(),
		    datatype:"json",  
			data : $.toJSON(param),  
			contentType: "application/json; charset=utf-8",  
			async : false,
			cache : false,
			success : function(data) {
				if(data.resCode=='000000') {
					bootbox.alert("保存成功！");
				}
			},
			error : function(e) {
				bootbox.alert("对不起，后台处理发生异常，请联系管理员!");
			}
		}); 
	});

	$("#isave").click(function(){
		var rquestData = $('#requestTreeGrid').jqGrid('getRowData');
		var responseData = $('#responseTreeGrid').jqGrid('getRowData');
		var messages = "";
		var param = {rquestData:rquestData,responseData:responseData};
		var requestFlag = false;
		for(var i = 0;i<rquestData.length;i++){
			if(rquestData[i].value.indexOf("input")!=-1){
				requestFlag = true;
				break;
			}
		}
		var responseFlag = false;
		for(var i = 0;i<responseData.length;i++){
			if(responseData[i].value.indexOf("input")!=-1){
				responseFlag = true;
				break;
			}
		}
		if(requestFlag){
			alert("请求参数列表处如编辑状态，请先对编辑的数据进行保存或者取消，然后再进行保存");
			return;
		}
		if(responseFlag){
			alert("响应参数列表处如编辑状态，请先对编辑的数据进行保存或者取消，然后再进行保存");
			return;
		}
		//找到请求字段中为必填而没填值得行
		for(var i = 0;i<rquestData.length;i++){
			if(rquestData[i].remark.indexOf("必填")!=-1){
			  if(rquestData[i].value==""||rquestData[i].value==null){
                  messages+="字段"+rquestData[i].name+",是必填字段，不能为空！";
			   }
			}
		}
		if(messages!=""&&messages!=null){
			alert(messages);
			return;
		}
		 $.ajax({
			type : "POST",
			url : "httpRun?url="+$("#inputURL").val(),
		    datatype:"json",  
			data : $.toJSON(param),  
			contentType: "application/json; charset=utf-8",  
			async : false,
			cache : false,
			success : function(data) {
				if(data.resCode=='000000') {
					alert("运行成功！");
				}
			},
			error : function(e) {
				alert("对不起，后台处理发生异常，请联系管理员!");
			}
		}); 
	});
});
</script>
 
</head>
<body style="padding: 0px">
	 
	<div class="container" style="height: 100%">
		<form action="" id="interfaceForm" class="form-horizontal">
			<div class="row clearfix">
			<!-- 前置折叠 -->
			<div class="panel-group" id="panelBefore">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #FCFCFC;">
							<i class="fa fa-home fa-lg"></i>
							<!-- <em class="glyphicon glyphicon-home"></em> -->
							此处展示用例目录和ID
					</div>
					<div id="panelRunBefore" class="panel-collapse in">
						<div class="container" id="runBeforeAll">

							<!-- <ul id="requestZTree" class="ztree" style="width: 700px; overflow: auto;"></ul> -->
							<div class="row">
								<div class="col-md-12">
								<div class="col-md-10">
								  	<input class="form-control" id="inputURL" type="url" name="url"
									placeholder="请输入需要访问的URL地址" />
						 
							</div>
							<div class="col-md-2">
								<select class="form-control" id="method" name="method">
									<option value="GET">GET</option>
									<option value="POST">POST</option>
								</select>
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
	 
				</div>
			</div>

			<!-- 前置折叠 -->
			<div class="panel-group" id="panelBefore">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #FCFCFC;">
						<a class="panel-title" data-toggle="collapse"
							data-parent="#panelBefore" href="#panelRunBefore">请求参数列表<!-- <em
							class="glyphicon glyphicon-collapse-down"></em> -->
							<i class="fa fa-toggle-down"></i></a>
						<!-- <button class="glyphicon glyphicon-plus btn btn-primary"
							id="runBeforeAdd" style="margin-left: 80%" type="button">
							</botton> -->
					</div>
					<div id="panelRunBefore" class="panel-collapse in">
						<div class="container" id="runBeforeAll">

							<!-- <ul id="requestZTree" class="ztree" style="width: 700px; overflow: auto;"></ul> -->
							<div class="row">
								<div class="col-md-12">
								    <div id="requestPager"></div>
									<table id="requestTreeGrid"></table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 后置折叠 -->
			<div class="panel-group" id="panelAfter">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #FCFCFC;">
						<a class="panel-title" data-toggle="collapse"
							data-parent="#panelAfter" href="#panelRunAfter">响应参数列表<em
							class="fa fa-toggle-down"></em></a>
						<!-- <button class="glyphicon glyphicon-plus btn btn-primary"
								id="runAfterAdd" style="margin-left: 80%" type="button">
								</botton> -->
					</div>
					<div id="panelRunAfter" class="panel-collapse in">
						<div class="container" id="runAfterAll">
							<div class="row">
								<div class="col-md-12">
								    <div id="responsePager"></div>
									<table id="responseTreeGrid"></table>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="col-md-12 column">
							<div class="input-append">
								<div class="col-sm-1">
									<button class="btn btn-success" type="button" id="isave">
										<em class="glyphicon glyphicon-floppy-save"></em> 保存
									</button>
								</div>
								<div class="col-sm-1">
									<button class="btn btn-warning" type="button" id="isend">
										<em class="glyphicon glyphicon-play"></em> 运行
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
	</div>
	 
</body>
</html>