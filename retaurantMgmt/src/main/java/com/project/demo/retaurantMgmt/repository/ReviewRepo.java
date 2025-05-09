package com.project.demo.retaurantMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.retaurantMgmt.model.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
