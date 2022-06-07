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
@Table(name="lb_doctor")
public class LbDoctor   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_age = "age";
	public static final String ALIAS_expert = "expert";
	public static final String ALIAS_sex = "sex";
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_address = "address";
	public static final String ALIAS_cert_id = "cert_id";
	public static final String ALIAS_department = "department";
	public static final String ALIAS_name = "name";
	public static final String ALIAS_text = "text";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	年龄
	*/
	private Integer age ;
	private Integer expert ;
	/*
	性别
	*/
	private Integer sex ;
	/*
	登录
	*/
	private Integer userId ;
	/*
	家庭住址
	*/
	private String address ;
	/*
	身份证
	*/
	private String certId ;
	/*
	部门
	*/
	private String department ;
	/*
	姓名
	*/
	private String name ;
	/*
	介绍
	*/
	private String text ;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_age() {
		return ALIAS_age;
	}

	public static String getALIAS_expert() {
		return ALIAS_expert;
	}

	public static String getALIAS_sex() {
		return ALIAS_sex;
	}

	public static String getALIAS_user_id() {
		return ALIAS_user_id;
	}

	public static String getALIAS_address() {
		return ALIAS_address;
	}

	public static String getALIAS_cert_id() {
		return ALIAS_cert_id;
	}

	public static String getALIAS_department() {
		return ALIAS_department;
	}

	public static String getALIAS_name() {
		return ALIAS_name;
	}

	public static String getALIAS_text() {
		return ALIAS_text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getExpert() {
		return expert;
	}

	public void setExpert(Integer expert) {
		this.expert = expert;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
