package com.springboot.jcmarket.domain.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
	    
	    private int id;
	    private String user_id;
		private String user_password;
		private String user_name;
		private String user_phone;
		private String user_nickname;
		private int buy_count;
		private int sell_count;
		private String role;
		private String provider;
		private LocalDate create_date;
		private LocalDate update_date;
}
