package com.babbyunplugged.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	@GeneratedValue
	@Column(name="COUNTRY_SEQ_NUMBER")
	private Long id ;
	
	@Column(length=30)
	private String country_code;
	
	@Column(length=50)
	private String country_name;
	
	public Country() {}

	public Country(String country_code, String country_name) {
		super();
		this.country_code = country_code;
		this.country_name = country_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country_code=" + country_code + ", country_name=" + country_name + "]";
	}
	
}
