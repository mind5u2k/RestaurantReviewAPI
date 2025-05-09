package com.project.demo.retaurantMgmt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.demo.retaurantMgmt.exceptionHandler.errorResponses.GenericErrorResponseException;
import com.project.demo.retaurantMgmt.model.Restaurant;
import com.project.demo.retaurantMgmt.model.Review;
import com.project.demo.retaurantMgmt.repository.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	public Page<Restaurant> getRestaurants(Pageable pageable) {
		Page<Restaurant> restaurants = restaurantRepo.findAll(pageable);
		return restaurants;
	}

	public Restaurant getRestaurantById(int restaurantId) {
		Optional<Restaurant> restaurantVal = restaurantRepo.findById(restaurantId);
		if (restaurantVal.isEmpty()) {
			throw new GenericErrorResponseException("Restaurant Not Found for ID : " + restaurantId);
		}
		return restaurantVal.get();
	}

	public void addRestaurant(Restaurant restaurant) {
		restaurantRepo.save(restaurant);
	}

	public void updateRestaurant(Restaurant restaurant) {
		restaurantRepo.save(restaurant);
	}

	public void deleteRestaurantById(int restaurantId) {
		restaurantRepo.deleteById(restaurantId);
	}

	public double calculateAvgRatingPerRestaurant(int restaurantId) {
		Restaurant restaurant = restaurantRepo.findById(restaurantId).orElse(new Restaurant());
		List<Review> reviews = restaurant.getReviews();
		double avgRating = reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
		return avgRating;
	}

	public List<Restaurant> getTop3RestaurantByCuisine(String cuisineType) {
		List<Restaurant> restaurant = restaurantRepo.findByCuisineType(cuisineType);
		List<Restaurant> top3restaurant = restaurant.stream().sorted((res1, res2) -> {
			double avgRev1 = res1.getReviews().stream().mapToDouble(Review::getRating).average().orElse(0.0);
			double avgRev2 = res1.getReviews().stream().mapToDouble(Review::getRating).average().orElse(0.0);
			return avgRev1 > avgRev2 ? 1 : avgRev1 < avgRev2 ? -1 : 0;
		}).limit(3).collect(Collectors.toList());
		return top3restaurant;
	}
}
