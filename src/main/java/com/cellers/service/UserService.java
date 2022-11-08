package com.cellers.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cellers.model.User;
import com.cellers.web.dto.UserRegistrationDto;


public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto userRegistrationDto) throws Exception;
	
}
