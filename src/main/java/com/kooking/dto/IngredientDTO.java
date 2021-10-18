package com.kooking.dto;

/**
 * @author 박은솔
 * @date 2021-10-14
 * 
 * 테이블 이름 : Ingredients 재료
 */
public class IngredientDTO {
    private int no; 		//재료번호
    private int recipesNo; 			//레시피번호
    private String name; 			//재료이름
    private int seq;				//재료순서
    private String cacty;			//재료용량

    
    public IngredientDTO() {}
    
	public IngredientDTO(int no, int recipesNo, String name, int seq, String cacty) {
		super();
		this.no = no;
		this.recipesNo = recipesNo;
		this.name = name;
		this.seq = seq;
		this.cacty = cacty;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "IngredientDTO [no=" + no + ", recipesNo=" + recipesNo + ", name=" + name + ", seq=" + seq + ", cacty="
				+ cacty + "]";
	}
	
	
	
	
}
