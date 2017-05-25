<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>吉他查询</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.mobile.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyloader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
//全局变量
var builder=null;
var model=null;
var type=null;
var backWood=null;
var topWood=null;
$(function() {
	$('#dg').datagrid({       
		pageNumber: 1,
	    url: "${pageContext.request.contextPath}/searchGuitar",
	    rownumbers:true,
	    fitColumns:true,
	    singleSelect:true,
	    height:650,
	    toolbar:[{
					iconCls : 'icon-add',
					text : '增加',
					id:'addtool',
					handler : function() {
							$('#addbtn').show();
							$('#editbtn').hide();
							$('#win').window('open');
						}
					},{
						iconCls : 'icon-remove',
						text : '删除',
						id:'deletetool',
						handler : function() {
								var row = $('#dg').datagrid('getSelected');
								if (row) {
									$.messager.confirm('选择是否删除','您确定要删除该吉他吗?',function(fn) {
										if(fn==true){
											$.post('${pageContext.request.contextPath}/deleteGuitar',{serialNumber:row.serialNumber},function(message){
												$.messager.alert('提示',message); 
												$('#dg').datagrid('reload');
											});
										}
									});
								} 
								else {
									$.messager.alert('提示','请先选择要删除的行');
								}
						}
					},
		 			{
						text:'制作者:<input id="builderInput" name="builderhidden">'	
			 		},	
					{
						text:'类型：<input id="typeInput" name="typehidden">'
					},
					{
						text:'背部材料：<input id="backWoodInput" name="backWoodhidden">'
					},
					{
						text:'顶部材料：<input id="topWoodInput" name="topWoodhidden">'
					}
	 			],
	    columns:[[  
	              {field:'serialNumber',title:'吉他编号',width:100} ,
	              {field:'price',title:'吉他价格',width:100}, 
	              {field:'builder',title:'制作者',width:100},
	              {field:'model',title:'吉他模型',width:100},
	              {field:'type',title:'吉他类型',width:100},
	              {field:'backWood',title:'背部材料',width:100},
	              {field:'topWood',title:'顶部材料',width:100}
	    ]]
	});
	//查询下拉框设置
    $('#builderInput').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	builder=$('#builderInput').combobox('getValue');
        	query();
		}
    });
    $('#typeInput').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	type=$('#typeInput').combobox('getValue');
        	query();
		}
    });
    $('#backWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	backWood=$('#backWoodInput').combobox('getValue');
        	query();
		}
    });
    $('#topWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	topWood=$('#topWoodInput').combobox('getValue');
        	query();
		}
    });
    //增加下拉框设置

    $('#builderName').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#typeName').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#backWoodName').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#topWoodName').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#addbtn').bind('click', function(){    
		$('#form').form('submit', {
			url:"${pageContext.request.contextPath}/addGuitar",
			success: function(message){
				$.messager.alert('提示',message); 
				$('#dg').datagrid('reload');
				$('#win').window('close');
				$('#form').form('reset');
			}
		});
    });

})

	//查询函数
	function query(){
		$('#dg').datagrid('options').url='${pageContext.request.contextPath}/searchGuitar';
		$('#dg').datagrid('load',{
			builder:builder,
			type:type,
			backWood:backWood,
			model:"model1",
			topWood:topWood
		});
	}
</script>
</head>
<body>
	<input id="builderhidden" type="hidden">
	<input id="typehidden" type="hidden">
	<input id="backWoodhidden" type="hidden">
	<input id="topWoodhidden" type="hidden">
	<table id="dg"></table>
	
	<div id="win" class="easyui-window" title="填写事故信息" closed="true" style="width: 750px; height: 300px; padding: 5px;">
		<br />
		<form id="form" method="post">
			<div style="margin-left: 10px;">
				<div id="dlg-buttons" style="text-align:center">					
					 <label style="padding-right: 25px">吉他编号：</label>
					 <input name="serialNumber" style="height:20px" class="easyui-textbox">
					 <label style="padding-right: 25px">吉他价格：</label>
					 <input name="price" style="height:20px" class="easyui-textbox">
					 
					 <br/><br/>
					 <label style="padding-right: 25px">吉他厂商：</label>
					 <input id="builderName" name="builder" style="height:20px" class="easyui-textbox">
					 <label style="padding-right: 25px">吉他模型：</label>
					 <input id="modelName" name="model" style="height:20px" class="easyui-textbox">
					 
					 <br/><br/>
					 <label style="padding-right: 25px">吉他类型：</label>
					 <input id="typeName" name="type" style="height:20px" class="easyui-textbox">
					 <label style="padding-right: 25px">背部材料：</label>
					 <input id="backWoodName" name="backWood" style="height:20px" class="easyui-textbox">
					 <br/><br/>
					 <label style="padding-right: 25px">顶部材料：</label>
					 <input id="topWoodName" name="topWood" style="height:20px;padding-right:10px"  class="easyui-textbox"> 
					 
					 <a id="addbtn" class="easyui-linkbutton" iconCls="icon-ok" >确认添加</a>
			</div>
			</div>
		</form>
	</div>
</body>
</html>