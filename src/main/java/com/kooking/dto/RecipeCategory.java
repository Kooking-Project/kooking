package com.kooking.dto;

/**
 * 원재
 * CREATE TABLE RECIPE_CATEGORY(
    RECIPE_CATEGORY_NO 		NUMBER(10) 		PRIMARY KEY,
    RECIPE_CATEGORY_NAME 	VARCHAR2(50) 	NOT NULL
);
 * */
public class RecipeCategory {
	private int no;
	private String name;
	
	public RecipeCategory() {}
	public RecipeCategory(int no, String name) {
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
