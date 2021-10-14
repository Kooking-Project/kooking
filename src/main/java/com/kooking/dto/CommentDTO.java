package com.kooking.dto;

import java.sql.Blob;

/**
 * @author 안준성
 * @date 2021-10-14
 * */

public class CommentDTO {
	
	private int no;
	private int postNO;
	private int userNo;
	private int top;
	private String content;
	private String date;
	private boolean deleteYN;
	
	public CommentDTO() {}

	public CommentDTO(int no, int postNO, int userNo, int top, String content, String date, boolean deleteYN) {
		super();
		this.no = no;
		this.postNO = postNO;
		this.userNo = userNo;
		this.top = top;
		this.content = content;
		this.date = date;
		this.deleteYN = deleteYN;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPostNO() {
		return postNO;
	}

	public void setPostNO(int postNO) {
		this.postNO = postNO;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(boolean deleteYN) {
		this.deleteYN = deleteYN;
	}
	
	
	

}
