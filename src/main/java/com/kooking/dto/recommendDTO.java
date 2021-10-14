package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * */

public class recommendDTO {
	private int no;
	private String postNo;
	private String userNo;
	private int score;
	private String date;
	
	public recommendDTO() {}
	public recommendDTO(int no, String postNo, String userNo, int score, String date) {
		super();
		this.no = no;
		this.postNo = postNo;
		this.userNo = userNo;
		this.score = score;
		this.date = date;
		
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
