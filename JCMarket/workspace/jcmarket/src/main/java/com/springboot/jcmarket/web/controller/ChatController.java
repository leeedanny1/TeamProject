package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.domain.chat.Chat;
import com.springboot.jcmarket.web.dto.chat.ChatDto;
import com.springboot.jcmarket.web.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {
	private final ChatService chatService;
	private Chat chat;

	@GetMapping("/chat")
	public ModelAndView chatList(@AuthenticationPrincipal PrincipalDetails prDetails) {
		ModelAndView mav = new ModelAndView("chat/chat");
		
		mav.addObject("chatList", chatService.getChatListAll(prDetails.getUser().getUser_nickname()));
		return mav;
	}
	@GetMapping("/chatting")
	public ModelAndView chattingList() {
		ModelAndView mav = new ModelAndView("chat/chat");
		mav.addObject("chatmsg", chatService.getChatting());
		System.out.println( chatService.getChatting());
		return mav;
	}

	@PostMapping("/chat-insert")
	public String chat_insert() {

		return null;
	}
}
