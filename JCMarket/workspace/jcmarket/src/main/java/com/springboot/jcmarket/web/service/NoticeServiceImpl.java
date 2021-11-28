package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.notice.NoticeRepository;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;

	@Override
	public NoticeDto getNotice() {
		return noticeRepository.getNotice();
//				noticeDao.getNotice(Integer.parseInt(notice_code));
	}
	
}
