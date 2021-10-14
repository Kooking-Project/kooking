package com.kooking.dto;

/**
 * @author 박은솔
 * @date 2021-10-14
 */
public class BookmarksDTO {

    private int userNo; 			//사용자 번호
    private int postNo; 			//게시글 번호
    private String bookmarkDate; 	//즐겨찾기 날짜
    
    public BookmarksDTO() {}
    
	public BookmarksDTO(int userNo, int postNo, String bookmarkDate) {
		super();
		this.userNo = userNo;
		this.postNo = postNo;
		this.bookmarkDate = bookmarkDate;
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
	public String getBookmarkDate() {
		return bookmarkDate;
	}
	public void setBookmarkDate(String bookmarkDate) {
		this.bookmarkDate = bookmarkDate;
	}
	
	
}
