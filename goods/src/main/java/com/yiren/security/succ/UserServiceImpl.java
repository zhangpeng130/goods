package com.yiren.security.succ;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yiren.entity.UserInfo;
import com.yiren.service.UserInfoService;

public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserInfoService userInfoService;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		DaoAuthenticationProvider DaoAuthenticationProvider = new DaoAuthenticationProvider();

		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
		SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");
		UserInfo userInfo = userInfoService.loadUserInfoByUsername(userName);
		if (userName.equals("zk")) {
			auths = new ArrayList<GrantedAuthority>();
			auths.add(auth1);
			auths.add(auth2);
		}

		User user = new User(userName, userInfo.getPassword(), true, true,
				true, true, auths);
		return user;
	}
}
