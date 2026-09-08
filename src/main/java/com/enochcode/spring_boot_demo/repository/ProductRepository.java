package com.enochcode.spring_boot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.enochcode.spring_boot_demo.entity.Product;



public interface ProductRepository extends JpaRepository<Product ,Long>,JpaSpecificationExecutor<Product>{

}
