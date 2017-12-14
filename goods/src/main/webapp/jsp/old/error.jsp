<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
</head><script type="text/javascript">

/*


var flag = true;
$(function(){			
	var $container = $('#listing');    
	$container.masonry({
		singleMode: true,
		animate: true,
		itemSelector: '.box'
	});		
	//滚动条滚动到离底部距离50的时候触发
	$(window).scroll(function(){
		// 当滚动到最底部以上100像素时， 加载新内容
		if ($(document).height() - $(this).scrollTop() - $(this).height()<50){	
			if (flag){
				alert(2);
				var $boxes = $(getList());	 
				$container.append($boxes).masonry('appended',$boxes);
			}
		}
	});	
});	
//测试获取列表
function getList() {	
	var boxes = [],count = parseInt(Math.random()*10); 
	var req="<%=request.getContextPath() %>";
	alert(req);for (var i=0; i < 10; i++ ) {
		boxes.push('<div class="post"><a href="#"><img src="+<%=request.getContextPath() %>+/upload/image_'+(i+1)+'.jpg" width="280" alt="" /></a><a href="#" target="_blank">图片'+(i+1)+'</a></div>');
	}
	
	//把数组转成字符串
	return boxes.join("");
};

*/

</script>
<body>
<div style=" padding-left: 50px; padding-top:50px;">这个是错误页面! </div>
</body>
</html>