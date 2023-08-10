package com.app.rickandmorthy.tool;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.JsonNode;

import com.app.rickandmorthy.model.Character;


public class MapperTools {
	
	private static ObjectMapper getObjectMapper() {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    	objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
    	objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    	return objectMapper;
		
	}
	
	public static List<Character> jsonArrayToListObject(JSONObject resBody, String bodyParam) {
		
		ObjectMapper objectMapper = getObjectMapper();
		
		List<Character> listObject = null;
		
		try {
			listObject = objectMapper.readValue(resBody.getJSONArray(bodyParam).toString(), new TypeReference<List<Character>>(){});
		} catch (JsonProcessingException | JSONException e) {
			e.printStackTrace();
		}
		
		return listObject;
		
	}
	
	public static Character jsonToObject(JsonNode jsonNode) {
		
		ObjectMapper objectMapper = getObjectMapper();
		
		Character object = null;
		
		try {
		    object = objectMapper.readValue(jsonNode.toString(), new TypeReference<Character>(){});
		} catch (JsonProcessingException | JSONException e) {
			e.printStackTrace();
		}
		
		return object;
		
	}

}
