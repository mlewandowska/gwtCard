package com.gwt.card.shared;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String name;
	String lastName;
	String street;
	String city;
	String code;
	String prof;
	String tel;
	String www;
	String email;
	String photo;
	
	public Data(){}
	
	public Data(String name, String lastName, String street, String city,
			String code, String prof, String tel, String www, String email,
			String photo) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.code = code;
		this.prof = prof;
		this.tel = tel;
		this.www = www;
		this.email = email;
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWww() {
		return www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
