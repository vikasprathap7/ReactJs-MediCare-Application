package com.doc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.persistence.internal.jaxb.DomHandlerConverter;

import com.doc.dao.model.*;

public class Access {
	public ArrayList<Provider> getDoctorsinfo(Connection con) throws SQLException {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM provider");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Provider doctorsinfoObj = new Provider();
				doctorsinfoObj.setDoctor_id((rs.getInt("doctor_id")));
				doctorsinfoObj.setDoctor_name((rs.getString("doctor_name")));
				doctorsinfoObj.setDoctor_quali((rs.getString("doctor_quali")));
				doctorsinfoObj.setUsername(rs.getString("username"));
				doctorsinfoObj.setPassword(rs.getString("password"));
				doctorsinfoList.add(doctorsinfoObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorsinfoList;

	}
	public ArrayList<Provider> getDoctorsInfoById(Connection con,Integer id) throws SQLException {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM provider where doctor_id=" +id);
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Provider doctorsinfoObj = new Provider();
				doctorsinfoObj.setDoctor_id((rs.getInt("doctor_id")));
				doctorsinfoObj.setDoctor_name((rs.getString("doctor_name")));
				doctorsinfoObj.setDoctor_quali((rs.getString("doctor_quali")));
				doctorsinfoObj.setUsername(rs.getString("username"));
				doctorsinfoObj.setPassword(rs.getString("password"));
				doctorsinfoList.add(doctorsinfoObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorsinfoList;

	}
	
	public ArrayList<Provider> getDoctorsInfoByName(Connection con, String username) throws SQLException {
		ArrayList<Provider> doctorsinfoList = new ArrayList<Provider>();		
		System.out.println("name is " +username);
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM provider where username =?");
		stmt.setString(1, username);
		ResultSet  rs= stmt.executeQuery();
		try {
			while (rs.next()) {
				Provider doctorsinfoObj = new Provider();
				doctorsinfoObj.setDoctor_id((rs.getInt("doctor_id")));
				doctorsinfoObj.setDoctor_name((rs.getString("doctor_name")));
				doctorsinfoObj.setDoctor_quali((rs.getString("doctor_quali")));
				doctorsinfoObj.setUsername(rs.getString("username"));
				doctorsinfoObj.setPassword(rs.getString("password"));
				doctorsinfoList.add(doctorsinfoObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorsinfoList;
	}

	public ArrayList<Treatment> getTreatment(Connection con) throws SQLException {
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM treatment");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Treatment treatmentObj = new Treatment();
				treatmentObj.setId(rs.getInt("id"));
				treatmentObj.setDoctor_id(rs.getInt("doctor_id"));
				treatmentObj.setPatient_id(rs.getInt("patient_id"));
				treatmentObj.setDiaginfo(rs.getString("diaginfo"));
				treatmentObj.setGrade(rs.getString("grade"));
				treatmentObj.setNoofappoiontment(rs.getString("noofappoiontment"));

				treatmentList.add(treatmentObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentList;

	}
	
	public ArrayList<Treatment> getTreatmentById(Connection con, Integer doctor_id) throws SQLException {
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM treatment where doctor_id =" +doctor_id);
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Treatment treatmentObj = new Treatment();
				treatmentObj.setId(rs.getInt("id"));
				treatmentObj.setDoctor_id(rs.getInt("doctor_id"));
				treatmentObj.setPatient_id(rs.getInt("patient_id"));
				treatmentObj.setDiaginfo(rs.getString("diaginfo"));
				treatmentObj.setGrade(rs.getString("grade"));
				treatmentObj.setNoofappoiontment(rs.getString("noofappoiontment"));
				

				treatmentList.add(treatmentObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentList;

	}
	public ArrayList<Object> getTreatmentByDocName(Connection con, String username) throws SQLException {
		ArrayList<Object> treatmentList = new ArrayList<Object>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM treatment t,provider p where t.doctor_id=p.doctor_id && p.username=?");
		stmt.setString(1,username);
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Treatment treatmentObj = new Treatment();
				treatmentObj.setId(rs.getInt("id"));
				treatmentObj.setDoctor_id(rs.getInt("doctor_id"));
				treatmentObj.setPatient_id(rs.getInt("patient_id"));
				treatmentObj.setDiaginfo(rs.getString("diaginfo"));
				treatmentObj.setGrade(rs.getString("grade"));
				treatmentObj.setNoofappoiontment(rs.getString("noofappoiontment"));
				Provider doctorsinfoObj = new Provider();
				doctorsinfoObj.setDoctor_id((rs.getInt("doctor_id")));
				doctorsinfoObj.setDoctor_name((rs.getString("doctor_name")));
				doctorsinfoObj.setDoctor_quali((rs.getString("doctor_quali")));
				doctorsinfoObj.setUsername(rs.getString("username"));
				doctorsinfoObj.setPassword(rs.getString("password"));
				
				treatmentList.add(doctorsinfoObj);
				treatmentList.add(treatmentObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentList;

	}
	
	
	public ArrayList<Provider> getProvider(Connection con) throws SQLException {
		ArrayList<Provider> providerList = new ArrayList<Provider>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM provider");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Provider providerObj = new Provider();
				providerObj.setDoctor_id(rs.getInt("doctor_id"));
				providerObj.setDoctor_name(rs.getString("doctor_name"));
				providerObj.setDoctor_quali(rs.getString("doctor_quali"));
				providerObj.setUsername(rs.getString("username"));
				providerObj.setPassword(rs.getString("password"));
				

				providerList.add(providerObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return providerList;

	}
	
	public ArrayList<Patient> getPatient(Connection con) throws SQLException {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM patient where patient_id");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Patient patientObj = new Patient();
				patientObj.setPatient_id(rs.getInt("patient_id"));
				patientObj.setAge(rs.getInt("age"));
				patientObj.setPatient_name(rs.getString("patient_name"));
				patientObj.setGender(rs.getString("gender"));
				patientObj.setMedication(rs.getString("Medication"));
				

				patientList.add(patientObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patientList;

	}
	
	
	
	
}