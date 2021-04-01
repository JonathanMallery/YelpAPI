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

import com.cognixia.jump.restaurant.model.Restaurant;
import com.cognixia.jump.restaurant.repository.RestaurantRepository;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantController {

	@Autowired
	RestaurantRepository repo;
	
	//CREATE
	//POST Restaurant
	@CrossOrigin
	@PostMapping("add/restaurant")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		repo.save(restaurant);
		return restaurant;
	}	
	
	//RETREIVE
	//GET all Restaurants
	@CrossOrigin
	@GetMapping("restaurants")
	public List<Restaurant> getAllRestaurants(){
		return repo.findAll();
	}
	
	//GET Restaurant by id
	@CrossOrigin
	@GetMapping("restaurants/{id}")
	public Restaurant getRestaurant(@PathVariable long id) {
		Optional<Restaurant> optRestaurant = repo.findById(id);
		
		if(optRestaurant.isPresent()) {
			return optRestaurant.get();
		}
		
		return new Restaurant();
	}
	
	//GET Restaurant by name
	@CrossOrigin
	@GetMapping("restaurants/name/{name}")
	public List<Restaurant> getRestaurantByName(@PathVariable String name){
		return repo.findByName(name);
	}
	
	//GET Restaurant by address
	@CrossOrigin
	@GetMapping("restaurants/address/{address}")
	public List<Restaurant> getRestaurantByAddress(@PathVariable String address){
		return repo.findByAddress(address);
	}
	
	//GET Restaurant by description
	@CrossOrigin
	@GetMapping("restaurants/description/{description}")
	public List<Restaurant> getRestaurantByDescription(@PathVariable String description){
		return repo.findByDescription(description);
	}
	
	
	//UPDATE
	//PUT Restaurant
	@CrossOrigin
	@PutMapping("update/restaurant/{id}")
	public String updateRestaurant(@RequestBody Restaurant restaurant) {
		Optional<Restaurant> found = repo.findById(restaurant.getId());
		
		if(found.isPresent()) {
			repo.save(restaurant);
			return "Saved: " + restaurant.toString();
		} else {
			return "Could not update restaurant with id = " + restaurant.getId();
		}
	}
	
	//PATCH Restaurant name
	@CrossOrigin
	@PatchMapping("update/restaurant/name")
	public String updateName(@RequestBody Map<String , String> nameUpdate){
		
		long id = Long.parseLong(nameUpdate.get("id"));
		String name = nameUpdate.get("name");
		
		Optional<Restaurant> found = repo.findById(id);
		
		if(found.isPresent()) {
			Restaurant toUpdate = found.get();
			toUpdate.setName(name);
			repo.save(toUpdate);
			return name;
		} else {
			return "Could not find restaurant with id = " + id;
		}
		
	}
	
	//PATCH Restaurant address
	@CrossOrigin
	@PatchMapping("update/restaurant/address")
	public String updateAddress(@RequestBody Map<String , String> addressUpdate){
			
		long id = Long.parseLong(addressUpdate.get("id"));
		String address = addressUpdate.get("address");
			
		Optional<Restaurant> found = repo.findById(id);
			
		if(found.isPresent()) {
			Restaurant toUpdate = found.get();
			toUpdate.setAddress(address);
			repo.save(toUpdate);
			return address;
		} else {
			return "Could not find restaurant with id = " + id;
		}
			
	}
		
	//PATCH Restaurant address
	@CrossOrigin
	@PatchMapping("update/restaurant/description")
	public String updateDescription(@RequestBody Map<String , String> descriptionUpdate){
			
		long id = Long.parseLong(descriptionUpdate.get("id"));
		String description = descriptionUpdate.get("description");
			
		Optional<Restaurant> found = repo.findById(id);
			
		if(found.isPresent()) {
			Restaurant toUpdate = found.get();
			toUpdate.setAddress(description);
			repo.save(toUpdate);
			return description;
		} else {
			return "Could not find restaurant with id = " + id;
		}
			
	}
	
	//DELETE Restaurant
	@CrossOrigin
	@DeleteMapping("delete/restaurant/{id}")
	public long deleteRestaurant (@PathVariable long id) {
		repo.deleteById(id);
		return id;
	}
}
