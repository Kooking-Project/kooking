package com.kooking.paging;

/**
 * 페이징 처리를 위한 객체
 * @author 박효승
 *
 */
public class Pagenation {
	private int pageNo = 1;		//현재 페이지
	private int pageSize = 10;	//한 페이지에 보여질 게시글 수
	private int pageCnt = 1;	//총 페이지
	private int total=0;		//총 게시글 수
	private int order=0; 		//정렬 방법 0=날짜(기본값), 1=추천수, 2=평점수
	private int blockcount = 3;
	
	public Pagenation() {}
	
	public Pagenation(int pageNo, int pageSize, int pageCnt) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageCnt = pageCnt;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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


	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	@Override
	public String toString() {
		return "Pagenation [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageCnt=" + pageCnt + "]";
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
}
