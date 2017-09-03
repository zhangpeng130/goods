package com.yiren.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.yiren.dao.MyUsersDao;
import com.yiren.entity.MyUsers;
import com.yiren.service.MyUserService;
//import com.yiren.utils.Log;

@SuppressWarnings("unused")
@Service("myUserService")
public class MyUserServiceimpl  implements MyUserService{
@Resource
private MyUsersDao myUsersDao;

	public MyUsersDao getMyUsersDao() {
	return myUsersDao;
}

public void setMyUsersDao(MyUsersDao myUsersDao) {
	this.myUsersDao = myUsersDao;
}

	public void insertMyUsers(MyUsers myUser) {
		myUsersDao.insertMyUsers(myUser);		
		
		
	}

	public List<MyUsers> queryMyUsers() {
		
		return myUsersDao.queryMyUsers();
	}

	@Override
	public MyUsers queryMyUsersByname(MyUsers myUsers) {
	
		return myUsersDao.queryMyUsersByname(myUsers);
	}

}
