package com.cognixia.jump.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.restaurant.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Optional<Restaurant> findById(Long id);
	
	List<Restaurant> findByName(String name);
	
	List<Restaurant> findByAddress(String address);
	
	List<Restaurant> findByDescription(String description);
}
