package com.springboot.jcmarket.web.service;

import java.util.List;

import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.web.dto.chat.ChatDto;

public interface ChatService {
	public List<Chat> getChatListAll(int id);
	public List<Chat> getChatting(ChatDto chatDto);
	public int Chattinginput(ChatDto chatDto);
	public int listinput(ChatDto chatdto);
	public int listselect(ChatDto chatdto);
}