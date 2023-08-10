package com.app.rickandmorthy.service;

import java.util.List;
import com.app.rickandmorthy.model.Character;

public interface CharacterServiceExtAPI {	
	    
    public List<Character> findAllCharacters();
    public Character findCharacterById(String id);

}
