package com.yiren.entity;

import java.io.Serializable;
import java.sql.Date;
/**
 * 用户信息
 * @author peng
 *
 */
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;	
	public long getId() {
		return id;
	}
	public void setId(long id) {	
		this.id = id;
	}
	/**
	 * 用户名
	 */
private String userName;
/**
 *密码
 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 角色
	 */
	private String role;
	private String status;

	private Date loginTime;;
	private Date createTime;	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

	public Date getCreateTime() {	
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
		

}
