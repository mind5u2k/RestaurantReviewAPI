package com.project.demo.retaurantMgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.retaurantMgmt.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
	Optional<UserAccount> findByUsername(String username);
}
