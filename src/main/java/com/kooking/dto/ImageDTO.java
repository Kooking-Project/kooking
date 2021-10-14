package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * */

public class ImageDTO {
	
	private String url;
	private int postNo;
	private int size;
	
	public ImageDTO() {}

	public ImageDTO(String url, int postNo, int size) {
		super();
		this.url = url;
		this.postNo = postNo;
		this.size = size;
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
