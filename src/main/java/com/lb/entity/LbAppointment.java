package com.lb.entity;
import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/* 
* 
* gen by beetlsql 2020-03-25
*/
@Data
@Table(name="lb_appointment")
public class LbAppointment   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_doctor_id = "doctor_id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_expenses = "expenses";
	public static final String ALIAS_time = "time";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	医生id
	*/
	private Integer doctorId ;

	/*
	患者id
	*/
	private Integer patientId ;
	/*
	门诊费
	*/
	private BigDecimal expenses ;
	/*
	预约时间
	*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time ;

	/*
	就诊状态
	 */
	private String status;

	/*
	患者名称
	 */
	private String patientName;

	/*
	医生名称
	 */
	private String doctorName;

	/*
	部门名称
	 */
	private String department;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_doctor_id() {
		return ALIAS_doctor_id;
	}

	public static String getALIAS_patient_id() {
		return ALIAS_patient_id;
	}

	public static String getALIAS_expenses() {
		return ALIAS_expenses;
	}

	public static String getALIAS_time() {
		return ALIAS_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
