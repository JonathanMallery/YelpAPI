package com.cognixia.jump.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_id")
	private long id;
	
	@Range(min = 1, max = 5)
	private int rating;
	
	private String comment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User ratingUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "restaurant_id")
	private Restaurant ratingRestaurant;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Rating() {
		this(-1, 0, "No Comment");
	}
	
	public User getRatingUser() {
		return ratingUser;
	}

	public void setRatingUser(User ratingUser) {
		this.ratingUser = ratingUser;
	}
	

	public Restaurant getRatingRestaurant() {
		return ratingRestaurant;
	}

	public void setRatingRestaurant(Restaurant ratingRestaurant) {
		this.ratingRestaurant = ratingRestaurant;
	}

	public Rating(long id, @Size(min = 1, max = 5) int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}

	public Rating(long id, @Size(min = 1, max = 5) int rating, String comment, User ratingUser,
			Restaurant ratingRestaurant) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.ratingUser = ratingUser;
		this.ratingRestaurant = ratingRestaurant;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", comment=" + comment + "]";
	}

}
