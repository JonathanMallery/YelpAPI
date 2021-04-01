package com.cognixia.jump.restaurant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognixia.jump.restaurant.model.User;
import com.cognixia.jump.restaurant.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = repo.findByUserName(userName);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("username: " + userName + " does not exist");
		}
		return new MyUserDetails(user.get());
	}
}
