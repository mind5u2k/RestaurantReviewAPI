package com.project.demo.retaurantMgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.retaurantMgmt.model.Restaurant;
import com.project.demo.retaurantMgmt.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/getAll")
	public Page<Restaurant> getRestaurants(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "restaurantId") String sortBy) {
		logger.info("Fetching all restaurants !!");
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return restaurantService.getRestaurants(pageable);
	}

	@GetMapping("/getById/{restaurantId}")
	public Restaurant getRestaurantById(@PathVariable int restaurantId) {
		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		return restaurant;
	}

	@PostMapping("/add")
	public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		restaurantService.addRestaurant(restaurant);
	}

	@PutMapping("/update")
	public void updateRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.updateRestaurant(restaurant);
	}

	@GetMapping("/getRatingPerRestaurant/{restaurantId}")
	public double avgRatingPerRestaurant(@PathVariable int restaurantId) {
		return restaurantService.calculateAvgRatingPerRestaurant(restaurantId);
	}

	@GetMapping("/getTop3RestauranByCuisine/{cuisineType}")
	public List<Restaurant> top3RestaurantByCuisintType(@PathVariable String cuisineType) {
		return restaurantService.getTop3RestaurantByCuisine(cuisineType);
	}

}
