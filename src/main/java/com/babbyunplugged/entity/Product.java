package com.babbyunplugged.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column(name="PRODUCT_SEQ_NUMBER")
	private Long id ;
	
	@Column(length=50)
	private String product_code;
	
	@Column(length=255)
	private String product_description;
	
	@Column(length=50)
	private String line_of_business;
	
	@Column(length=35)
	private String business_unit;
	
	@Column(length=30)
	private String product_notes;
	private Boolean dispaly_flag;
	
	public Product() {}
	
	
	public Product(String product_code, String product_description, String line_of_business,
			String business_unit, String product_notes, Boolean dispaly_flag) {
		super();
		this.product_code = product_code;
		this.product_description = product_description;
		this.line_of_business = line_of_business;
		this.business_unit = business_unit;
		this.product_notes = product_notes;
		this.dispaly_flag = dispaly_flag;
	}


	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id ;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getLine_of_business() {
		return line_of_business;
	}
	public void setLine_of_business(String line_of_business) {
		this.line_of_business = line_of_business;
	}
	public String getBusiness_unit() {
		return business_unit;
	}
	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
	}
	public String getProduct_notes() {
		return product_notes;
	}
	public void setProduct_notes(String product_notes) {
		this.product_notes = product_notes;
	}
	public Boolean getDispaly_flag() {
		return dispaly_flag;
	}
	public void setDispaly_flag(Boolean dispaly_flag) {
		this.dispaly_flag = dispaly_flag;
	}
	@Override
	public String toString() {
		return "Product [PRODUCT_SEQ_NUMBER=" + id + ", product_code=" + product_code
				+ ", product_description=" + product_description + ", line_of_business=" + line_of_business
				+ ", business_unit=" + business_unit + ", product_notes=" + product_notes + ", dispaly_flag="
				+ dispaly_flag + "]";
	}
	
	
}
