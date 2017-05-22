package com.doc.app.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;
import com.doc.dao.model.Doctorsinfo;
import com.doc.dao.model.Patient;
import com.doc.dao.model.Provider;
import com.doc.dao.model.Treatment;
import com.doc.database.AccessManager;



@Path("/doctorsinfoService")
public class DoctorsinfoService {
	@GET
	@Path("/doctorsinfo")
	@Produces(MediaType.APPLICATION_JSON)
	public String doctorinfo() {
		String doctorinfo = null;
		ArrayList<Provider> doctorinfoList = new ArrayList<Provider>();
		try {
			doctorinfoList = new AccessManager().getDoctorsinfo();
			Gson gson = new Gson();
			doctorinfo = gson.toJson(doctorinfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorinfo;
	}
	@GET
	@Path("/doctorsinfo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String doctorinfo1(@PathParam("id") Integer id) {
		String doctorinfo = null;
		ArrayList<Provider> doctorinfoList = new ArrayList<Provider>();
		try {
			System.out.println("id is " +id);
			doctorinfoList = new AccessManager().getDoctorsInfoById(id);
			Gson gson = new Gson();
			doctorinfo = gson.toJson(doctorinfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorinfo;
	}
	@GET
	@Path("/doctorsinfo/name/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String doctorinfo2(@PathParam("username") String username) {
		String doctorinfo = null;
		ArrayList<Provider> doctorinfoList = new ArrayList<Provider>();
		try {
			System.out.println("name is " + username);
			doctorinfoList = new AccessManager().getDoctorsInfoByName(username);
			Gson gson = new Gson();
			doctorinfo = gson.toJson(doctorinfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorinfo;
	}
	@GET
	@Path("/treatment")
	@Produces(MediaType.APPLICATION_JSON)
	public String treatment() {
		String treatment = null;
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		try {
			treatmentList = new AccessManager().getTreatment();
			Gson gson = new Gson();
			treatment = gson.toJson(treatmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatment;
	}
	@GET
	@Path("/treatment/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String treatment1(@PathParam("doctor_id") Integer doctor_id) {
		String treatment = null;
		ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
		try {
			System.out.println("id is new " + doctor_id);
			treatmentList = new AccessManager().getTreatmentById(doctor_id);
			Gson gson = new Gson();
			treatment = gson.toJson(treatmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatment;
	}
	@GET
	@Path("/treatment/treat/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public String treatmentByDocName(@PathParam("username") String username) {
		String treatment = null;
		ArrayList<Object> treatmentList = new ArrayList<Object>();
		try {
			System.out.println("id is new " + username);
			treatmentList = new AccessManager().getTreatmentByDocName(username);
			Gson gson = new Gson();
			treatment = gson.toJson(treatmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatment;
	}
	@GET
	@Path("/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public String patient() {
		String treatment = null;
		ArrayList<Patient> treatmentList = new ArrayList<Patient>();
		try {
			treatmentList = new AccessManager().getPatient();
			Gson gson = new Gson();
			treatment = gson.toJson(treatmentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatment;
	}
	
	
}