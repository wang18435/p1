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
@Table(name="lb_seek")
public class LbSeek   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_days = "days";
	public static final String ALIAS_describes = "describes";
	public static final String ALIAS_drugs = "drugs";
	public static final String ALIAS_illname = "illname";
	public static final String ALIAS_options = "options";
	public static final String ALIAS_price = "price";
	
	private Integer id ;
	private Integer patientId ;
	private Integer appointmentId ;
	private Integer days ;
	private String describes ;
	private String drugs ;
	private String illname ;
	private String options ;
	private BigDecimal price ;

	private String patientName;
	private String doctorName;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_patient_id() {
		return ALIAS_patient_id;
	}

	public static String getALIAS_days() {
		return ALIAS_days;
	}

	public static String getALIAS_describes() {
		return ALIAS_describes;
	}

	public static String getALIAS_drugs() {
		return ALIAS_drugs;
	}

	public static String getALIAS_illname() {
		return ALIAS_illname;
	}

	public static String getALIAS_options() {
		return ALIAS_options;
	}

	public static String getALIAS_price() {
		return ALIAS_price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public String getDrugs() {
		return drugs;
	}

	public void setDrugs(String drugs) {
		this.drugs = drugs;
	}

	public String getIllname() {
		return illname;
	}

	public void setIllname(String illname) {
		this.illname = illname;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
}
