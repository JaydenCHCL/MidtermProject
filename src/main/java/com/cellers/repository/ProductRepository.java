package com.cellers.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cellers.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findByName(String name);

}
