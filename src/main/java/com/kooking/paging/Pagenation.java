package com.kooking.paging;

/**
 * 페이징 처리를 위한 객체
 * @author 박효승
 *
 */
public class Pagenation {
	private int pageNo = 1;
	private int pageSize = 10;
	private int pageCnt = 1;
	
	public Pagenation() {}
	
	public Pagenation(int pageNo, int pageSize, int pageCnt) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageCnt = pageCnt;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageCnt() {
		return pageCnt;
	}


	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}


	@Override
	public String toString() {
		return "Pagenation [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageCnt=" + pageCnt + "]";
	}
	
	
	
}
