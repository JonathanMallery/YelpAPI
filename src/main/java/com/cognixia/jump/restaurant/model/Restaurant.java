package com.cognixia.jump.restaurant.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Restaurant implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurant_id")
	private long id;
	
	private String name;
	private String address;
	private String description;
	
	@OneToMany(mappedBy = "ratingRestaurant", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Rating> restaurantRating;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Rating> getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(Set<Rating> restaurantRating) {
		this.restaurantRating = restaurantRating;
	}

	public Restaurant(long id, String name, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	public Restaurant(long id, String name, String address, String description, Set<Rating> restaurantRating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.restaurantRating = restaurantRating;
	}

	public Restaurant() {
		this(-1, "N/A", "N/A", "N/A");
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description
				+ "]";
	}
	
}
