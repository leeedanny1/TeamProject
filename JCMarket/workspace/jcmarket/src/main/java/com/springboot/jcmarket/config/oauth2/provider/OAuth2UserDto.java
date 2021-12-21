package com.springboot.jcmarket.config.oauth2.provider;

import com.springboot.jcmarket.domain.user.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OAuth2UserDto {
	private int id;
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_phone;
	private String user_nickname;
	private String role;
	private String provider;

	public User toEntity() {
		return User.builder().id(id).user_id(user_id).user_password(user_password).user_name(user_name)
				.user_phone(user_phone).user_nickname(user_nickname).role(role).provider(provider).build();
	}

}
