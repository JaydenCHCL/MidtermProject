package com.cellers.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cellers.model.Product;
import com.cellers.model.User;
import com.cellers.repository.UserRepository;
import com.cellers.service.UserService;
import com.cellers.web.dto.UserRegistrationDto;


@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRegistrationController {

	private UserService userService;
	
	//private UserRepository userRepository;
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/reg")
	public void registerUser(@RequestBody UserRegistrationDto registrationDto) {
		try {
			this.userService.save(new UserRegistrationDto(registrationDto));
		} catch (Exception e) {
			System.out.println("User already exists!");
		}
	}
}
