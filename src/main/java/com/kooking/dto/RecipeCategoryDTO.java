package com.kooking.dto;

/**
 * 원재

테이블 이름 : RecipeCategory 레시피 카테고리
 * */
public class RecipeCategoryDTO {
	private int no;		//레시피 카테고리 번호
	private String name;	//레시피 카테고리 이름
	
	public RecipeCategoryDTO() {}
	public RecipeCategoryDTO(int no, String name) {
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
	
	
}
