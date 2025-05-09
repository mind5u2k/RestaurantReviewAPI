package com.project.demo.retaurantMgmt.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.demo.retaurantMgmt.model.Restaurant;
import com.project.demo.retaurantMgmt.service.RestaurantService;

@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestaurantService restaurantService;

	@Test
	void testFetRestaurantById_Success() throws Exception {
		Restaurant mockRestaurant = new Restaurant(1, "restaurantName1", "Thai", "Noida", "LOW");
		when(restaurantService.getRestaurantById(1)).thenReturn(mockRestaurant);

		mockMvc.perform(get("/api/restaurants/getById/{restaurantId}")).andExpect(status().isOk())
				.andExpect(jsonPath("$.restaurantName").value("restaurantName1"));
	}
}
