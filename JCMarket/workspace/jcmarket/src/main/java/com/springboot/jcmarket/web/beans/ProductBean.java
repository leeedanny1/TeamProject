package com.springboot.jcmarket.web.beans;

public class ProductBean {

	private int noticeTotalCount;
	private int pageNumber;
	private int startIndex;
	private int endIndex;
	private int totalPage;
	private int startPage;
	private int endPage;

	public int getNoticeTotalCount() {
		return noticeTotalCount;
	}

	public void setNoticeTotalCount(int noticeTotalCount) {
		this.noticeTotalCount = noticeTotalCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		this.startIndex = (this.pageNumber - 1) * 10;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex() {
		this.endIndex = pageNumber * 10;
		;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		this.totalPage = this.noticeTotalCount % 10 == 0 ? this.noticeTotalCount / 10 : this.noticeTotalCount / 10 + 1;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage() {
		this.startPage = this.pageNumber % 5 == 0 ? this.pageNumber - 4 : this.pageNumber - (this.pageNumber % 5) + 1;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage() {
		this.endPage = this.startPage + 4 <= this.totalPage ? this.startPage + 4 : this.totalPage;
	}

	@Override
	public String toString() {
		return "NoticeBean [noticeTotalCount=" + noticeTotalCount + ", pageNumber=" + pageNumber + ", startIndex="
				+ startIndex + ", endIndex=" + endIndex + ", totalPage=" + totalPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}

}
