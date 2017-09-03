package com.yiren.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yiren.entity.MyUsers;

public interface MyUsersDao {
	@Insert("insert into MyUsers(loginname,password,email,phone,state)"
			+ " values(#{loginname},#{password},#{email},#{phone},#{state})")
	public int insertMyUsers(MyUsers myUser);
	@Select("select * from MyUsers")
	public List<MyUsers> queryMyUsers();
	
	@Select("select * from MyUsers where loginname=#{loginname}")
	public MyUsers queryMyUsersByname(MyUsers myUsers);

}
