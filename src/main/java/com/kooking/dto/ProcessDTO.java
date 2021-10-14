package com.kooking.dto;

/**
 * @author 박은솔
 * @date 2021-10-14
 * 
 * 테이블 이름 : Process 조리과정
 */
public class ProcessDTO {

    private int no; 			//조리과정 번호
    private int recipesNo; 			//레시피 번호
    private String imageUrl; 		//이미지 URL
    private int cookingSeq; 		//조리과정순서
    private String cookingDesc;     //조리과성설명
    private String tip;				//조리과정팁
    
    public ProcessDTO() {}

	public ProcessDTO(int no, int recipesNo, String imageUrl, int cookingSeq, String cookingDesc, String tip) {
		super();
		this.no = no;
		this.recipesNo = recipesNo;
		this.imageUrl = imageUrl;
		this.cookingSeq = cookingSeq;
		this.cookingDesc = cookingDesc;
		this.tip = tip;
	}

	public int getProcessNo() {
		return no;
	}

	public void setProcessNo(int no) {
		this.no = no;
	}

	public int getRecipesNo() {
		return recipesNo;
	}

	public void setRecipesNo(int recipesNo) {
		this.recipesNo = recipesNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCookingSeq() {
		return cookingSeq;
	}

	public void setCookingSeq(int cookingSeq) {
		this.cookingSeq = cookingSeq;
	}

	public String getCookingDesc() {
		return cookingDesc;
	}

	public void setCookingDesc(String cookingDesc) {
		this.cookingDesc = cookingDesc;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
    
	
    
}
