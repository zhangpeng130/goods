<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function queryUser(){
	var ur='<%=request.getContextPath()%>';
		document.getElementById("a1ction").action ="/queryUsers.do";
	//	alert(document.getElementById("a1ction").action);
	    document.getElementById("a1ction").submit();
	
	}
</script>


<body onload="queryUser()" >
<form action="" method="post" id="a1ction" >
</form>
</body>
</html>