package com.cognixia.jump.restaurant.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.restaurant.model.Rating;
import com.cognixia.jump.restaurant.repository.RatingRepository;

@RestController
@CrossOrigin(origins = "*")
public class RatingController {

	@Autowired
	RatingRepository repo;
	
	//CREATE
	//POST Rating
	@CrossOrigin
	@PostMapping("add/rating")
	public Rating createRating(@RequestBody Rating rating) {
		repo.save(rating);
		return rating;
	}
	
	//RETREIVE
	//GET all Ratings
	@CrossOrigin
	@GetMapping("ratings")
	public List<Rating> getAllRatings(){
		return repo.findAll();
	}
	
	//GET Rating by id
	@CrossOrigin
	@GetMapping("ratings/{id}")
	public Rating getRating(@PathVariable long id) {
		Optional<Rating> optRating = repo.findById(id);
		
		if(optRating.isPresent()) {
			return optRating.get();
		}
		
		return new Rating();
	}
	
	//GET Rating by number of stars
	@CrossOrigin
	@GetMapping("ratings/rating/{rating}")
	public List<Rating> getRatingByRating(@PathVariable int rating){
		return repo.findByRating(rating);
	}
	
	
	//UPDATE
	//PUT Rating
	@CrossOrigin
	@PutMapping("update/rating/{id}")
	public String updateRating(@RequestBody Rating rating) {
		Optional<Rating> found = repo.findById(rating.getId());
			
		if(found.isPresent()) {
			repo.save(rating);
			return "Saved: " + rating.toString();
		} else {
			return "Could not update restaurant with id = " + rating.getId();
		}
	}
	
	//PATCH Restaurant name
	//Allows a user to update a rating that they made
	@CrossOrigin
	@PatchMapping("update/rating/rating")
	public int updateRating(@RequestBody Map<String , Integer> ratingUpdate){
			
		long id = ratingUpdate.get("id");
		int rating = ratingUpdate.get("rating");
		
		Optional<Rating> found = repo.findById(id);
			
		if(found.isPresent()) {
			Rating toUpdate = found.get();
			toUpdate.setRating(rating);
			repo.save(toUpdate);
			return rating;
		} else {
			return (int) id;
		}
			
	}
	
	//DELETE Rating
	@CrossOrigin
	@DeleteMapping("delete/rating/{id}")
	public long deleteRating (@PathVariable long id) {
		repo.deleteById(id);
		return id;
	}
}
