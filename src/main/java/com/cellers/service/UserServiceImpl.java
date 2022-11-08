package com.cellers.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cellers.model.Role;
import com.cellers.model.User;
import com.cellers.repository.UserRepository;
import com.cellers.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) throws Exception{
		User user;
		//If email has the correct email tag, flag them as an admin, else, they are a user
		if (registrationDto.getEmail().contains("@mtp.com")) {
			user = new User(
					registrationDto.getFirstName(), 
					registrationDto.getLastName(),
					registrationDto.getEmail(), 
					passwordEncoder.encode(registrationDto.getPassword()),
					Arrays.asList(new Role("ROLE_ADMIN")));
		} else {

			user = new User(
					registrationDto.getFirstName(), 
					registrationDto.getLastName(),
					registrationDto.getEmail(), 
					passwordEncoder.encode(registrationDto.getPassword()),
					Arrays.asList(new Role("ROLE_USER")));
		}
		
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new Exception("User already exist!");
		}

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
