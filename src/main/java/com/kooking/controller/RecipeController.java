package com.kooking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kooking.dao.RecipeDAO;
import com.kooking.dao.RecipeDAOImpl;
import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.service.PostService;
import com.kooking.service.PostServiceImpl;
import com.kooking.service.RecipeService;
import com.kooking.service.RecipeServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * @author 박은솔
 * @date 2021-10-19
 */
public class RecipeController implements Controller {
	private RecipeService recipeService = new RecipeServiceImpl();
	private PostService postService = new PostServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 레시피 등록하기 : 게시판 타입이 레시피라면 
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveDir=request.getServletContext().getRealPath("/save/recipe");
		int maxSize = 1024*1024*100; //100M 
		String encoding="UTF-8";

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		//    	//게시글 등록 insertPost() 에서 ??
		String title = m.getParameter("post_title"); //레시피제목
		String contents = m.getParameter("post_content"); //요리소개

		System.out.println("post_title = " + title);
		System.out.println("post_content = " + contents);
		
		
		//요리대표사진 썸네일 등록 필요한데 이미지를 어떻게??? 
		String thumbnail = m.getParameter("thumbnail");

		//레시피등록 파라미터 추출
		String name = m.getParameter("recipe_name");			//레시피 이름
		String calorie = m.getParameter("calorie");				//칼로리
		String cookingTime = m.getParameter("cookingTime");		//조리시간
		String nation = m.getParameter("recipe_nation");		//레시피 국가
		String type = m.getParameter("recipe_type");			//레시피 분류
		String level = m.getParameter("recipe_level");			//레시피 난이도

		System.out.println("name = " + name);
		System.out.println("nation = " + nation);
		System.out.println("type = " + type);
		System.out.println("level = " + level);
		System.out.println("calorie = " + calorie);
		System.out.println("cookingTime = " + cookingTime);

		//유효성체크
		if(name.isEmpty() || calorie.isEmpty() || cookingTime.isEmpty() || nation.isEmpty() || type.isEmpty() || level.isEmpty()) {
			request.setAttribute("error", "레시피 정보의 모든 항목을 빠짐없이 입력해주시기 바랍니다!");
		}

		//DTO 객체에 데이터 바인딩 
		RecipeDTO recipe = new RecipeDTO(name, Integer.parseInt(calorie), Integer.parseInt(cookingTime), nation, type, level);

		//재료등록
		List<IngredientDTO> ingredientsList = new ArrayList<IngredientDTO>();
		String ingredientName [] = m.getParameterValues("ingredient_name");	//재료이름
		String seq  []= m.getParameterValues("ingredient_seq");				//재료순서
		String cacty [] = m.getParameterValues("ingredient_cacty");			//재료용량

		for(int i=0; i< ingredientName.length ; i++) {
			IngredientDTO ingredient = new IngredientDTO(0, 0, ingredientName[i], Integer.parseInt(seq[i]), cacty[i]);
			ingredientsList.add(ingredient);
		}

		System.out.println("ingredientsList : " + ingredientsList);

		
		//조리과정수정
		List<ProcessDTO> processList = new ArrayList<ProcessDTO>();
		String processUrl [] = m.getParameterValues("process_url"); 	//조리과정이미지 URL
		String processSeq [] = m.getParameterValues("process_seq"); 	//조리과정순서
		String desc [] = m.getParameterValues("process_desc");     		//조리과성설명
		String tip [] = m.getParameterValues("process_tip");			//조리과정팁

		for(int i=0; i< processUrl.length ; i++) {
			ProcessDTO process = new ProcessDTO(0, 0, processUrl[i], Integer.parseInt(processSeq[i]), desc[i], tip[i]);
			processList.add(process);
		}

		//이미지등록
		List<ImageDTO> imagesList = new ArrayList<ImageDTO>();
		String imageUrl = m.getParameter("image_url"); 	//이미지 URL
		String size = m.getParameter("image_size");		//이미지 크기

		ImageDTO image = new ImageDTO(0, imageUrl, 0, Integer.parseInt(size));
		imagesList.add(image);

		//파일 첨부가 되었다면...
		if(m.getFilesystemName("file")!=null) {
			//파일이름
			//	    	process.setImageUrl(m.getFilesystemName("file"));	//TODO Image를 Hash 값으로 변환하기
			image.setUrl(m.getFilesystemName("file"));
			//파일크기 
			image.setSize((int)m.getFile("file").length());
		}

		RecipeWrapper rw = new RecipeWrapper();
		//		rw.setPost(post);
		rw.setRecipe(recipe);
		rw.setIngredient(ingredientsList);
		rw.setProcess(processList);
		rw.setImages(imagesList);

		System.out.println("rw.getComments() : "+rw.getComments());
		//		System.out.println("rw.getComments() : "+rw.get);

		//Service 객체의 메소드 호출
		recipeService.insert(rw);
		
		return new ModelAndView("front", true);
	}

	/**
	 * 수정하기 폼 : 게시글의 게시판 유형이 레시피라면  
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("recipe/update.jsp");
	}

	/**
	 * 수정완료
	 * */
	public ModelAndView updateRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//레시피수정
		String name = request.getParameter("recipe_name");			//레시피 이름
		String calorie = request.getParameter("calorie");			//칼로리
		String cookingTime = request.getParameter("cookingTime");	//조리시간
		String nation = request.getParameter("recipe_nation");		//레시피 국가
		String type = request.getParameter("recipe_type");			//레시피 분류
		String level = request.getParameter("recipe_level");		//레시피 난이도

		RecipeDTO recipe = new RecipeDTO(name, Integer.parseInt(calorie), Integer.parseInt(cookingTime), nation, type, level);

		//재료수정
		String ingredientName = request.getParameter("ingredient_name");//재료이름
		String seq = request.getParameter("ingredient_seq");			//재료순서
		String cacty = request.getParameter("ingredient_cacty");		//재료용량

		IngredientDTO ingredient = new IngredientDTO(0, 0, ingredientName, Integer.parseInt(seq), cacty);
		List<IngredientDTO> ingredientList = new ArrayList<IngredientDTO>();

		String saveDir=request.getServletContext().getRealPath("/save/recipe");
		int maxSize = 1024*1024*100; //100M 
		String encoding="UTF-8";

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		//조리과정수정
		String processUrl = m.getParameter("process_url"); 	//조리과정이미지 URL
		String processSeq = m.getParameter("process_seq"); 	//조리과정순서
		String desc = m.getParameter("process_desc");     	//조리과성설명
		String tip = m.getParameter("process_tip");			//조리과정팁

		ProcessDTO process = new ProcessDTO(0, 0, processUrl, Integer.parseInt(processSeq), desc, tip);
		List<ProcessDTO> processList= new ArrayList<ProcessDTO>();

		//이미지수정
		String imageUrl = m.getParameter("image_url"); 	//이미지 URL
		String size = m.getParameter("image_size");		//이미지 크기

		ImageDTO image = new ImageDTO(0, imageUrl, 0, 0);
		List<ImageDTO> imageList= new ArrayList<ImageDTO>();

		//파일 첨부가 되었다면...
		if(m.getFilesystemName("file")!=null) {
			//파일이름
			process.setImageUrl(m.getFilesystemName("file"));//TODO Image를 Hash 값으로 변환하기
			image.setUrl(m.getFilesystemName("file"));
			//파일크기 
			image.setSize((int)m.getFile("file").length());
		}

		RecipeWrapper rw = new RecipeWrapper();
		rw.setRecipe(recipe);
		rw.setIngredient(ingredientList);
		rw.setProcess(processList);
		rw.setImages(imageList);

		recipeService.insert(rw);

		//수정이 완료되면 상세보기페이지로 이동한다.

		return new ModelAndView("recipe/read.jsp");
	}

}
