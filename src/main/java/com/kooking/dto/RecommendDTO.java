package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * 
 *       테이블 이름 : Recommends 추천
 */

public class RecommendDTO {
	private int no; // 추천 번호
	private String postNo; // 게시글 번호
	private String userNo; // 유저 번호
	private int score; // 추천 평점
	private String date; // 추천 일자

	public RecommendDTO() {
	}

	public RecommendDTO(int no, String postNo, String userNo, int score, String date) {
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
