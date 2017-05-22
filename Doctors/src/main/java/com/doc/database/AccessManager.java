package com.doc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.doc.database.Access;
import com.doc.database.Database;
import com.doc.dao.model.Doctorsinfo;
import com.doc.dao.model.Patient;
import com.doc.dao.model.Provider;
import com.doc.dao.model.Treatment;

public class AccessManager {
	public ArrayList<Provider> getDoctorsinfo() throws Exception {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		doctorsinfoList = access.getDoctorsinfo(con);
		return doctorsinfoList;
	}
	public ArrayList<Provider> getDoctorsInfoById(Integer id) throws Exception {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		doctorsinfoList = access.getDoctorsInfoById(con,id);
		return doctorsinfoList;
	}
	
	public ArrayList<Provider> getDoctorsInfoByName(String username) throws Exception {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		doctorsinfoList = access.getDoctorsInfoByName(con,username);
		return doctorsinfoList;
	}
	public ArrayList<Patient> getPatient() throws Exception {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		patientList = access.getPatient(con);
		return patientList;
	}
	public ArrayList<Provider> getProvider() throws Exception {
		ArrayList<Provider> providerList = new ArrayList<Provider>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		providerList = access.getProvider(con);
		return providerList;
	}
	
	public ArrayList<Treatment> getTreatment() throws Exception {
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		treatmentList = access.getTreatment(con);
		return treatmentList;
	}
	public ArrayList<Treatment> getTreatmentById(Integer doctor_id) throws Exception{
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		treatmentList = access.getTreatmentById(con, doctor_id);
		return treatmentList;
		
	}
	public ArrayList<Object> getTreatmentByDocName(String username) throws Exception{
		ArrayList<Object> treatmentList = new ArrayList<Object>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		treatmentList = access.getTreatmentByDocName(con, username);
		return treatmentList;
		
	}
	
}