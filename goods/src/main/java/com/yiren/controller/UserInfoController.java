package com.yiren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiren.entity.UserInfo;
import com.yiren.service.UserInfoService;
import com.yiren.utils.MD5Utils;


@Controller
@RequestMapping("/user")
public class UserInfoController {
@Autowired
private UserInfoService userInfoService;
@RequestMapping(value="/UserInput")
public String UserInput(){	
	UserInfo userInfo=new UserInfo();
	userInfo.setUserName("root");
	MD5Utils md5 = new MD5Utils(); 	
	userInfo.setPassword(md5.generatePassword("123"));
	userInfo.setPhone("13022188023");
	userInfoService.addUserInfo(userInfo);
	return null;		
	}
@RequestMapping(value="/UserLogin")
public String UserLogin(UserInfo userInfo){		
	boolean isLogin=false;
	String returnStr="";
	if(userInfo!=null){
		isLogin=userInfoService.login(userInfo.getUserName(), userInfo.getPassword());
	}
	if(isLogin){
		returnStr="sale/saleInput";		
	}else{
		returnStr="passwordError";
	}
	return returnStr;
	}

}
