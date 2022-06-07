package com.lb.entity;
import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2020-03-25
*/
@Data
@Table(name="lb_patient")
public class LbPatient {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_age = "age";
	public static final String ALIAS_appointment_id = "appointment_id";
	public static final String ALIAS_hospitalization_id = "hospitalization_id";
	public static final String ALIAS_isout = "isout";
	public static final String ALIAS_sex = "sex";
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_address = "address";
	public static final String ALIAS_cert_id = "cert_id";
	public static final String ALIAS_drugsids = "drugsids";
	public static final String ALIAS_name = "name";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	年龄
	*/
	private Integer age ;
	/*
	预约信息
	*/
	private Integer appointmentId ;
	/*
	住院信息
	*/
	private Integer hospitalizationId ;
	/*
	是否出院
	*/
	private Integer isout ;
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
	药品信息
	*/
	private String drugsids ;
	/*
	姓名
	*/
	private String name ;

	//映射医生的名称
	private String doctorName ;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_age() {
		return ALIAS_age;
	}

	public static String getALIAS_appointment_id() {
		return ALIAS_appointment_id;
	}

	public static String getALIAS_hospitalization_id() {
		return ALIAS_hospitalization_id;
	}

	public static String getALIAS_isout() {
		return ALIAS_isout;
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

	public static String getALIAS_drugsids() {
		return ALIAS_drugsids;
	}

	public static String getALIAS_name() {
		return ALIAS_name;
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

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getHospitalizationId() {
		return hospitalizationId;
	}

	public void setHospitalizationId(Integer hospitalizationId) {
		this.hospitalizationId = hospitalizationId;
	}

	public Integer getIsout() {
		return isout;
	}

	public void setIsout(Integer isout) {
		this.isout = isout;
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

	public String getDrugsids() {
		return drugsids;
	}

	public void setDrugsids(String drugsids) {
		this.drugsids = drugsids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
