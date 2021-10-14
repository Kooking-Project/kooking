package com.kooking.dto;

/**
 * @author 박은솔
 * @date 2021-10-14
 * 
 * 테이블 이름 : Bookmarks 즐겨찾기
 */
public class BookmarkDTO {
    private int userNo; 			//사용자 번호
    private int postNo; 			//게시글 번호
    private String date; 	//즐겨찾기 날짜
    
    public BookmarkDTO() {}
    
	public BookmarkDTO(int userNo, int postNo, String date) {
		super();
		this.userNo = userNo;
		this.postNo = postNo;
		this.date = date;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
