package com.wellsfargo.evaluation.eloan.model;

import java.time.LocalDate;

public class ApplicationInfo {
	
	private String userName;	
	private String userFirstName;
	private String userLastName;
	
	private String password;
	private String email;
	private int mobile;
	private String houseNo;
	private String city;
	private String state;
	private String country;
	private int zipcode;
	private LocalDate dob;
	private String panNumber;
		
	public ApplicationInfo() {
		
	}

	public ApplicationInfo(String userName, String userFirstName, String userLastName, String password, String email,
			int mobile, String houseNo, String city, String state, String country, int zipcode, LocalDate dob,
			String panNumber) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.houseNo = houseNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.dob = dob;
		this.panNumber = panNumber;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	
	
	

}
