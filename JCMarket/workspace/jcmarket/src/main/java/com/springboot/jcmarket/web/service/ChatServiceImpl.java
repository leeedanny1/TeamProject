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

	public List<Chat> getChatListAll(int id) {

		return chatRepository.getChatListAll(id);
	}

	@Override
	public List<Chat> getChatting(int seller_id, int buyer_id, int item_code) {

		Chat chat = new Chat();
		chat.setItem_code(item_code);
		chat.setBuyer_id(buyer_id);
		chat.setSeller_id(seller_id);
		return chatRepository.getChatting(chat);
	}

	@Override
	public int Chattinginput(int seller_id, int buyer_id, int item_code,String writer_nickname,String chat_content) {
		Chat chat = new Chat();
		chat.setSeller_id(seller_id);
		chat.setBuyer_id(buyer_id);
		chat.setItem_code(item_code);
		chat.setWriter_nickname(writer_nickname);
		chat.setChat_content(chat_content);
		System.out.println("asdf"+chat);
		return chatRepository.Chattinginput(chat);
	}
}
