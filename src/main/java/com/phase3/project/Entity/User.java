package com.phase3.project.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@Email
	@NotBlank(message = "email is mandatory")
	private String email;
	
	@NotNull(message = "Mobile is mandatory")
	private long mobile;
	
	@NotBlank(message = "Address is mandatory")
	private String address;

	public User() {

	}


	public User(String username, String password, String email, long mobile, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
