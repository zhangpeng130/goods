package com.yiren.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yiren.dao.UserInfoDao;
import com.yiren.entity.UserInfo;
import com.yiren.service.UserInfoService;
import com.yiren.utils.MD5Utils;
@Service
public class UserInfoServiceimpl implements UserInfoService{
@Resource
	private UserInfoDao userInfoDao;

@Override
public int addUserInfo(UserInfo userInfo) {
	int count=userInfoDao.insertUserInfo(userInfo);
	return count;
}

@Override
public List<UserInfo> findUserInfoByUserName(UserInfo userInfo) {
	List<UserInfo> userInfoList= userInfoDao.findUserInfoByUserName(userInfo);
	return userInfoList;
}

@Override
public boolean login(String userName, String password) {	
	UserInfo userInfo =new UserInfo();
	userInfo.setUserName(userName);
	List<UserInfo> userInfoList=findUserInfoByUserName( userInfo);
	if(userInfoList!=null&&userInfoList.size()>0){
		UserInfo userInfoFind=userInfoList.get(0);
		String passwordFind=userInfoFind.getPassword();
		 MD5Utils md5 = new MD5Utils();  
		 boolean result=md5.validatePassword(passwordFind, password);
		 return result;
	}
	return false;
}


	

}
