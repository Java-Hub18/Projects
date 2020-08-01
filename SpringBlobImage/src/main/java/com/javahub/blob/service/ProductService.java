package com.javahub.blob.service;

import java.util.List;
import java.util.Optional;

import com.javahub.blob.entity.Product;

public interface ProductService {
	void saveProduct(Product product);
	List<Product> getAllActiveProducts();
	Optional<Product> getProductById(Long id);
}
