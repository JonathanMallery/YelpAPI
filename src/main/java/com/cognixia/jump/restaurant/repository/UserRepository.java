package com.cognixia.jump.restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.restaurant.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findById(Long id);
	
	List<User> findByFirstName(String firstName);
	
	List<User> findByLastName(String lastName);
	
	List<User> findByEmail(String email);
	
	Optional<User> findByUserName(String userName);
	
}
