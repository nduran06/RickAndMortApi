package com.app.rickandmorthy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.rickandmorthy.model.Character;


public interface CharacterRepository extends MongoRepository<Character, String> {
	
	public List<Character> findAll();
	public Optional<Character> findByName(String name);
	public List<Character> findByImage(String image);
	public List<Character> findByGender(String gender);
	public List<Character> findByStatus(String status);
	public List<Character> findAllByOrderByIdAsc();
	public List<Character> findAllByOrderByNameAsc();
	public List<Character> findAllByOrderByImageAsc();
	public List<Character> findAllByOrderByGenderAsc();
	public List<Character> findAllByOrderByStatusAsc();

}
