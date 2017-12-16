package com.yiren.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.yiren.entity.UserInfo;
import com.yiren.service.UserInfoService;
import com.yiren.utils.MD5Utils;

@Controller
@RequestMapping("/user")
public class UserInfoController {
	private static final Logger logger = Logger.getLogger(SaleController.class);
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = "/UserInput")
	public String UserInput() {
		logger.info("正在添加用户");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("root");
		MD5Utils md5 = new MD5Utils();
		userInfo.setPassword(md5.generatePassword("123"));
		userInfo.setPhone("13022188023");
		userInfoService.addUserInfo(userInfo);
		logger.info("添加用户已结束");
		return null;
	}

	@RequestMapping(value = "/UserLogin")
	public String UserLogin(UserInfo userInfo) {
		logger.info("正在登录：" + JSON.toJSONString(userInfo));
		boolean isLogin = false;
		String returnStr = "";
		if (userInfo != null) {
			isLogin = userInfoService.login(userInfo.getUserName(),
					userInfo.getPassword());
		}
		if (isLogin) {
			returnStr = "sale/findSaleRecord";
		} else {
			returnStr = "passwordError";
		}
		return returnStr;
	}

}
