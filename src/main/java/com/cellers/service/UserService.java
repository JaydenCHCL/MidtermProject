package com.cellers.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cellers.model.User;
import com.cellers.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto userRegistrationDto);
	
}
