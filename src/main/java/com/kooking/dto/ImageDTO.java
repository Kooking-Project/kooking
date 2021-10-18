package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * 
 * 테이블 이름 : Images 이미지
 * */

public class ImageDTO {
	private int no;
	private String url;	//이미지 URL
	private int postNo;	//게시글 번호
	private int size;	//이미지 크기
	
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
	};
	
	
	

}
