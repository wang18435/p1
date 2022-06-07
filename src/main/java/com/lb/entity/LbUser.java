package com.lb.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2020-03-25
*/
@Data
@Table(name="lb_user")
public class LbUser   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_role = "role";
	public static final String ALIAS_password = "password";
	public static final String ALIAS_username = "username";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	权限
	*/
	private Integer role ;
	/*
	密码
	*/
	private String password ;
	/*
	账号
	*/
	private String username ;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_role() {
		return ALIAS_role;
	}

	public static String getALIAS_password() {
		return ALIAS_password;
	}

	public static String getALIAS_username() {
		return ALIAS_username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
