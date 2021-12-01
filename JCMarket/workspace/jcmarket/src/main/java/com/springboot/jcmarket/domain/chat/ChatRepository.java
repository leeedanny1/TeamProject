package com.springboot.jcmarket.domain.chat;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRepository {
	public Chat getChatList();
	public Chat getChatting(String seller_id,String buyer_id,int itme_code);
}
