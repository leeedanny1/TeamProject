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
	private String seller_nickname;
	private String buyer_nickname;
	private int item_code;

	private String chat_index;
	private String chat_content;
	private String writer_nickname;
	private String chat_date;
	private String create_date;
	
	public Chat toEntity() {
		return Chat.builder().buyer_id(buyer_id).
				seller_id(seller_id).item_code(item_code).chat_index(chat_index)
				.chat_content(chat_content).writer_nickname(writer_nickname).chat_date(chat_date)
				.build();
		
	}
	
}