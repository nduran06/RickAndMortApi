package com.app.rickandmorthy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.rickandmorthy.service.APICallService;
import com.app.rickandmorthy.service.CharacterService;
import com.app.rickandmorthy.service.CharacterServiceExtAPI;
import com.app.rickandmorthy.tool.GeneralTools;
import com.app.rickandmorthy.tool.MapperUtil;
import com.app.rickandmorthy.model.APICall;
import com.app.rickandmorthy.model.Character;


@Controller
@RequestMapping("/characters")
public class CharacterController {
	
	@Autowired
    private CharacterServiceExtAPI characterServiceExtAPI;
	
	@Autowired
    private CharacterService characterService;
	
	@Autowired
    private APICallService apiCallService;

	/***************************** External API *****************************************/
    @GetMapping(value = "/api/findAll", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllExternalCharacters() {
    	
		APICall apiCall = new APICall("/findAll", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterServiceExtAPI.findAllCharacters();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    
    @GetMapping(value = "/api/findById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getExternalCharacterById(@PathVariable("id") String id) {
    	
		APICall apiCall = new APICall("/findById/" + id, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			Character character = characterServiceExtAPI.findCharacterById(id);
			apiCall.setInfoRes(character != null ? character.toString() : null);

			return new ResponseEntity<>(character, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }
    
	/************************************************************************************/

    @GetMapping(value = "/my/findAll", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharacters() {
    	
		APICall apiCall = new APICall("/my/findAll", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharacters();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    @GetMapping(value = "/my/findAllById", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharactersById() {
    	
		APICall apiCall = new APICall("/my/findAllById", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharactersOrderById();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    @GetMapping(value = "/my/findAllByName", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharactersByName() {
    	
		APICall apiCall = new APICall("/my/findAllByName", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharactersOrderByName();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    @GetMapping(value = "/my/findAllByImage", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharactersByImage() {
    	
		APICall apiCall = new APICall("/my/findAllByImage", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharactersOrderByImage();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    @GetMapping(value = "/my/findAllByGender", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharactersByGender() {
    	
		APICall apiCall = new APICall("/my/findAllByGender", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharactersOrderByGender();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    @GetMapping(value = "/my/findAllByStatus", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInternalCharactersByStatus() {
    	
		APICall apiCall = new APICall("/my/findAllByStatus", null, GeneralTools.getDate(), false, "GET");

        try {
			List<Character> characters = characterService.findAllCharactersOrderByStatus();
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        
        catch (Exception e) {

        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		}
    }
    
    
    @GetMapping(value = "/my/findById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInternalCharacterById(@PathVariable("id") String id) {
    	
		APICall apiCall = new APICall("/findById/" + id, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			Character character = characterService.findCharacterById(id);
			apiCall.setInfoRes(character != null ? character.toString() : null);

			return new ResponseEntity<>(character, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }
    
    @GetMapping(value = "/my/findByName/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInternalCharacterByName(@PathVariable("name") String name) {
    	
		APICall apiCall = new APICall("/findByName/" + name, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			Character character = characterService.findCharacterByName(name);
			apiCall.setInfoRes(character != null ? character.toString() : null);

			return new ResponseEntity<>(character, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }
    
    @GetMapping(value = "/my/findByImage/{image}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInternalCharacterByImage(@PathVariable("image") String image) {
    	
		APICall apiCall = new APICall("/findByImage/" + image, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			List<Character> characters = characterService.findCharactersByImage(image);
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }
    
    @GetMapping(value = "/my/findByGender/{gender}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInternalCharacterByGender(@PathVariable("gender") String gender) {
    	
		APICall apiCall = new APICall("/findByGender/" + gender, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			List<Character> characters = characterService.findCharactersByGender(gender);
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }
    
    @GetMapping(value = "/my/findByStatus/{status}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInternalCharacterByStatus(@PathVariable("status") String status) {
    	
		APICall apiCall = new APICall("/findByStatus/" + status, null, GeneralTools.getDate(), false, "GET");

        try {
        	
			List<Character> characters = characterService.findCharactersByStatus(status);
			apiCall.setInfoRes(characters != null ? characters.toString() : null);

			return new ResponseEntity<>(characters, HttpStatus.ACCEPTED);
		} 
        catch (Exception e) {
        	
        	apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);		
		} 
        
        finally {
			apiCallService.registerCall(apiCall);
		}
    }

	@PostMapping("/add")
	public ResponseEntity<?> addStreaming(@RequestBody Character newChar) {
		
		APICall apiCall = new APICall("/add/" + newChar.toString(), null, GeneralTools.getDate(), false, "POST");

		try {

			Character character = characterService.addCharacter(MapperUtil.map(newChar, Character.class));
			apiCall.setInfoRes(character != null ? character.toString() : null);
			
			return new ResponseEntity<Object>("Character added successfully", HttpStatus.OK);
		}

		catch (Exception e) {
			
			apiCall.setInfoRes(e.getMessage());
			apiCall.setError(true);
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		finally {
			apiCallService.registerCall(apiCall);
		}
	}

}
