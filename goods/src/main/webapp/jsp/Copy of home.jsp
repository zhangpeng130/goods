<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页 </title>
</head><script type="text/javascript" src="<%=request.getContextPath() %>>/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>>/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>>/js/jquery-1.8.0.min.js"></script><style>
.container-fluid {
  padding: 20px;
}
.box {
  margin-bottom: 20px;
  float: left;
  width: 220px;
}
.box img {
  max-width: 100%
}
</style>
<script type="text/javascript">
$(function(){
	/*
	 * 

 	$('#tiles li').wookmark(
	{
		  autoResize: true,         // 当浏览器大小改变时会自动更新布局   
		        container: $('#tiles'),   // 可选配置项, 用于一些额外的CSS样式   
		        offset: 2,                // 可选配置项, 表格项(item)的间距   
		         itemWidth: 210           
	}		
	); 	
*/	
	///////
	

	
	
	alert(1);
	
	
	var $container = $('#masonry');
	alert($container);
		$container.imagesLoaded( function(){
			alert(2);
			$container.masonry({
				itemSelector : '.box',
				gutterWidth : 20,
				isAnimated: true,
			});
	
	});
	////////////////////
		
		
				
});
 

</script>
<body>

<!-- 
<ul id="tiles">  
   <li><img src="<%=request.getContextPath() %>/upload/main.jpg" width="200" height="283"><p>1</p></li>  
    <li><img src="<%=request.getContextPath() %>/upload/main2.jpg" width="200" height="283"><p>2</p></li>  
     <li><img src="<%=request.getContextPath() %>/upload/main.jpg" width="200" height="283"><p>3</p></li>  
      <li><img src="<%=request.getContextPath() %>/upload/main2.jpg" width="200" height="283"><p>4</p></li>  
</ul>  
 -->

<div id="masonry" class="container-fluid">
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_1.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_2.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_3.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_4.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_5.jpg"></div>
  
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_1.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_2.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_3.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_4.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_5.jpg"></div>
  
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_1.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_2.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/image_3.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main2.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main2.jpg"></div>
  
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main.jpg"></div>
  <div class="box"><img src="<%=request.getContextPath() %>/upload/main2.jpg"></div>
  
</body>
</html>