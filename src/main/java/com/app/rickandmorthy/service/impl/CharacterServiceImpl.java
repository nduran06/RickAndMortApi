package com.app.rickandmorthy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rickandmorthy.Exception.RickAndMortyException;
import com.app.rickandmorthy.model.Character;
import com.app.rickandmorthy.repository.CharacterRepository;
import com.app.rickandmorthy.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	private CharacterRepository charRepo;
	
	@Override
	public List<Character> findAllCharacters() {
		
		return this.charRepo.findAll();
	}
	
	@Override
	public List<Character> findAllCharactersOrderById() {

		return this.charRepo.findAllByOrderByIdAsc();
	}

	@Override
	public List<Character> findAllCharactersOrderByName() {
		
		return this.charRepo.findAllByOrderByNameAsc();
	}

	@Override
	public List<Character> findAllCharactersOrderByImage() {

		return this.charRepo.findAllByOrderByImageAsc();
	}

	@Override
	public List<Character> findAllCharactersOrderByGender() {

		return this.charRepo.findAllByOrderByGenderAsc();
	}

	@Override
	public List<Character> findAllCharactersOrderByStatus() {
		
		return this.charRepo.findAllByOrderByStatusAsc();
	}
	
	@Override
	public Character findCharacterById(String id) {
		
		return !this.charRepo.findById(id).isEmpty() ? (Character) this.charRepo.findById(id).get() : null;
	}
	
	@Override
	public Character findCharacterByName(String name) {
		
		Optional<Character> character = this.charRepo.findByName(name);
		
		return !character.isEmpty() ? character.get() : null;
	}

	@Override
	public List<Character> findCharactersByImage(String image) {
		
		return this.charRepo.findByImage(image);
	}

	@Override
	public List<Character> findCharactersByGender(String gender) {
		
		return this.charRepo.findByGender(gender);
	}

	@Override
	public List<Character> findCharactersByStatus(String status) {
		
		return this.charRepo.findByStatus(status);
	}

	@Override
	public Character addCharacter(Character newChar) throws RickAndMortyException {
		
		Character character = null;
		
		if(newChar.getName().equals("Rick and Morty")) {
			throw new RickAndMortyException("This character cannot be saved");
		}
		
		else { 			

			if(!charRepo.findById(newChar.getId()).isEmpty() || !charRepo.findByName(newChar.getName()).isEmpty()) {
				throw new RickAndMortyException("Invalid data");
			}
			
			else {
				character = this.charRepo.save(newChar);
			}
		}
		
		return character;
	}
	
}
