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
    private int seq; 		//조리과정순서
    private String desc;     //조리과성설명
    private String tip;				//조리과정팁
    
    public ProcessDTO() {}

	public ProcessDTO(int no, int recipesNo, String imageUrl, int seq, String desc, String tip) {
		super();
		this.no = no;
		this.recipesNo = recipesNo;
		this.imageUrl = imageUrl;
		this.seq = seq;
		this.desc = desc;
		this.tip = tip;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
