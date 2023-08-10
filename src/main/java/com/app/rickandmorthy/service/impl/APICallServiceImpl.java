package com.app.rickandmorthy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rickandmorthy.model.APICall;
import com.app.rickandmorthy.repository.APICallRepository;
import com.app.rickandmorthy.service.APICallService;

@Service
public class APICallServiceImpl implements APICallService {

	@Autowired
	private APICallRepository apiCallRepo;
	    
    @Override 
    public void registerCall(APICall apiCall) {
    	
    	apiCallRepo.save(apiCall);

    }
    
}
