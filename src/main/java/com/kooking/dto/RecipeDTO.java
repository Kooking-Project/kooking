package com.kooking.dto;

import java.util.List;

/**
 * 원재 
 * 테이블 이름 : Recipes 레시피
 */

public class RecipeDTO {
	private int no;		//레시피 번호
	private String name;	//레시피 이름
	private int postNo;		//게시글 번호
	private int calorie;	//칼로리
	private int cookingTime;	//조리시간
	private String nation;	//레시피 국가
	private String type;	//레시피 분류
	private String level;	//레시피 조리난이도

	//1 : 다
	private List<RecipeDetailDTO> detailList;
	private List<CommentDTO> repliesList;
	
	//페이지처리
	private int pageCnt;
	
	public RecipeDTO() {}

	public RecipeDTO(int no, String name, int postNo, int calorie, int cookingTime, String nation, String type,
			String level) {
		super();
		this.no = no;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
