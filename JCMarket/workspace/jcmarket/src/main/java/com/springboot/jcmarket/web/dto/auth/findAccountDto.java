package com.springboot.jcmarket.web.dto.auth;


import com.springboot.jcmarket.domain.user.User;

import lombok.Data;

@Data
public class findAccountDto {

	private String user_name;
	private String user_phone;
	
	
	 public User toEntity() {
	     return User.builder()
					.user_name(user_name)
					.user_phone(user_phone)
					.build();
		}
}


