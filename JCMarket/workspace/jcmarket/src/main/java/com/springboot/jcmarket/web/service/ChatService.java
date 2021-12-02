package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.web.dto.chat.ChatDto;

public interface ChatService {
	public List<Chat> getChatListAll(String user_nickname);
	public List<Chat> getChatting(int item_code,int buyer_id,int seller_id);
}
