package com.springboot.jcmarket.web.dto.chat;



import com.springboot.jcmarket.domain.chat.Chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatDto {
	private String seller_nickname;
	private String buyer_nickname;
	private int item_code;

	private String chat_index;
	private String chat_content;
	private String chat_date;
	private String create_date;
	
	public Chat toEntity() {
		return Chat.builder().buyer_nickname(buyer_nickname).
				seller_nickname(seller_nickname).item_code(item_code).chat_index(chat_index)
				.chat_content(chat_content).chat_date(chat_date)
				.build();
		
	}
	
}
