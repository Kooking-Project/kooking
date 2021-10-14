package com.kooking.dto;

/**
 * 원재
 * CREATE TABLE RECIPE_DETAIL(
    RECIPE_DETAIL_NAME 		VARCHAR2(30) 	PRIMARY KEY,
    RECIPE_CATEGORY_NO 		NUMBER(10) 		REFERENCES RECIPE_CATEGORY(RECIPE_CATEGORY_NO) ON DELETE CASCADE NOT NULL
);
 * */
public class RecipeDetailDTO {
	private String name;
	private int recipeCategoryNo;

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
