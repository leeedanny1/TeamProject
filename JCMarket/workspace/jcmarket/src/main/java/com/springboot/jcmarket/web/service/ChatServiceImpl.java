package com.springboot.jcmarket.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.domain.chat.ChatRepository;
import com.springboot.jcmarket.web.dto.chat.ChatDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
	private final ChatRepository chatRepository;
	
	private List<Chat> getChatListAll;
	private List<Chat> getChatting;
	
	public List<Chat> getChatListAll(String user_nickname) {
		
		return chatRepository.getChatListAll(user_nickname);
	}

	@Override
	public List<Chat> getChatting() {
		
		return chatRepository.getChatting();
	}

}
