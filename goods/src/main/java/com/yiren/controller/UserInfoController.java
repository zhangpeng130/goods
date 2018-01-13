package com.yiren.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yiren.entity.UserInfo;
import com.yiren.service.UserInfoService;
import com.yiren.utils.EncoderStrUtil;

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
		userInfo.setUserName("zk");
		// MD5Utils md5 = new MD5Utils();
		userInfo.setPassword(EncoderStrUtil.encodedPassword("9860"));
		userInfo.setPhone("13022188023");
		userInfoService.addUserInfo(userInfo);
		logger.info("添加用户已结束");
		return null;
	}

	@RequestMapping(value = "/UserLogin")
	public String UserLogin(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		logger.info("正在登录：" + userName + ":" + password);
		boolean isLogin = false;
		String returnStr = "";
		if (!StringUtils.isEmpty(userName) || !StringUtils.isEmpty(password)) {
			isLogin = userInfoService.login(userName, password);
		}
		if (isLogin) {
			returnStr = "sale/findSaleRecord";
		} else {
			returnStr = "passwordError";
		}
		return returnStr;
	}
}
