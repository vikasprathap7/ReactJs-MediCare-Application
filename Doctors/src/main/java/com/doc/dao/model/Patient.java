package com.doc.dao.model;

public class Patient {
	private int patient_id;
	private int age;
	private String patient_name;
	private String gender;
	private String medication;

	public Patient() {

	}
	

	public Patient(int patient_id, int age, String patient_name, String gender, String medication) {
		super();
		this.patient_id = patient_id;
		this.age = age;
		this.patient_name = patient_name;
		this.gender = gender;
		this.medication = medication;
	}


	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	

}
