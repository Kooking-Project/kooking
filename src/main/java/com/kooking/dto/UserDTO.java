package com.kooking.dto;

/**
 * @author 박효승
 * @date 2021-10-14
 */
public class UserDTO {
	private int no;
	private String id;
	private String pwd;
	private String nickName;
	private int gender;
	private String enrollDate;
	private String profileImg;
	private int status;
	
	public UserDTO() {}
	
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
