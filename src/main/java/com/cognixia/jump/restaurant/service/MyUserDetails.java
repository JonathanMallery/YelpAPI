package com.cognixia.jump.restaurant.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.restaurant.model.User;

@EnableWebSecurity
public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;
	
	private List<GrantedAuthority> authorities;

	public MyUserDetails(String userName) {
		this.userName = userName;
	}
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(User user){
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole().toString()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
