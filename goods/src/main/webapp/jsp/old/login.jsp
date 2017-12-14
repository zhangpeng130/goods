<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超级系统登录入口</title>
<jsp:include page="meta.jsp"></jsp:include>
</head>
<script type="text/javascript">

// submit the form    
$(function(){    
    $('#btn').bind('click', function(){    
    	$('#ff').form('submit',{    	
    	    url:'<%=request.getContextPath()%>/home/loginmapping', 
    	    type:"POST",  
    	    dataType:"JSON", 
    	    
    	    success:function(data){    
    	        alert(data)    
    	    }    
    	});    
$('#ff').submit();
    });    
    
    

});  



</script>
<body background="<%=request.getContextPath() %>/images/main2.jpg" >
<div style="padding-left: 500px;padding-top: 250px">
<form id="ff" method="post">   
    <input class="easyui-textbox" data-options="iconCls:'icon-man'" style="width:300px;height:30px;" id="loginname" name="loginname"> 
     <br/><br/><input class="easyui-textbox" data-options="iconCls:'icon-lock'" style="width:300px;height:30px;" id="password" name="password"> 
   <br/>
   <br/>
   <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">即将进入超级系统</a>  
      
   <a id="btns" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">刷新一下更精彩</a>  
    
</form> 
</div>
</body>
</html>