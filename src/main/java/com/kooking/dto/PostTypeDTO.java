package com.kooking.dto;

import java.util.EnumMap;

/**
 * @author 박효승
 * @date 2021-10-14
 * 
 * 테이블 이름 : PostType 게시판 유형
 */
public class PostTypeDTO {
	private int no;		//게시판 유형 코드
	private String name;	//게시판 이름
	
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
