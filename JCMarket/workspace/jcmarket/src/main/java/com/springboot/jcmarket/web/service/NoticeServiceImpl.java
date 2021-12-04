package com.springboot.jcmarket.web.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.jcmarket.domain.notice.Notice;
import com.springboot.jcmarket.domain.notice.NoticeRepository;
import com.springboot.jcmarket.web.beans.FileBean;
import com.springboot.jcmarket.web.beans.NoticeBean;
import com.springboot.jcmarket.web.dto.notice.NoticeDto;
import com.springboot.jcmarket.web.dto.notice.NoticeInsertDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	private final ServletContext context;
	
	private NoticeBean noticeBean;
	private List<Notice> noticeListAll;
	
	NoticeDto noticeDto = new NoticeDto();

	
//	공지사항 가져오기
	// 빈 만들기
	@Override
	public void setNoticeBean(int pageNumber) {
		noticeBean = new NoticeBean();
		noticeBean.setNoticeTotalCount(noticeListAll.size());
		noticeBean.setPageNumber(pageNumber);
		noticeBean.setStartIndex();
		noticeBean.setEndIndex();
		noticeBean.setTotalPage();
		noticeBean.setStartPage();
		noticeBean.setEndPage();
	}
	@Override
	public NoticeBean getNoticeBean() {
		return noticeBean;
	}
	@Override
	public int parseIntPageNumber(int pageNumber) {
		return pageNumber;
	}
	// 모든 공지사항 가져옴
	@Override
	public List<Notice> getNoticeListAll() {
		return noticeRepository.getNoticeListAll();
	}
	// 원하는 갯수만큼 노출
	@Override
	public List<Notice> getNoticeList(int pageNumber) {
		noticeListAll = getNoticeListAll();
		
		List<Notice> noticeList = new ArrayList<Notice>();
		
		setNoticeBean(pageNumber);

		for (int i = noticeBean.getStartIndex(); i < noticeBean.getEndIndex()
				&& i < noticeBean.getNoticeTotalCount(); i++) {
			noticeList.add(noticeListAll.get(i));
		}
		return noticeList;
	}
	
	
	
//	파일 업/다운로드
	// 파일 업로드
	@Override
	public NoticeDto fileUpload(NoticeInsertDto noticeInsertDto) {
		// 경로지정
		String filePath = context.getRealPath("/static/fileupload");
		
		// insertDto에 있는 notoce_file을 multipartFile로..
		MultipartFile[] multipartFiles = noticeInsertDto.getNotice_file();
		
//		NoticeDto noticeDto = new NoticeDto();

		StringBuilder originName = new StringBuilder();
		StringBuilder tempName = new StringBuilder();
		
		for (MultipartFile multipartFile : multipartFiles) {
			String originFile = multipartFile.getOriginalFilename();
			// 파일이름이 없다면 바로 dto 반환
			if (originFile.equals("")) {
				return noticeDto;
			}
//			파일의 이름을 변경함.
//			중복되는 파일명이 올라오면 하나는 사라지기 때문.
			String originFileExtention = originFile.substring(originFile.lastIndexOf("."));
			String tempFile = UUID.randomUUID().toString().replaceAll("-", "") + originFileExtention;

			originName.append(originFile);
			originName.append(",");
			tempName.append(tempFile);
			tempName.append(",");

//			파일을 지정 경로에 저장
			File file = new File(filePath, tempFile);
			// 경로가 없다면 만들어주고
			if (!file.exists()) {
				file.mkdirs();
			}
			// 경로에 저장해라
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
//		마지막 파일명의 쉼표 지우기
		originName.delete(originName.length() - 1, originName.length());
		tempName.delete(tempName.length() - 1, tempName.length());
//		파일이름을 저장해서 dto에 저장
		noticeDto.setOriginFileNames(originName.toString());
		noticeDto.setTempFileNames(tempName.toString());

		return noticeDto;
	}
	// 파일 리스트 가져오기
	@Override
	public List<FileBean> getFileList(Notice notice) {
		// dto에 파일리스트가 없다면 null 반환
		if (notice.getOriginFileNames() == null || notice.getTempFileNames() == null) {
			return null;
		}

		// 파일 리스트 생성
		List<FileBean> fileList = new ArrayList<FileBean>();

		// ,기준으로 나눔
		StringTokenizer ofn = new StringTokenizer(notice.getOriginFileNames(), ",");
		StringTokenizer tfn = new StringTokenizer(notice.getTempFileNames(), ",");

		// 오리진 파일 네임이 있다면 fileBean에 넣음
		while (ofn.hasMoreTokens()) {
			FileBean fileBean = new FileBean();
			fileBean.setOriginFileName(ofn.nextToken());
			fileBean.setTempFileName(tfn.nextToken());
			fileList.add(fileBean);
		}

		return fileList;
	}
	// 파일 다운로드
	@Override
	public byte[] fileDownload(FileBean fileBean) {
		// 파일 경로 설정하고 파일에 이름 담기
		String filePath = context.getRealPath("/static/fileupload");
		File file = new File(filePath, fileBean.getTempFileName());
		
		byte[] fileData = null;
		
		try {
			fileData = FileCopyUtils.copyToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileData;
	}
	
	
	
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
	public int noticeInsert(NoticeInsertDto noticeInsertDto) {
		fileUpload(noticeInsertDto);
		
		noticeDto.setNotice_title(noticeInsertDto.getNotice_title());
		noticeDto.setNotice_writer(noticeInsertDto.getNotice_writer());
		noticeDto.setNotice_content(noticeInsertDto.getNotice_content());
		
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
//		파일 업데이트랑 삭제 구현해야 함.
//		NoticeInsertDto noticeInsertDto = new NoticeInsertDto();
//		fileUpload(noticeInsertDto);
		
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
