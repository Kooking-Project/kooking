package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * 
 * 테이블 이름 : Images 이미지
 * */

public class ImageDTO {
	private int no;		//이미지번호
	private String url;	//이미지 URL
	private int postNo;	//게시글 번호
	private int size;	//이미지 크기
	private int position; //이미지 조리과정 순서
	private int seq;	//이미지를 보여줄 순서
	
	public ImageDTO() {}

	public ImageDTO(int no, String url, int postNo, int size) {
		super();
		this.no = no;
		this.url = url;
		this.postNo = postNo;
		this.size = size;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ImageDTO [no=" + no + ", url=" + url + ", postNo=" + postNo + ", size=" + size + "]";
	};
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
