package com.app.rickandmorthy.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "APICall")
public class APICall {
	
	@Id
    private String id;
	private String infoReq;
	private String infoRes;
	private Date date;
	private boolean error;
	private String type;
	
	public APICall(String infoReq, String infoRes, Date date, boolean error, String type) {
		
		this.infoReq = infoReq;
		this.infoRes = infoRes;
		this.date = date;
		this.error = error;
		this.type = type;
		
	}
	
	public APICall() {
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getInfoReq() {
		return this.infoReq;
	}
	
	public void setInfoReq(String infoReq) {
		this.infoReq = infoReq;
	}
	
	public String getInfoRes() {
		return this.infoRes;
	}
	
	public void setInfoRes(String infoRes) {
		this.infoRes = infoRes;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean getError() {
		return this.error;
	}
	
	public void setError(boolean error) {
		this.error = error;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}

