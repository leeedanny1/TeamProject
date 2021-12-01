package com.springboot.jcmarket.domain.chat;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.jcmarket.web.dto.chat.ChatDto;

@Mapper
public interface ChatRepository {
	
	public Chat getChatList();
	public Chat getChatting(ChatDto chatdto);
}
