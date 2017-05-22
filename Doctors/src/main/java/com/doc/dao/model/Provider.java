package com.doc.dao.model;

public class Provider {
	private int doctor_id;
	private String doctor_name;
	private String doctor_quali;
	private String username;
	private String password;
	
	public Provider() {

	}

	public Provider(int doctor_id, String doctor_name, String doctor_quali, String username, String password) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_quali = doctor_quali;
		this.username= username;
		this.password= password;	
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_quali() {
		return doctor_quali;
	}

	public void setDoctor_quali(String doctor_quali) {
		this.doctor_quali = doctor_quali;
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
