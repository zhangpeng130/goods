package com.yiren.dao;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yiren.entity.UserInfo;
/**
 *
 * @author peng
 *
 */
public interface UserInfoDao {
	@Insert(value="insert into TM_USER_INFO(USER_NAME,PASSWORD,NICK_NAME,PHONE,ROLE,STATUS)"
			+ "values(#{userName},#{password},#{nickName},#{phone},#{role},#{status})")
	public int insertUserInfo(UserInfo userInfo);

@Select("select * from TM_USER_INFO WHERE USER_NAME=#{userName}")
	public List<UserInfo>  findUserInfoByUserName(UserInfo userInfo);
}
