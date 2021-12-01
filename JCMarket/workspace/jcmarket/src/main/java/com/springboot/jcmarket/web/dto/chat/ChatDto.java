package com.springboot.jcmarket.web.dto.chat;

import com.springboot.jcmarket.domain.chat.Chat;

import lombok.Data;

@Data
public class ChatDto {
	private String seller_id;
	private String buyer_id;
	private int item_code;

	private String chat_index;
	private String chat_content;
	private String chat_date;
	private String create_date;
	
	public Chat toEntity() {
		return Chat.builder().buyer_id(buyer_id).
				seller_id(seller_id).item_code(item_code).chat_index(chat_index)
				.chat_content(chat_content).chat_date(chat_date)
				.build();
		
	}
	
}
