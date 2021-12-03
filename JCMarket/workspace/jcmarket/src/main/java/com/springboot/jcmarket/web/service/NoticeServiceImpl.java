package com.springboot.jcmarket.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.domain.notice.NoticeRepository;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	private List<Notice> noticeListAll;
//	private NoticeBean noticeBean;

	
//	공지사항 가져오기
	// 모든 공지사항 가져옴
	@Override
	public List<Notice> getNoticeListAll() {
		return noticeRepository.getNoticeListAll();
	}
	// 빈 만들기
//	@Override
//	public void setNoticeBean(int pageNumber) {
//		noticeBean = new NoticeBean();
//		noticeBean.setNoticeTotalCount(noticeListAll.size());
//		noticeBean.setPageNumber(pageNumber);
//		noticeBean.setStartIndex();
//		noticeBean.setEndIndex();
//		noticeBean.setTotalPage();
//		noticeBean.setStartPage();
//		noticeBean.setEndPage();
//	}
//	@Override
//	public NoticeBean getNoticeBean() {
//		return noticeBean;
//	}
//	@Override
//	public int parseIntPageNumber(int pageNumber) {
//		return pageNumber;
//	}
	// 원하는 갯수만큼 노출
//	@Override
//	public List<Notice> getNoticeList(int pageNumber) {
//		noticeListAll = getNoticeListAll();
//		
//		List<Notice> noticeList = new ArrayList<Notice>();
//		
//		setNoticeBean(pageNumber);
//
//		for (int i = noticeBean.getStartIndex(); i < noticeBean.getEndIndex()
//				&& i < noticeBean.getNoticeTotalCount(); i++) {
//			noticeList.add(noticeListAll.get(i));
//		}
//		return noticeList;
//	}
	
	
	
//	조회수 증가
	@Override
	public void plusNoticeCount(int notice_code) {
		noticeRepository.plusNoticeCount(notice_code);
	}
	
	
	
//	디테일 페이지
	@Override
	public Notice getNoticeDtl(int notice_code) {
		plusNoticeCount(notice_code);
		return noticeRepository.getNoticeDtl(notice_code);
	}
	
	
	
//	공지사항 등록
	@Override
	public int noticeInsert(NoticeDto noticeDto) {
		Notice notice = noticeDto.toEntity();
		
		int mstResult = 0, dtlResult = 0;

		mstResult = noticeRepository.noticeMstInsert(notice);
		if(mstResult == 1) {
			dtlResult = noticeRepository.noticeDtlInsert(notice);
		}
		return dtlResult;
	}	
	
	
	
//	공지사항 수정
	@Override
	public int noticeUpdate(NoticeDto noticeDto) {
		Notice notice = noticeDto.toEntity();
		
		int mstResult = 0, dtlResult = 0;
		
		mstResult = noticeRepository.noticeMstUpdate(notice);
		if(mstResult == 1) {
			dtlResult = noticeRepository.noticeDtlUpdate(notice);
		}
		return dtlResult;
	}
	
	
	
//	공지사항 삭제
	@Override
	public int noticeDelete(int notice_code) {
		return noticeRepository.noticeDelete(notice_code);
	}

}
