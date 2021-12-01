package com.springboot.jcmarket.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.domain.notice.NoticeRepository;

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

}
