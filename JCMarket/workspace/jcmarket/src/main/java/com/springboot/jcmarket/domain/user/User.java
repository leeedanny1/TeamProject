package com.springboot.jcmarket.domain.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

	    private String user_id;
		private String user_password;
		private String user_name;
		private String user_phone;
		private String user_nickname;
		private String role;
//		private String provider;
		private Date createdate;
		private Date updatedate;
}
