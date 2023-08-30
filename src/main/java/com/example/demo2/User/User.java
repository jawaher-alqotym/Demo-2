package com.example.demo2.User;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Size;


public class User {
	
	@JsonIgnore
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String fname;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	private String lname;
	
	public User(Integer id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	
	


}
