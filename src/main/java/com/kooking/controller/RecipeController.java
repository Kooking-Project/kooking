package com.kooking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.ImageDTO;
import com.kooking.dto.IngredientDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.ProcessDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;
import com.kooking.service.PostService;
import com.kooking.service.PostServiceImpl;
import com.kooking.service.RecipeSelectService;
import com.kooking.service.RecipeSelectServiceImpl;
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
	private RecipeSelectService selectService = new RecipeSelectServiceImpl();
	
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
		String saveDir=request.getServletContext().getRealPath("/save/recipe"); //a.jpg ,a1.jpg, a2.jpg 
		int maxSize = 1024*1024*100; //100M 
		String encoding="UTF-8";

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		UserDTO user = (UserDTO)(request.getSession().getAttribute("userDTO"));
		
		//게시글 등록 insertPost() 에서 ??
		String title = m.getParameter("post_title"); //레시피제목
		String contents = m.getParameter("post_content"); //요리소개

		PostDTO post = new PostDTO();
		post.setTitle(title);
		post.setContents(contents);
		post.setPostTypeNo(1);
		post.setUserNo(user.getNo());
		post.setUserNicname(user.getNickName());
		
		System.out.println("post_title = " + title);
		System.out.println("post_content = " + contents);
		
		//레시피등록 파라미터 추출
		String name = m.getParameter("recipe_name");			//레시피 이름
		String calorie = m.getParameter("calorie");				//칼로리
		String cookingTime = m.getParameter("cookingTime");		//조리시간
		String nation = m.getParameter("recipe_nation");		//레시피 국가
		String type = m.getParameter("recipe_type");			//레시피 분류
		String level = m.getParameter("recipe_level");			//레시피 난이도
		String thumbnail = m.getFilesystemName("recipe_thumbnail");  //레시피 대표이미지

		System.out.println("name = " + name);
		System.out.println("nation = " + nation);
		System.out.println("type = " + type);
		System.out.println("level = " + level);
		System.out.println("calorie = " + calorie);
		System.out.println("cookingTime = " + cookingTime);
		System.out.println("thumbnail = " + thumbnail);

		//DTO 객체에 데이터 바인딩 
		RecipeDTO recipe = new RecipeDTO(name, Integer.parseInt(calorie), Integer.parseInt(cookingTime), nation, type, level, thumbnail);

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
	
		//조리과정등록
		List<ProcessDTO> processList = new ArrayList<ProcessDTO>();

		String processSeq [] = m.getParameterValues("process_seq"); 	//조리과정순서
		String desc [] = m.getParameterValues("process_desc");     		//조리과성설명
		String tip [] = m.getParameterValues("process_tip");			//조리과정팁
		
		for(int i=0; i< processSeq.length ; i++) {
			String processUrl = m.getFilesystemName("process_url"+i); 	//조리과정이미지 URL  process_url1
			System.out.println("processUrl = " + processUrl);
			
			ProcessDTO process = new ProcessDTO(0, 0, processUrl, Integer.parseInt(processSeq[i]), desc[i], tip[i]);
			processList.add(process);
		}
		
		System.out.println("processList = " + processList);

//		//이미지등록
//		List<ImageDTO> imagesList = new ArrayList<ImageDTO>();
//		String imageUrl = m.getParameter("image_url"); 	//이미지 URL
//		String size = m.getParameter("image_size");		//이미지 크기
//
//		ImageDTO image = new ImageDTO(0, imageUrl, 0, Integer.parseInt(size));
//		imagesList.add(image);
//
//		//파일 첨부가 되었다면...
//		if(m.getFilesystemName("file")!=null) {
//			//파일이름
//			//	    	process.setImageUrl(m.getFilesystemName("file"));	//TODO Image를 Hash 값으로 변환하기
//			image.setUrl(m.getFilesystemName("file"));
//			//파일크기 
//			image.setSize((int)m.getFile("file").length());
//		}

		RecipeWrapper rw = new RecipeWrapper();
		rw.setPost(post);
		rw.setRecipe(recipe);
		rw.setIngredient(ingredientsList);
		rw.setProcess(processList);
//		rw.setImages(imagesList);

		//Service 객체의 메소드 호출
		recipeService.insert(rw);
		
		return new ModelAndView("front?key=search&methodName=list", true);
	}

	/**
	 * 수정하기 폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int postNo = Integer.parseInt(request.getParameter("postNo")); 
//		int userNo = Integer.parseInt(request.getParameter("userNo")); 
		
		RecipeWrapper wrapper = selectService.search(postNo);
		
//		if(((UserDTO)(request.getSession().getAttribute("userDTO"))).getNo()!=userNo) {
//			throw new KookingException("게시글 작성자가 아닙니다.");
//		}
		System.out.println("postNo : " + postNo);
//		System.out.println("userNo : " + userNo);
		
		request.setAttribute("search", wrapper);
		
		//http://localhost:8000/kooking/front?key=recipe&methodName=updateForm&postNo=13
		//http://localhost:8000/kooking/recipe/update.jsp
		return new ModelAndView("recipe/receipeUpdate.jsp");
	}

	/**
	 * 수정하기 : 파일 첨부를 제외한 수정??
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveDir=request.getServletContext().getRealPath("/save/recipe"); //a.jpg ,a1.jpg, a2.jpg 
		int maxSize = 1024*1024*100; //100M 
		String encoding="UTF-8";

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		UserDTO user = (UserDTO)(request.getSession().getAttribute("userDTO"));
		
		String title = m.getParameter("post_title"); //레시피제목
		String contents = m.getParameter("post_content"); //요리소개

		PostDTO post = new PostDTO();
		post.setTitle(title);
		post.setContents(contents);
		post.setPostTypeNo(1);
		post.setUserNo(user.getNo());
		post.setUserNicname(user.getNickName());
		
		System.out.println("post_title = " + title);
		System.out.println("post_content = " + contents);
		
		//레시피수정 파라미터 추출
		String name = m.getParameter("recipe_name");			//레시피 이름
		String calorie = m.getParameter("calorie");				//칼로리
		String cookingTime = m.getParameter("cookingTime");		//조리시간
		String nation = m.getParameter("recipe_nation");		//레시피 국가
		String type = m.getParameter("recipe_type");			//레시피 분류
		String level = m.getParameter("recipe_level");			//레시피 난이도
		String thumbnail = m.getFilesystemName("recipe_thumbnail");  //레시피 대표이미지

		System.out.println("name = " + name);
		System.out.println("nation = " + nation);
		System.out.println("type = " + type);
		System.out.println("level = " + level);
		System.out.println("calorie = " + calorie);
		System.out.println("cookingTime = " + cookingTime);
		System.out.println("thumbnail = " + thumbnail);

		//DTO 객체에 데이터 바인딩 
		RecipeDTO recipe = new RecipeDTO(name, Integer.parseInt(calorie), Integer.parseInt(cookingTime), nation, type, level, thumbnail);

		//재료수정
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

		String processSeq [] = m.getParameterValues("process_seq"); 	//조리과정순서
		String desc [] = m.getParameterValues("process_desc");     		//조리과성설명
		String tip [] = m.getParameterValues("process_tip");			//조리과정팁
		
		for(int i=0; i< processSeq.length ; i++) {
			String processUrl = m.getFilesystemName("process_url"+i); 	//조리과정이미지 URL  process_url1
			System.out.println("processUrl = " + processUrl);
			
			ProcessDTO process = new ProcessDTO(0, 0, processUrl, Integer.parseInt(processSeq[i]), desc[i], tip[i]);
			processList.add(process);
		}
		
		System.out.println("processList = " + processList);

		RecipeWrapper rw = new RecipeWrapper();
		rw.setPost(post);
		rw.setRecipe(recipe);
		rw.setIngredient(ingredientsList);
		rw.setProcess(processList);

		//Service 객체의 메소드 호출
		recipeService.update(rw);

		//수정이 완료되면 레시피상세보기 페이지로 간다?

		
		return new ModelAndView("front?key=search&methodName=", true);
	}

}
