<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<jsp:include page="meta.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#one").attr("style","background-color:green");
		});
function cks(id){
	
	$(".each").each(function(){
		if(this.id==id){			
			$("#"+this.id).attr("style","background-color:green");
		}else{
			$("#"+this.id).attr("style","background-color:red");
		}		
	});
	
	
	
}

</script>
<style>
.each{width: 50px;height:50px; background-color:red;margin-top: 10px;}
</style>
<body>
<center>
<div class="each"  id="one" onclick="cks(this.id)"></div>
<div class="each"  id="two" onclick="cks(this.id)"></div>
<div class="each"  id="three" onclick="cks(this.id)"></div>
<div class="each"  id="four" onclick="cks(this.id)"></div>
<div class="each"  id="five" onclick="cks(this.id)"></div>

</center>


 </div>
</body>
</html>