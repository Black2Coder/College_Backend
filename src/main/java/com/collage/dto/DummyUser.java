package com.collage.dto;

public class DummyUser {
		
	private Integer userId;
	private String userName;
	private String emailId;
	private String contact;
	private String password;
	
	
	
	public DummyUser(Integer userId, String userName, String emailId, String contact, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.contact = contact;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
