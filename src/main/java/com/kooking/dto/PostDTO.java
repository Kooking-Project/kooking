package com.kooking.dto;

/**
 * @author 박효승
 * @date 2021-10-14
 * 
 * 테이블 이름 : Posts 게시글
 */
public class PostDTO {
	private int no;		//게시글 번호
	private int postTypeNo;	//게시글 타입
	private int userNo;		//사용자 번호 (작성자)
	private String title;	//게시글 제목
	private String contents;	//게시글 내용
	private int counts;		//게시글 조회수
	private String date;	//게시글 작성일
	private String userNicname; //사용자 닉네임
	private UserDTO user;
	public PostDTO() {
	}
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
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


	public PostDTO(int no, int postTypeNo, int userNo, String title, String contents, int counts, String date, String userNicname) {
		super();
		this.no = no;
		this.postTypeNo = postTypeNo;
		this.userNo = userNo;
		this.title = title;
		this.contents = contents;
		this.counts = counts;
		this.date = date;
		this.userNicname = userNicname;
	}
	
	public PostDTO(int postTypeNo, int userNo, String title, String contents, int counts, String userNicname) {
		this.postTypeNo = postTypeNo;
		this.userNo = userNo;
		this.title = title;
		this.contents = contents;
		this.counts = counts;
		this.userNicname = userNicname;
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

	public String getUserNicname() {
		return userNicname;
	}

	public void setUserNicname(String userNicname) {
		this.userNicname = userNicname;
	}


	@Override
	public String toString() {
		return "PostDTO [no=" + no + ", postTypeNo=" + postTypeNo + ", userNo=" + userNo + ", title=" + title
				+ ", contents=" + contents + ", counts=" + counts + ", date=" + date + ", userNicname=" + userNicname
				+ "]";
	}


	
}