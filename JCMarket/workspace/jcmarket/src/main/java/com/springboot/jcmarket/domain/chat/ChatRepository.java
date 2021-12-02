package com.springboot.jcmarket.domain.chat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChatRepository {
	
	public List<Chat> getChatListAll(String user_nickname);
	public List<Chat> getChatting();
}
