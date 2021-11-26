package com.springboot.jcmarket.web.service;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.notice.NoticeRepository;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeRepository noticeRepository;
	
	@Override
	public NoticeDto getNotice(String notice_code) {
		plusNoticeCount(notice_code);
		return noticeRepository.getNotice(Integer.parseInt(notice_code));
	}

	@Override
	public int getNoticeMaxCode() {
		return noticeRepository.getNoticeMaxCode();
	}

	@Override
	public void plusNoticeCount(String notice_code) {
		noticeRepository.plusNoticeCount(Integer.parseInt(notice_code));
		
	}

	@Override
	public int noticeInsert(NoticeInsertDto noticeInsertDto) {
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNotice_code(getNoticeMaxCode() + 1);
		noticeDto.setNotice_title(noticeInsertDto.getNotice_title());
		noticeDto.setNotice_writer(noticeInsertDto.getNotice_writer());
		noticeDto.setNotice_content(noticeInsertDto.getNotice_content());
		
		
		int mstInsertFlag = noticeRepository.noticeMstInsert(noticeDto);
		int dtlInsertFlag = 0;
		
		if (mstInsertFlag == 1) {
			dtlInsertFlag = noticeRepository.noticeDtlInsert(noticeDto);
			return noticeDto.getNotice_code();
		}
		return dtlInsertFlag;
	}

	

	
	
}
