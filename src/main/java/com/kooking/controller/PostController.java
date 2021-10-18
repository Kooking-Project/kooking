package com.kooking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.PostDTO;
import com.kooking.service.PostService;
import com.kooking.service.PostServiceImpl;

public class PostController implements Controller {
	
	private PostService postService = new PostServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자(사용자 번호), 날짜
	 */
	public ModelAndView insertPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		//HttpSession session = request.getSession();
		//int userNo = (int) session.getAttribute("loginUserNo"); //회원번호
		
		//닉네임 session에 넣어주면 jsp에서 조회 후 사용
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		PostDTO dto = new PostDTO(0, type, 2/*userNo*/, request.getParameter("title"),
				request.getParameter("content"), 0, "");
		
		int result = postService.insertPost(dto);
		
		//결과에 따른 성공, 실패 나누기
		if(result != 0) {
			//성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else {
			//실패
			mv.setViewName("boardTest.jsp");
		}
		
		//mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);
		
		return mv;
	}
	
	/**
	 * 게시판 게시글 수정
	 */
	public ModelAndView updatePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		// HttpSession session = request.getSession();
		// int userNo = (int) session.getAttribute("loginUserNo"); //회원번호
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		//int no, int postTypeNo, int userNo, String title, String contents, int counts, String date
		
		PostDTO dto = new PostDTO(0, type, 2/*userNo*/, request.getParameter("title"),
				request.getParameter("content"), 0, "");
		
		int result = postService.updatePost(dto);

		//결과에 따른 성공, 실패 나누기
		if(result != 0) {
			//성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else {
			//실패
			mv.setViewName("boardTest.jsp");
		}
		
		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;
	}
	
	
	
	
	
	
	
	
	
	public ModelAndView insertPost2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	
	/*
	 * public ModelAndView boardList(HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { ModelAndView mv = new ModelAndView(); String
	 * userNo = request.getParameter("userNo"); List<PostDTO> dto =
	 * boardService.boardList(userNo); request.setAttribute("boardDto", dto);
	 * 
	 * mv.setViewName("boardTest.jsp"); mv.setRedirect(false);
	 * 
	 * return mv; }
	 */
	}

	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("read 실행..");
		
		mv.setViewName("post.jsp");
		mv.setRedirect(true);
		
		return mv;
	}
	
	
}