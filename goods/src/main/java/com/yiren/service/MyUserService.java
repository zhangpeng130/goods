package com.yiren.service;

import java.util.List;

import com.yiren.entity.MyUsers;

public interface MyUserService {
	public void insertMyUsers(MyUsers myUser);
	public List<MyUsers> queryMyUsers();
	public MyUsers queryMyUsersByname(MyUsers myUsers);
}
