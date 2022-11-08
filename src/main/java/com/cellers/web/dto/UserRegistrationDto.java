package com.cellers.web.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserRegistrationDto() {

	}

	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public UserRegistrationDto(UserRegistrationDto usrDto) {
		super();
		this.email = usrDto.getEmail();
		this.firstName = usrDto.getFirstName();
		this.lastName = usrDto.getLastName();
		this.password = usrDto.getPassword();
	}

}
