package com.collage.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users implements UserDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String emailId;
	private String contact;
	private String password;
	private boolean active;
	private String roles;
	public Users() {
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


	public boolean isActive() {
		return active;
	}

	public Users(Integer userId, String userName, String emailId, String contact, String password, boolean active, String roles) {
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.contact = contact;
		this.password = password;
		this.active = active;
		this.roles = roles;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<Authority> set = new HashSet<>();

		return null;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", contact=" + contact
				+ ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contact, emailId, password, userId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(contact, other.contact) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}
	
	
	
}
