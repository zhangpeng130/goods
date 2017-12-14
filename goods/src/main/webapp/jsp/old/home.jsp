<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老马哥,少看片,多写代码</title>

<link href="<%=request.getContextPath() %>/css/lanrenzhijia.css" type="text/css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/prefixfree.min.js"></script>

<style>
.container-fluid {
  padding: 0px 0px 0px 80px;
}
.imgbox {
  margin-bottom: 20px;
  float: left;
  width: 220px;
}
.imgbox img {
  max-width: 100%
}
</style>
<jsp:include page="meta.jsp"></jsp:include>
<link href="<%=request.getContextPath() %>/css/home-img-text-style.css"></link>
<script type="text/javascript">

$(document).ready(function(){
 $(".imgtext").hide();
 $(".imgbox").hover(function(){
  $(".imgtext",this).slideToggle(500);
 });
});
</script>

</head> 


<body >

<!--菜单 Start -->

<nav id="menu">
  <ul>
    <li class="rocket"><a href="">我</a></li>
    <li class="wine"><a href="">们</a></li>
    <li class="burger"><a href="">一</a></li>
    <li class="comment"><a href="">起</a></li>
    <li class="sport" ><a href="">奋</a></li>
    <li class="earth"><a href="">斗</a></li>
    <div class="current">
      <div class="top-arrow"></div>
      <div class="current-back"></div>
      <div class="bottom-arrow"></div>
    </div>
  </ul>
</nav>

<!-- 菜单 End -->
<div align="center"  class="menuOther">
<div id="masonry" class="container-fluid" >

 <ul>
 <li>
  <div class="imgbox"><img src="<%=request.getContextPath() %>/upload/image_1.jpg">
  <div class="text">
                <div class="imgtext"> 2012新品男T恤韩版短袖男士夏装男装翻领t恤POLO衫 货到付款 T93 </div>
    </div>
  </div>
  </li>
 </ul>
  <div class="imgbox"><img src="<%=request.getContextPath() %>/upload/image_2.jpg"></div>
    <c:forEach items="${ infoList}" var="info">
   <div class="imgbox"><img src="<%=request.getContextPath() %>/upload/${info.pictureurl}"></div>
    </c:forEach>
  
  
</div>  
</div>
<script type="text/javascript">
$(function(){
	
		 $('#masonry').masonry({
				itemSelector : '.imgbox',
				gutterWidth : 20,
				isAnimated: true,
			});
		
	
});

</script>

</body>


</html>