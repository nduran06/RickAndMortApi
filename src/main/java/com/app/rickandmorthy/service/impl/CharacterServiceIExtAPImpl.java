package com.app.rickandmorthy.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.app.rickandmorthy.service.CharacterServiceExtAPI;
import com.app.rickandmorthy.tool.MapperTools;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.app.rickandmorthy.model.Character;

@Service
public class CharacterServiceIExtAPImpl implements CharacterServiceExtAPI {

	private final String REQUEST_URL = "https://rickandmortyapi.com/api";
	private final String charset = "UTF-8";
	    
    @Override 
    public List<Character> findAllCharacters() {
    	
		/*------------------------------ External API consume ----------------------------------*/
		
		HttpResponse<String> response=null;
		
	    try {
			response = Unirest.get(this.REQUEST_URL + "/character/").header("accept", "application/json").asString();
		} 
	    
	    catch (UnirestException e) {
			e.printStackTrace();
		}
	    
	    /*---------------------------------------------------------------------------------------*/
        
	    JSONObject resBody = new JSONObject(response.getBody());
		List<Character> characters = MapperTools.jsonArrayToListObject(resBody, "results");

        return characters;

    }
    
    @Override
	public Character findCharacterById(String id) {    

		/*------------------------------ External API consume ----------------------------------*/
		
    	HttpResponse<JsonNode> response=null;
		
    	String query=null;
		try {
			query = URLEncoder.encode(id, charset);	
		} 
		
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	    try {
			response = Unirest.get(this.REQUEST_URL + "/character/" + query).header("accept", "application/json").asJson();
		} 
	    
	    catch (UnirestException e) {
			e.printStackTrace();
		}
	    
	    /*---------------------------------------------------------------------------------------*/
        
	    Character character = MapperTools.jsonToObject(response.getBody());

        return character;

    }
}
