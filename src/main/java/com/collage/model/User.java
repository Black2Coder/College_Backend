package com.collage.model;

public class User {
	
	
	private Integer userId;
	private String userName;
	private String emailId;
	private String contact;
	private String password;
	private boolean active;
	private String roles;

	public User() {
	}

	public User(Integer userId, String userName, String emailId, String contact, String password, boolean active, String roles) {
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.contact = contact;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", contact=" + contact
				+ ", password=" + password + "]";
	}

}
