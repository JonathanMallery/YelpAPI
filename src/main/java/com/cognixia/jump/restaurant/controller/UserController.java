package com.cognixia.jump.restaurant.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.restaurant.model.User;
import com.cognixia.jump.restaurant.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserRepository repo;
	
	//CREATE
	@CrossOrigin
	@PostMapping("add/user")
	public User createUser(@RequestBody User user) {
		repo.save(user);
		return user;
	}
	
	//RETREIVE
	@CrossOrigin
	@GetMapping("users")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("users/{id}")
	public User getUser(@PathVariable long id) {
		Optional<User> optUser = repo.findById(id);
		
		if(optUser.isPresent()) {
			return optUser.get();
		}
		
		return new User();
	}
	
	@CrossOrigin
	@GetMapping("users/firstname/{firstName}")
	public List<User> getUserByFirstName(@PathVariable String firstName){
		return repo.findByFirstName(firstName);
	}
	
	@CrossOrigin
	@GetMapping("users/lastname/{lastName}")
	public List<User> getUserByLastName(@PathVariable String lastName){
		return repo.findByLastName(lastName);
	}
	
	@CrossOrigin
	@GetMapping("users/email/{email}")
	public List<User> getUserByEmail(@PathVariable String email){
		return repo.findByEmail(email);
	}
	
	@CrossOrigin
	@PutMapping("update/user/{id}")
	public String updateUser(@RequestBody User user) {
		Optional<User> found = repo.findById(user.getId());
		
		if(found.isPresent()) {
			repo.save(user);
			return "Saved: = " + user.toString();
		} else {
			return "Could not update user with id = " + user.getId();
		}
	}
	
	//UPDATE
	@CrossOrigin
	@PatchMapping("update/user/firstname")
	public String updateFirstName(@RequestBody Map<String, String> firstNameUpdate) {
		
		long id = Long.parseLong(firstNameUpdate.get("id"));
		String firstName = firstNameUpdate.get("firstName");
		
		Optional<User> found = repo.findById(id);
		
		if(found.isPresent()) {
			User toUpdate = found.get();
			toUpdate.setFirstName(firstName);
			repo.save(toUpdate);
			return firstName;
		} else {
			return "Could not find user with id = " + id;
		}
	}
	
	@CrossOrigin
	@PatchMapping("update/user/lastname")
	public String updateLastName(@RequestBody Map<String, String> lastNameUpdate) {
		
		long id = Long.parseLong(lastNameUpdate.get("id"));
		String lastName = lastNameUpdate.get("lastName");
		
		Optional<User> found = repo.findById(id);
		
		if(found.isPresent()) {
			User toUpdate = found.get();
			toUpdate.setLastName(lastName);
			repo.save(toUpdate);
			return lastName;
		} else {
			return "Could not find user with id = " + id;
		}
	}
	
	@CrossOrigin
	@PatchMapping("update/user/email")
	public String updateEmail(@RequestBody Map<String, String> emailUpdate) {
		
		long id = Long.parseLong(emailUpdate.get("id"));
		String email = emailUpdate.get("email");
		
		Optional<User> found = repo.findById(id);
		
		if(found.isPresent()) {
			User toUpdate = found.get();
			toUpdate.setEmail(email);
			repo.save(toUpdate);
			return email;
		} else {
			return "Could not find user with id = " + id;
		}
	}
	
	//DELETE
	@CrossOrigin
	@DeleteMapping("delete/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id){
		Optional<User> found = repo.findById(id);
		
		if(found.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(200).body("Deleted user with id = " + id);
		} else {
			return ResponseEntity.status(404).body("Student with id = " + id + " not found.");
		}
	}
}
