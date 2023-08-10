package com.app.rickandmorthy.service;

import java.util.List;

import com.app.rickandmorthy.Exception.RickAndMortyException;
import com.app.rickandmorthy.model.Character;


public interface CharacterService {	
	    
	public List<Character> findAllCharacters();
	public List<Character> findAllCharactersOrderById();
	public List<Character> findAllCharactersOrderByName();
	public List<Character> findAllCharactersOrderByImage();
	public List<Character> findAllCharactersOrderByGender();
	public List<Character> findAllCharactersOrderByStatus();
	public Character findCharacterById(String id);
    public Character findCharacterByName(String name);
    public List<Character> findCharactersByImage(String image);
    public List<Character> findCharactersByGender(String gender);
    public List<Character> findCharactersByStatus(String status);
    public Character addCharacter(Character newChar) throws RickAndMortyException;

}
