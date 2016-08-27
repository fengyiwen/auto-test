<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成车型JSOn字符串</title>
<meta charset="utf-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width, initial-scale=1" name="viewport">

<link href="stat/jquery-ui-1.12.0-beta.1.custom/jquery-ui.css" rel="stylesheet" type="text/css"/>
<link href="stat/jquery.multiselect2side/css/jquery.multiselect2side.css" rel="stylesheet" type="text/css"/>
<link href="stat/select2-4.0.1/dist/css/select2.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="stat/jqgrid/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="stat/jquery.multiselect2side/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="stat/jquery.multiselect2side/js/jquery.multiselect2side.js"></script>
<script type="text/javascript" src="stat/select2-4.0.1/dist/js/select2.min.js"></script>
<script type="text/javascript" src="stat/select2-4.0.1/dist/js/select2.full.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#brand").select2();
	$("#brand").change(function(){
		var brandId = $(this).val();
		$.ajax({
			data:{brandId:brandId},
			dataType:'JSON',
			type:'POST',
			url:'queryType',
			success:function(data){
			    var html="";
			    $('#searchablems2side__sx').html("");
			    $('#searchablems2side__dx').html("");
			    if(data!=null){
			    	 $.each(data, function(i, item) {
			    		html+=" <option value='"+item.typeId+"'>"+item.typeName+"</option>";
			    	});
			    }
			    $('#searchable').html(html);
				$('#searchablems2side__sx').html(html);
			},
			error:function(){
				
			}
		});
	});
	$('#searchable').multiselect2side({      
		selectedPosition: 'right',  
        search: "搜索: ",  
        labeldx: '选中的型号',  
        labelTop: '居顶',  
        labelBottom: '居底',  
        labelUp: '上',  
        labelDown: '下',  
        labelSort: '排序',
        leftSel_after_remove: function(leftSel,rightSel){  
            // lft->rgt: 重新计算选中的颜色列表  
            var selected = [];  
            rightSel.find('option').each(function(){  
                selected[selected.length] = jQuery(this).val();  
            });  
            if (vo.selected_cg[dataInput.cg_id]){  
                vo.selected_cg[dataInput.cg_id].color_ids = selected;  
            }  
        },  
          
        rightSel_after_remove: function(leftSel,rightSel){  
            // rgt->lft: 重新计算选中的颜色列表以及默认颜色是否还存在  
            leftSel.find('option.default_color').each(function(){  
                jQuery(this).removeClass('default_color');  
                if (jQuery(this).hasClass('delete_color')){  
                    jQuery(this).css({color: 'gray'});    
                }else {  
                    jQuery(this).css({color: ''});  
                }  
            });  
            var selected = [];  
            rightSel.find('option').each(function(){  
                selected[selected.length] = jQuery(this).val();  
            });  
            if (vo.selected_cg[dataInput.cg_id]){  
                vo.selected_cg[dataInput.cg_id].color_ids = selected;  
            }  
              
            var default_color_id = vo.selected_cg[dataInput.cg_id].default_color_id;  
            if (default_color_id){  
                var finded = false;  
                for (var i=0; i < selected.length; i++){  
                    if (selected[i] == default_color_id){  
                        finded = true;  
                        break;  
                    }  
                }  
                if (!finded) vo.selected_cg[dataInput.cg_id].default_color_id = null;  
            }  
        },  
          
        rightSel_after_move: function(rightSel){  
            // 移动后重新计算选中的颜色列表  
            var selected = [];  
            rightSel.find('option').each(function(){  
                selected[selected.length] = jQuery(this).val();  
            });  
            if (vo.selected_cg[dataInput.cg_id]){  
                vo.selected_cg[dataInput.cg_id].color_ids = selected;  
            }  
//          console.log(selected);  
        },  
          
        // 自定义命令按钮  
        customCommand: [  
            {  
                cmdclass: 'SetDefaultColor',title: '设置色族的默认颜色',label: '默认色',  
                style: {  
                    color: 'pink','background-color': 'gray'  
                },  
                eventMt: function(rightSel){  
                    var selectedDx = rightSel.find("option:selected");  
                    if (selectedDx.size() != 1){  
                        return alertMsg.error("每次只能操作一种颜色");  
                    }  
                    rightSel.find('option.default_color').each(function(){  
                        jQuery(this).removeClass('default_color');  
                        if (jQuery(this).hasClass('delete_color')){  
                            jQuery(this).css({color: 'gray'});    
                        }else {  
                            jQuery(this).css({color: ''});  
                        }  
                    });  
                    selectedDx.addClass('default_color').css({color: 'pink'});  
                      
//                  console.log(selectedDx.get(0));  
                    vo.setDefaultColorId(dataInput.cg_id,selectedDx.val());  
                }  
            }  
        ]  
          
    }); 
	$('.SelSort').css("display","none");  
	
	$("#btnGenJson").click(function(){
		$("#jsonDiv").html("");
		var brandId = $("#brand").val();
		var typeIds = []; 
		$('#searchablems2side__dx option').each(function() { 
			typeIds.push( $(this).attr('value') );
		});
		$.ajax({
			data:JSON.stringify({brandId:brandId,typeIds:typeIds}),
			dataType:'JSON',
			type:'POST',
			url:'genJson',
			contentType:"application/json",
			success:function(data){
				$("#jsonDiv").html(JSON.stringify(data));
			},
			error:function(){
				
			}
		});
	});
});
</script>
</head>
<body>
	<form id="genJsonfrom">
		<fieldset>
			<legend>车辆品牌</legend>
			<select id="brand">
				<option value="" selected="selected">--请选择--</option>
				<c:forEach items="${brandList}" var="item">
					<option value="${item.brandId}">${item.brandName}</option>
				</c:forEach>
			</select>
		</fieldset>
		<fieldset>
			<legend>车辆品牌型号</legend>
			<select multiple="multiple" name="searchable[]" style="width: 250px;"
				id="searchable">
			</select>
		</fieldset>
		<div>
		<input id="btnGenJson" type="button" value="生成json"/>
		
		</div>
		<fieldset>
		<legend>生成的json字符串</legend>
		   <div id="jsonDiv"></div>
		</fieldset>
	</form>
</body>
</html>
