package com.app.rickandmorthy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "Character")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

	@Id
    private String id;
	@Indexed
	private String name;
	@Indexed
	private String image;
	@Indexed
	private String gender;
	@Indexed
	private String status;
	
    public Character(String id, String name, String image, String gender, String status) {
		
		this.id=id;
		this.image=image;
		this.name=name;
		this.gender=gender;
		this.status=status;
	}
    
	public Character() {
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return this.image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Character{" + "id=" + this.id + ", name='" + this.name + '\'' + ", image='" + this.image + '\'' + ", gender='" + this.gender + '\'' + ", status='" + this.status + '\'' + '}';
	}
}
