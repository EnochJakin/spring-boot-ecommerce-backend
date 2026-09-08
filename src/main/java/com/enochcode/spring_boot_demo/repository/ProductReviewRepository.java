package com.enochcode.spring_boot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enochcode.spring_boot_demo.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Long> {

}
