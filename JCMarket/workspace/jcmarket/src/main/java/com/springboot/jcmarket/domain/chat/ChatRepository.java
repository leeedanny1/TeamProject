package com.springboot.jcmarket.domain.chat;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChatRepository {
	
	public List<Chat> getChatListAll(int id);
	public List<Chat> getChatting(Chat chat);
	public int chattinginput(Chat chat);
	public int listinput(Chat chat);
}