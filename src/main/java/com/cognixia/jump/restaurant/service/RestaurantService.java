package com.cognixia.jump.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.restaurant.model.Restaurant;
import com.cognixia.jump.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository repo;
	
	public List<Restaurant> getAllRestaurants(){
		return repo.findAll();
	}
	
	public Restaurant getRestaurantById(long id) {
		Optional<Restaurant> found = repo.findById(id);
		
		if(!found.isPresent()) {
			Thread.dumpStack();
		}
		return found.get();
	}
	
	public List<Restaurant> getCarsOfName(String name){
		return repo.findByName(name);
	}
	
	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurant.setId(-1);
		Restaurant saved = repo.save(restaurant);
		return saved;
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant) {
		if(repo.existsById(restaurant.getId())) {
			Thread.dumpStack();
		}
		
		Restaurant updated = repo.save(restaurant);
		
		return updated;
	}
	
	public Restaurant deleteRestaurant(long id) {
		Restaurant toDelete = getRestaurantById(id);
		
		repo.deleteById(id);
		
		return toDelete;
	}
}
