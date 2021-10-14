package com.kooking.dto;

/**
 * 원재

테이블 이름 : RecipeDetail 레시피 상세
 * */
public class RecipeDetailDTO {
	private String name;	//레시피 상세 이름
	private int recipeCategoryNo;	//레시피 카테고리 번호

	public RecipeDetailDTO() {}
	public RecipeDetailDTO(String name, int recipeCategoryNo) {
		super();
		this.name = name;
		this.recipeCategoryNo = recipeCategoryNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecipeCategoryNo() {
		return recipeCategoryNo;
	}
	public void setRecipeCategoryNo(int recipeCategoryNo) {
		this.recipeCategoryNo = recipeCategoryNo;
	}
}
