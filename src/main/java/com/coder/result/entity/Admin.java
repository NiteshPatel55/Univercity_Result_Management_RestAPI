package com.coder.result.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admin {

	
	@Id
	private String adminId;
	
	@NotNull(message = "Email is requered")
	private String adminEmail;
	
	@NotNull(message = "Mobilenumber is Required")
	private String adminMobile;
	
	@NotNull(message = "Password is required")
	private String adminPassword;

	
	
	public Admin() {
		super();
	}



	public Admin(String adminId, @NotNull(message = "Email is requered") String adminEmail,
			@NotNull(message = "Mobilenumber is Required") String adminMobile,
			@NotNull(message = "Password is required") String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminMobile = adminMobile;
		this.adminPassword = adminPassword;
	}



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



	public String getAdminEmail() {
		return adminEmail;
	}



	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}



	public String getAdminMobile() {
		return adminMobile;
	}



	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}



	public String getAdminPassword() {
		return adminPassword;
	}



	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminMobile=" + adminMobile
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	
}
