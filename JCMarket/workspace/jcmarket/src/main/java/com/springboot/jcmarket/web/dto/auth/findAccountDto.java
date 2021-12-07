package com.springboot.jcmarket.web.dto.auth;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.jcmarket.domain.user.User;

import lombok.Data;

@Data
public class findAccountDto {

	private String user_name;
	private String user_phone;
	private String user_password;
	
	 public User toEntity() {
	     return User.builder()
					.user_name(user_name)
					.user_phone(user_phone)
					.user_password(new BCryptPasswordEncoder().encode(user_password))
					.build();
		}
}


