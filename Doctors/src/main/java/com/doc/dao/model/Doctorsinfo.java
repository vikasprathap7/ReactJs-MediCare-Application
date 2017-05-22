package com.doc.dao.model;

public class Doctorsinfo {
	private int id;
	private String name;
	private String patientname;
	private String username;
	private String password;
	private int noofpatients;
	private String speciality;

	public Doctorsinfo() {

	}

	public Doctorsinfo(int id, String name, String patientname, String username, String password, int noofpatients, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.patientname = patientname;
		this.username= username;
		this.password= password;
		this.speciality= speciality;
		this.noofpatients= noofpatients;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatientname() {
		return patientname;
	}

	public void Provider(String patientname) {
		this.patientname = patientname;
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
	public int getNoofpatients() {
		return noofpatients;
	}

	public void setNoofpatients(int noofpatients) {
		this.noofpatients = noofpatients;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	@Override
	public String toString() {
		return "Doctorsinfo [id=" + id + ", name=" + name + ",patientname=" + patientname + "  ]";
	}

}
