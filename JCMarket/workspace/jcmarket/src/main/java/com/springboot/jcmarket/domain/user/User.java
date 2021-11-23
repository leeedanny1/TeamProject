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
		private int buy_count;
		private int sell_count;
		private String role;
<<<<<<< HEAD
		private String provider;
=======
	    private String provider;
>>>>>>> 09b81f3ec0b37c6026bea4c359d5b3b3ed0842cd
		private Date createdate;
		private Date updatedate;
}
