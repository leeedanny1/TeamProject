package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/chatting/{item_code}/{buyer_id}")
	public ModelAndView chattingList(@AuthenticationPrincipal PrincipalDetails prDetails, @PathVariable int item_code,@PathVariable int buyer_id) {
		ModelAndView mav = new ModelAndView("chat/chat");
		mav.addObject("chatmsg", chatService.getChatting(prDetails.getUser().getId(),buyer_id,item_code));
		System.out.println(item_code);
		System.out.println(buyer_id);
		System.out.println(prDetails.getUser().getId());
		System.out.println(mav);
		return mav;
	}

	@PostMapping("/chat-insert")
	public String chat_insert() {

		return null;
	}
}
