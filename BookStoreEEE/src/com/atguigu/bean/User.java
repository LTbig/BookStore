package com.atguigu.bean;

import java.io.Serializable;
/*
 * 对应数据库中的bs_user类
 * 
 * */
//Serializable 这个是实现数据的序列化的 以便后面登录时session的活化和钝化
public class User implements Serializable {
	//id
	private Integer id;
	//用户名
	private String username;
	//密码
	private String password;
	//邮箱
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(Integer id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}
	

}
