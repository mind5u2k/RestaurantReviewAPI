package com.project.demo.retaurantMgmt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.retaurantMgmt.model.Review;
import com.project.demo.retaurantMgmt.service.RestaurantService;
import com.project.demo.retaurantMgmt.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/add")
	public void add() {
		Review review = new Review();
		review.setComment("ac");
		review.setRating(1);
		review.setRestaurant(restaurantService.getRestaurantById(1));
		review.setStatus("a");
		review.setVisitDate(new Date());
		reviewService.submitReviews(review);
	}

	@PostMapping("/submit")
	public void submitReviews(@RequestBody Review review) {
		reviewService.submitReviews(review);
	}

	@GetMapping("/retrieve/{restaurantId}")
	public List<Review> retrieveReviews(@PathVariable int restaurantId) {
		return reviewService.getReviewsByRestaurantId(restaurantId);
	}
}
