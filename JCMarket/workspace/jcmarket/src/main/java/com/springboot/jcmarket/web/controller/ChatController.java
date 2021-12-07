package com.springboot.jcmarket.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jcmarket.config.auth.PrincipalDetails;
import com.springboot.jcmarket.web.dto.chat.ChatDto;
import com.springboot.jcmarket.web.service.ChatService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {
	private final ChatService chatService;


	@GetMapping("/chat")
	public ModelAndView chatList(@AuthenticationPrincipal PrincipalDetails prDetails) {
		ModelAndView mav = new ModelAndView("chat/chat");
		mav.addObject("chatList", chatService.getChatListAll(prDetails.getUser().getId()));
		
		return mav;
	}
	
	@ResponseBody
	@PostMapping("/chatting/{roomNumber}")
	public Object chattingList(@RequestBody ChatDto chatdto, @PathVariable int roomNumber) {
		System.out.println(chatdto);
		return chatService.getChatting(chatdto);
	}
	
	@ResponseBody
	@PostMapping("/chat-insert")
	public String chat_insert(@RequestBody ChatDto chatdto) {
		System.out.println("asdf"+chatdto);
		return Integer.toString(chatService.Chattinginput(chatdto));
	}
}
