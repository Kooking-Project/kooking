package com.kooking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.CommentDTO;
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

		// HttpSession session = request.getSession();
		// int userNo = (int) session.getAttribute("loginUserNo"); //회원번호

		// 닉네임 session에 넣어주면 jsp에서 조회 후 사용

		int type = Integer.parseInt(request.getParameter("type"));

		PostDTO dto = new PostDTO(0, type, 2/* userNo */, request.getParameter("title"),
				request.getParameter("content"), 0, "", "");

		int result = postService.insertPost(dto);
		request.setAttribute("result", result);


		// 결과에 따른 성공, 실패 나누기
		if (result != 0) {
			// 성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("board.jsp");
		} else {
			// 실패
			mv.setViewName("board.jsp");
		}

		// mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 게시글 수정 - 제목, 내용만 수정가능
	 */

	public ModelAndView updatePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// HttpSession session = request.getSession();
		// int userNo = (int)session.getAttribute("loginUserNo"); //회원번호

		// 수정하기 전 사용자 원래 게시글 정보 가져오는 메소드 호출해서 뿌려줄꺼임

		int type = Integer.parseInt(request.getParameter("type"));

		// int no, int postTypeNo, int userNo, String title, String contents, int
		// counts, String date

		PostDTO dto = new PostDTO(0, type, 2 /* userNo */ , request.getParameter("title"),
				request.getParameter("content"), 0, "", "");

		int result = postService.updatePost(dto);

		// 결과에 따른 성공, 실패 나누기
		if (result != 0) { // 성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 게시글 삭제 - 사용자가 활동 상태이며 관리자인 경우만 삭제 메소드 접근 가능 사용자가 자신이 쓴 글만 삭제버튼이 보이므로 게시글
	 * 번호로만 삭제한다.
	 */

	public ModelAndView deletePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// HttpSession session = request.getSession();
		// int userNo = (int)session.getAttribute("loginUserNo"); //회원번호

		int postNo = Integer.parseInt(request.getParameter("postNo")); // 게시물 번호

		int result = postService.deletePost(postNo, null);

		// 결과에 따른 성공, 실패 나누기
		if (result != 0) {
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 비회원, 회원 공통 사용자 닉네임이 들어간 postDTO & CommentDTO
	 */
	public ModelAndView selectPostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		int postNo = Integer.parseInt(request.getParameter("postNo")); // 게시물 번호

		PostDTO postDTO = postService.selectPostDetail(postNo); // 저장해야댐 - 사용자 닉네임 가져와야됨 - 추가
		
		List<CommentDTO> commentDTO = postService.selectComments(postNo); // 이거 어케쓸지.. 페이징 처리도 해야됨.

		// 결과에 따른 성공, 실패 나누기
		if (postDTO != null) { // 성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 전체 게시글 조회 - PostDTO <- postDTO에 사용자 닉네임 추가
	 */

	public ModelAndView selectPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<PostDTO> postList = postService.selectPost(); // 페이징 처리, 어떻게 쓸지 고민

		// 결과에 따른 성공, 실패 나누기
		if (postList != null) { // 성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */

	public ModelAndView selectPostDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<PostDTO> postList = postService.selectPostDate(); // 페이징 처리, 어떻게 쓸지 고민

		// 결과에 따른 성공, 실패 나누기
		if (postList != null) { // 성공 페이지로 이동? 아니면 팝업창?
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);
		return mv;
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */

	public ModelAndView selectPostType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		int postTypeNo = Integer.parseInt(request.getParameter("postTypeNo"));

		List<PostDTO> postList = postService.selectPostType(postTypeNo); // 페이징 처리, 어떻게 쓸지 고민

		// 결과에 따른 성공, 실패 나누기
		if (postList != null) { // 성공 페이지로 이동? 아니면 팝업창? 해당 게시물 없는 상태
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;

	}

	/**
	 * 게시판 조회순으로 조회
	 */
	public ModelAndView selectPostCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<PostDTO> postList = postService.selectPostCount(); // 페이징 처리, 어떻게 쓸지 고민

		// 결과에 따른 성공, 실패 나누기
		if (postList != null) { // 성공 페이지로 이동? 아니면 팝업창? 해당 게시물 없는 상태
			mv.setViewName("boardTest.jsp");
		} else { // 실패
			mv.setViewName("boardTest.jsp");
		}

		mv.setViewName("boardTest.jsp");
		mv.setRedirect(false);

		return mv;

	}

	/**
	 * 게시판 게시글 이름으로 검색
	 */
	/*
	 * public ModelAndView searchPostName(HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * String postName = request.getParameter("postName");
	 * 
	 * List<PostDTO> postList = postService.searchPostName(postName); // 페이징 처리, 어떻게
	 * 쓸지 고민
	 * 
	 * // 결과에 따른 성공, 실패 나누기 if (postList != null) { // 성공 페이지로 이동? 아니면 팝업창? 해당 게시물
	 * 없는 상태 mv.setViewName("boardTest.jsp"); } else { // 실패
	 * mv.setViewName("boardTest.jsp"); }
	 * 
	 * mv.setViewName("boardTest.jsp"); mv.setRedirect(false);
	 * 
	 * return mv; }
	 */

	/**
	 * 게시판 타입으로 검색 - 굳이?
	 */
	//public ModelAndView searchPostType(HttpServletRequest request, HttpServletResponse response) throws Exception {}

	// 밑에는 테스트용으로 사용했던거

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