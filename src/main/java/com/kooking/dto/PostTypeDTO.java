package com.kooking.dto;

/**
 * @author 박효승
 * @date 2021-10-14
 */
public class PostTypeDTO {
	private int no;
	private String name;
	
	public PostTypeDTO() {
	}

	
	public PostTypeDTO(int no, String name) {
	super();
	this.no = no;
	this.name = name;
}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PostType [no=" + no + ", name=" + name + "]";
	}

	
}
