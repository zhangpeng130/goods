<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>operation</title>
</head>
<jsp:include page="meta.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#name").textbox({	
		iconCls:'icon-man',
		iconAlign:'left'
	});
	$("#idname").validatebox({
		required:true,
		missingMessage:'商品名称为必填项!'
		   

	});
	$("#idprice").numberbox({
		min:0,
		precision:2

	});
	
$("#idstyleid").combobox({
	url:'<%=request.getContextPath()%>/home/selectStyle',
	textField:'text',
	valueField:'id'
});
$("#idpictureurl").filebox({
	buttonText:'选择文件',
	buttonAlign:'left'
});
$("#idupload").bind("click",function(){

	$("#uploadform").form("submit",{
		url:'<%=request.getContextPath()%>/home/fileUp',
		type:'POST',
		success:function(data){
			alert(data);
			$("#idhiddenurl").val(data);
		}
	});
});
$("#buttonsubmit").bind("click",function(){


	$("#operationForm").form("submit",{
		url:'<%=request.getContextPath()%>/home/submitData',
		type:'POST'
		
	});
  });
});
	


</script>
<body><center>
<div style=" padding-left: 50px; padding-top:50px;">登录到后台操作页面 </div><br>
<div>
<form id="operationForm">
商品名称:&nbsp&nbsp<input id="idname" type=" text" name="name"><br><br>
商品描述:&nbsp&nbsp<textarea id="iddescription"  name="description"></textarea><br><br>
商品价格:&nbsp&nbsp<input id="idprice" type="text" name="price"><br><br>
商品类型:&nbsp&nbsp<input id="idstyleid" name="styleid"><br><br>
<input id="idhiddenurl" name="pictureurl" value="" type="text">
<input id="buttonsubmit" value="提交" type="button">
</form>
	
<form id="uploadform" method="post"  enctype="multipart/form-data">
上传图片:&nbsp&nbsp<input id="idpictureurl" name="pictureurl" type="text"><input type="button" id="idupload" name="idupload" value="点击上传">
 </form>
</div></center>
</body>

</html>