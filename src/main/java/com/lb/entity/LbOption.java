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
@Table(name="lb_option")
public class LbOption   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_name = "name";
	public static final String ALIAS_price = "price";
	public static final String ALIAS_type = "type";
	
	private Integer id ;
	private String name ;
	private BigDecimal price ;
	private String type ;

	public static String getALIAS_id() {
		return ALIAS_id;
	}

	public static String getALIAS_name() {
		return ALIAS_name;
	}

	public static String getALIAS_price() {
		return ALIAS_price;
	}

	public static String getALIAS_type() {
		return ALIAS_type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
