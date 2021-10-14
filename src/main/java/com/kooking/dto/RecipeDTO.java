package com.kooking.dto;

/**
 * 원재
 * CREATE TABLE RECIPES(
    RECIPES_NO 				NUMBER(20) 		PRIMARY KEY,
    POST_NO 				NUMBER(20) 		REFERENCES POSTS(POST_NO) UNIQUE NOT NULL,
    RECIPES_CALORIE 		NUMBER(10),
    RECIPES_COOKING_TIME 	NUMBER(8),
    RECIPES_NATION 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE ,
    RECIPES_TYPE 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE ,
    RECIPES_LEVEL 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE 
);
 * */

public class RecipeDTO {
	private int no;
	private int postNo;
	private int calorie;
	private int cookingTime;
	private String nation;
	private String type;
	private String level;
	
	public RecipeDTO() {}
	public RecipeDTO(int no, int postNo, int calorie, int cookingTime, String nation, String type, String level) {
		super();
		this.no = no;
		this.postNo = postNo;
		this.calorie = calorie;
		this.cookingTime = cookingTime;
		this.nation = nation;
		this.type = type;
		this.level = level;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
	
}
