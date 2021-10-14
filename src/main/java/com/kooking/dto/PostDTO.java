package com.kooking.dto;

/**
 * @author 박효승
 * @date 2021-10-14
 */
public class PostDTO {
	private int no;
	private int postTypeNo;
	private int userNo;
	private String title;
	private String contents;
	private int counts;
	private String date;
	
	public PostDTO() {
	}
	
	public PostDTO(int no, int postTypeNo, int userNo, String title, String contents, int counts, String date) {
		super();
		this.no = no;
		this.postTypeNo = postTypeNo;
		this.userNo = userNo;
		this.title = title;
		this.contents = contents;
		this.counts = counts;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPostTypeNo() {
		return postTypeNo;
	}

	public void setPostTypeNo(int postTypeNo) {
		this.postTypeNo = postTypeNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PostDTO [no=" + no + ", postTypeNo=" + postTypeNo + ", userNo=" + userNo + ", title=" + title
				+ ", contents=" + contents + ", counts=" + counts + ", date=" + date + "]";
	}
	
}