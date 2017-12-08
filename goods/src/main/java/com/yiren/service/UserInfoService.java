package com.yiren.service;

import java.util.List;

import com.yiren.entity.UserInfo;
/**
 * 
 * @author peng
 *
 */
public interface UserInfoService {
	public int addUserInfo(UserInfo userInfo);
    public List<UserInfo>  findUserInfoByUserName(UserInfo userInfo);
    public boolean login(String userName,String password);
}
