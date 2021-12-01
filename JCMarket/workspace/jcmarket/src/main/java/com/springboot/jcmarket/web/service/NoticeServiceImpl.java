package com.springboot.jcmarket.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.domain.notice.NoticeRepository;
import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	private List<Notice> noticeListAll;

	@Override
	public List<Notice> getNoticeListAll() {
		return noticeRepository.getNoticeListAll();
	}
	
	@Override
	public List<Notice> getNoticeList(int pageNumber) {
		noticeListAll = getNoticeListAll();
		
		List<Notice> noticeList = new ArrayList<Notice>();

//		setNoticeBean(pageNumber);

//		for (int i = noticeBean.getStartIndex(); i < noticeBean.getEndIndex()
//				&& i < noticeBean.getNoticeTotalCount(); i++) {
//			noticeList.add(noticeListAll.get(i));
//		}
		return noticeList;
	}
	
	@Override
	public Notice getNoticeDtl(int notice_code) {
		return noticeRepository.getNoticeDtl(notice_code);
	}
	
	
	
	@Override
	public int noticeInsert(NoticeInsertDto noticeInsertDto) {
		Notice notice = noticeInsertDto.toEntity();
		
		System.out.println(notice);
		
		int result = 0;
		if(noticeRepository.noticeMstInsert(notice) == 1) {
			Notice notice2 = noticeRepository.getInsetNoticeCode();
			notice.setNotice_code(notice2.getNotice_code());
			if(noticeRepository.noticeDtlInsert(notice) == 1) {
				result = 1;
			} else {
				System.out.println("NoticeDtlInsert 오류");
				result = 0;
			}
		} else {
			System.out.println("NoticeMstInsert 오류");
			result = 0;
		}
		return result;
	}	
	
	
	@Override
	public int noticeDelete(int notice_code) {
		return noticeRepository.noticeDelete(notice_code);
	}

}
