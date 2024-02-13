package com.youcode.reviews_jwt.repository;

import com.youcode.reviews_jwt.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewsRepository extends JpaRepository<Reviews, UUID> {

}
