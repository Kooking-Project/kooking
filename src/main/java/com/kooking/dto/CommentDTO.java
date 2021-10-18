package com.kooking.dto;

/**
 * @author 안준성
 * @date 2021-10-14
 * 
 *       테이블 명 : Comments 댓글
 */
public class CommentDTO {
	private int no; // 댓글 번호
	private int postNo; // 게시글 번호
	private int userNo; // 사용자 번호
	private int top; // 상위 댓글
	private String content; // 댓글 내용
	private String date; // 댓글 작성시간
	private boolean deleteYN; // 삭제 여부 0=사용 1=삭제

	public CommentDTO() {
	}

	public CommentDTO(int no, int postNo, int userNo, int top, String content, String date, boolean deleteYN) {
		super();
		this.no = no;
		this.postNo = postNo;
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

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
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
