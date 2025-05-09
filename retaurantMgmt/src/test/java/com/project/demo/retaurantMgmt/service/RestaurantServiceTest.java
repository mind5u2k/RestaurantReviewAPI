package com.project.demo.retaurantMgmt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.demo.retaurantMgmt.exceptionHandler.errorResponses.GenericErrorResponseException;
import com.project.demo.retaurantMgmt.model.Restaurant;
import com.project.demo.retaurantMgmt.repository.RestaurantRepo;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

	@Mock
	private RestaurantRepo restaurantRepo;

	@InjectMocks
	private RestaurantService restaurantService;

	@Test
	void testGetRestaurantById() {

		Restaurant mockRestaurant = new Restaurant(1, "restaurantName1", "Thai", "Noida", "LOW");
		when(restaurantRepo.findById(1)).thenReturn(Optional.of(mockRestaurant));

		Restaurant restaurant = restaurantService.getRestaurantById(1);

		assertNotNull(restaurant);
		assertEquals("restaurantName1", restaurant.getRestaurantName());
	}

	@Test
	void testGetRestaurantById_NotFound() {
		when(restaurantRepo.findById(2)).thenReturn(Optional.empty());
		assertThrows(GenericErrorResponseException.class, () -> restaurantService.getRestaurantById(2));
	}
}
