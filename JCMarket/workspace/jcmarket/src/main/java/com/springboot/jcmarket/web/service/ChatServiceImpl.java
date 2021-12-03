package com.springboot.jcmarket.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.domain.chat.ChatRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatServiceImpl implements ChatService {
	private final ChatRepository chatRepository;

	private List<Chat> getChatListAll;
	private List<Chat> getChatting;

	public List<Chat> getChatListAll(int id) {

		return chatRepository.getChatListAll(id);
	}

	@Override
	public List<Chat> getChatting(int seller_id, int buyer_id, int item_code) {

		Chat chat = new Chat();
		chat.setItem_code(item_code);
		chat.setBuyer_id(buyer_id);
		chat.setSeller_id(seller_id);
		System.out.println(item_code);
		System.out.println(buyer_id);
		System.out.println(seller_id);
		System.out.println(chat);
		return chatRepository.getChatting(chat);
	}
}
