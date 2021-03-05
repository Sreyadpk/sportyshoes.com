package com.phase3.project.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {

	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Username is mandatory")
	private String username;
	@NotBlank(message = "password is mandatory")
	private String password;

	public Admin() {

	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
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

}
