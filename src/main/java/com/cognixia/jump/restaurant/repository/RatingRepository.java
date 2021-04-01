package com.cognixia.jump.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.restaurant.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	Optional<Rating> findById(Long id);
	
	List<Rating> findByRating(int rating);
	
//	@Query("select rating.rating, rating.comment from velp.rating join velp.restaurant using (restaurant_id) where restaurant_id = ?")
//	Rating findRatingByRestaurantId(int id);
	
}
