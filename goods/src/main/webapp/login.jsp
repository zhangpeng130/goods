<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"  charset="utf-8">    
   <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
   <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
  <title>销管:老板专属登录页面</title>
   </head>
   <body style="width: auto; height: auto; " >
   <div style="width:100%;height:0px; "></div>
   <div style="margin-top:130px; padding-left:25% ;padding-top:50px; width:100%;height:300px;">
  <!-- <form class="form-horizontal" role="form" action="/goods/jsp/sale/saleInput.html"> -->
  <form class="form-horizontal"  method="post" action="j_spring_security_check">

  <!--  <form class="form-horizontal"  method="post"role="form" action="/goods/user/UserLogin.do">-->
   <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="userName"  name="j_username" placeholder="嗨!老板,请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" id="password"  name="j_password" placeholder="老板,输入下密码呗">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="reset" class="btn btn-default btn-lg">   重新填写</button>
      <button type="submit" class="btn btn-primary btn-lg">登      录</button>      
    </div>
  </div>
</form>
  
</div>
   </body>
</html>
