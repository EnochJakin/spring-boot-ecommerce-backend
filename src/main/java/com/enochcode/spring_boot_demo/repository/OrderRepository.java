package com.enochcode.spring_boot_demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enochcode.spring_boot_demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
Optional<Order>findByReferanceId(String referanceId);
}
