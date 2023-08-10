package com.app.rickandmorthy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.rickandmorthy.model.APICall;


public interface APICallRepository extends MongoRepository<APICall, String> {
	

}
