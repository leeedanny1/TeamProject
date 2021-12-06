package com.springboot.jcmarket.domain.chat;


import java.time.LocalDateTime;

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
	private int item_code;
	private int buyer_id;
	private int seller_id;
	
	private String buyer_nickname;
	private String seller_nickname;
	
	private LocalDateTime update_date;
	
	//chat_dtl
	private int chat_index;
	private String chat_content;
	private int writer_id;
	private String writer_nickname;
	private String chat_date;
	private String create_date;
	
	
}