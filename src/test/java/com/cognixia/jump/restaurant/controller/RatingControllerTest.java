package com.cognixia.jump.restaurant.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
//@AutoConfigureMockMvc
public class RatingControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void apiGet() throws Exception{
		this.mockMvc.perform(get("/ratings")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void apiAdd() throws Exception{
		this.mockMvc.perform(post("/add/rating")).andDo(print()).andExpect(status().is4xxClientError());
	}
}
