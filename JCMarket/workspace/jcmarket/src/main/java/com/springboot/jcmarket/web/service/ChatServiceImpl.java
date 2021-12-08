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

	public List<Chat> getChatListAll(int id) {

		return chatRepository.getChatListAll(id);
	}

	@Override
	public List<Chat> getChatting(ChatDto chatDto) {
		Chat chat = chatDto.toEntity();
		System.out.println(chat);
		return chatRepository.getChatting(chat);
	}

	@Override
	public int Chattinginput(ChatDto chatDto) {
		Chat chat = chatDto.toEntity();
		System.out.println(chat);
		return chatRepository.chattinginput(chat);
	}

	@Override
	public int listinput(ChatDto chatdto) {
		Chat chat = chatdto.toEntity();
		System.out.println("asdfasd"+chat);
		return chatRepository.listinput(chat);
	}
}
