package com.project.demo.retaurantMgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.retaurantMgmt.model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	public List<Restaurant> findByCuisineType(String cuisineType);

}
