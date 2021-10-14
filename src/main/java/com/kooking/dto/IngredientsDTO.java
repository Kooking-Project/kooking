package com.kooking.dto;

/**
 * @author 박은솔
 * @date 2021-10-14
 */
public class IngredientsDTO {

    private int ingredientNo; 		//재료번호
    private int recipesNo; 			//레시피번호
    private String name; 			//재료이름
    private int seq;				//재료순서
    private String cacty;			//재료용량

    
    public IngredientsDTO() {}
    
	public IngredientsDTO(int ingredientNo, int recipesNo, String name, int seq, String cacty) {
		super();
		this.ingredientNo = ingredientNo;
		this.recipesNo = recipesNo;
		this.name = name;
		this.seq = seq;
		this.cacty = cacty;
	}
	
	public int getIngredientNo() {
		return ingredientNo;
	}
	public void setIngredientNo(int ingredientNo) {
		this.ingredientNo = ingredientNo;
	}
	public int getRecipesNo() {
		return recipesNo;
	}
	public void setRecipesNo(int recipesNo) {
		this.recipesNo = recipesNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCacty() {
		return cacty;
	}
	public void setCacty(String cacty) {
		this.cacty = cacty;
	}
	
	
	
}
