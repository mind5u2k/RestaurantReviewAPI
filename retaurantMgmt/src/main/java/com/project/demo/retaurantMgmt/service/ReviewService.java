package com.project.demo.retaurantMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.retaurantMgmt.model.Restaurant;
import com.project.demo.retaurantMgmt.model.Review;
import com.project.demo.retaurantMgmt.repository.RestaurantRepo;
import com.project.demo.retaurantMgmt.repository.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	ReviewRepo reviewRepo;

	@Autowired
	RestaurantRepo restaurantRepo;

	public void submitReviews(Review review) {
		reviewRepo.save(review);
	}

	public List<Review> getReviewsByRestaurantId(int restaurantId) {
		List<Review> restaurants = restaurantRepo.findById(restaurantId).get().getReviews();
		return restaurants;
	}

}
