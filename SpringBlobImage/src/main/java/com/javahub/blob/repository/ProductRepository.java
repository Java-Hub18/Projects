package com.javahub.blob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javahub.blob.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
