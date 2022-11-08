package com.cellers.web;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cellers.model.Product;
import com.cellers.model.User;
import com.cellers.repository.ProductRepository;
import com.cellers.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("products")
	public Iterable<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	@GetMapping("products/{id}")
	public Optional<Product> getProductbyId(@PathVariable Long id) {
		return this.productRepository.findById(id);
	}

	@DeleteMapping("products/delete/{id}")
	public void deleteProductbyId(@PathVariable Long id) {
		this.productRepository.deleteById(id);
	}

	@PostMapping("products/add/{product}")
	public void addProduct(@RequestBody Product product) {
		this.productRepository.save(new Product(product));
	}
	
	@PutMapping("products/update/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable Long id) {
		product.setId(id);
		this.productRepository.save(product);
	}
	
	@GetMapping("users")
	public Iterable<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	@GetMapping("users/{id}")
	public Optional<User> getUserbyId(@PathVariable Long id) {
		return this.userRepository.findById(id);
	}
}
