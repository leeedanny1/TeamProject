package com.springboot.jcmarket.web.dto.chat;
import com.springboot.jcmarket.domain.chat.Chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatDto {
	private int seller_id;
	private int buyer_id;
	private int item_code;

	private int chat_index;
	private String chat_content;
	private int writer_id;
	private String writer_nickname;
	private String chat_date;
	private String create_date;
	
	public Chat toEntity() {
		return Chat.builder().item_code(item_code).buyer_id(buyer_id).
				seller_id(seller_id).chat_index(chat_index)
				.chat_content(chat_content).writer_id(writer_id).chat_date(chat_date)
				.build();
		
	}
	
}
