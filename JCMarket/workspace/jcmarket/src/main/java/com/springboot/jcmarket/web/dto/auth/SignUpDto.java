package com.springboot.jcmarket.web.dto.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.jcmarket.domain.user.User;

public class SignUpDto {
	 private String user_id;
	    private String user_password;
	    private String user_name;
	    private String user_phone;
	    private String user_nickname;
	    
	 public User toEntity() {
	     return User.builder()
					.user_id(user_id)
					.user_password(new BCryptPasswordEncoder().encode(user_password))
					.user_name(user_name)
					.user_phone(user_phone) 
					.user_nickname(user_nickname)
					.build(); 
	}

}
