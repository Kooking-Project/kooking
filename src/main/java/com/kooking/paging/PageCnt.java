package com.kooking.paging;

public class PageCnt {
	private static int pageCnt; //�������� ��Math.ceil(��ü���ڵ�� /pagesize) 
	public static int pagesize = 8;// �� ������ �� 5�� ��¹�
	public static int pageNo=1;//���� ��������ȣ
	
	public  int blockcount=3;//�� ���� ������ ������ ����
	
	//String keyField;
	
	public PageCnt() {
		super();
	}

	public PageCnt(int pageCnt) {
		super();
		PageCnt.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		PageCnt.pageCnt = pageCnt;
	}

	public static int getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		PageCnt.pagesize = pagesize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		PageCnt.pageNo = pageNo;
	}

	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	
}
