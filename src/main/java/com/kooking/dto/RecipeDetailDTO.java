package com.kooking.dto;

/**
 * 원재

테이블 이름 : RecipeDetail 레시피 상세
 * */
public class RecipeDetailDTO {
	private String name;	//레시피 상세 이름
	private int recipeCategoryNo;	//레시피 카테고리 번호
	private String recipeCategoryName; //레시피 카테고리 이름

	public RecipeDetailDTO() {}
	public RecipeDetailDTO(String name, int recipeCategoryNo, String recipeCategoryName) {
		super();
		this.name = name;
		this.recipeCategoryNo = recipeCategoryNo;
		this.recipeCategoryName = recipeCategoryName;
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
	public String getRecipeCategoryName() {
		return recipeCategoryName;
	}
	public void setRecipeCategoryName(String recipeCategoryName) {
		this.recipeCategoryName = recipeCategoryName;
	}
	@Override
	public String toString() {
		return "RecipeDetailDTO [name=" + name + ", recipeCategoryNo=" + recipeCategoryNo + ", recipeCategoryName="
				+ recipeCategoryName + "]";
	}
	
	
}
