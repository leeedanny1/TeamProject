package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.web.dto.auth.SignUpDto;
import com.springboot.jcmarket.web.dto.chat.ChatDto;

public interface ChatService {
	public List<Chat> getChatListAll(int id);
	public List<Chat> getChatting(int seller_id, int buyer_id, int item_code);
	public int Chatting(ChatDto chatDto);
}
