package com.kooking.dto;

/**
 * @author 박효승
 * @date 2021-10-14
 * 
 * 테이블 이름 : Users 사용자
 */
public class UserDTO {
	private int no;		//사용자 번호
	private String id;	//사용자 아이디
	private String pwd;	//사용자 비밀번호
	private String nickName;	//사용자 닉네임
	private int gender;		//사용자 성별
	private String enrollDate;	//사용자 가입일자
	private String profileImg;	//사용자 프로필 이미지 URL
	private int status;		//사용자 활동 상태 0 = 기본, 1=활동정지, 2=탈퇴, 10=어드민(DB에 number(2,0)돼있음)
	
	public UserDTO() {}
	
	public UserDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	public UserDTO(int no, 	int status) {	//상태변경
		super();
		this.no = no;
		this.status = status;
	}
	public UserDTO(int no, 	String profileImg) {	//프로필 설정
		super();
		this.no = no;
		this.profileImg = profileImg;
	}
	
	public UserDTO(int no, String pwd, String nickName, int gender) {
		super();
		this.no = no;
		this.pwd = pwd;
		this.nickName = nickName;
		this.gender = gender;
	}
	
	public UserDTO(int no, String id, String pwd, String nickName, int gender, String enrollDate, String profileImg,
			int status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nickName = nickName;
		this.gender = gender;
		this.enrollDate = enrollDate;
		this.profileImg = profileImg;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nickName=" + nickName + ", gender=" + gender
				+ ", enrollDate=" + enrollDate + ", profileImg=" + profileImg + ", status=" + status + "]";
	}
	
}
