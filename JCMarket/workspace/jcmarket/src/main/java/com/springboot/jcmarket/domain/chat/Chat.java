package com.springboot.jcmarket.domain.chat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Chat {
	//chat_mst
	private String seller_nickname;
	private String buyer_nickname;
	private int item_code;
	//chat_dtl
	private String chat_index;
	private String chat_content;
	private String chat_date;
	private String create_date;
	
	
}
