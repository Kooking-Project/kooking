package com.kooking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.paging.Pagenation;
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
		//int userNo = (int) session.getAttribute("userDTO"); //회원번호
		int userNo = 2;
		
		// 닉네임 session에 넣어주면 jsp에서 조회 후 사용

		//int type = Integer.parseInt(request.getParameter("boardCategory")); 안들어와..
		int type=3;
		//int user = Integer.parseInt(request.getParameter("user"));
		String title = request.getParameter("title");
		
		if(title==null) {
			//title="가나다라맙사";
			System.out.println("title 널");
		}
		
		String contents = request.getParameter("contents");
		
		if(contents==null) {
			//contents="아자차카타파하";
			System.out.println("contents 널");
		}
		
		//String nickName = request.getParameter("nickName");
		String nickName = "박성하";
		
		//int postTypeNo, int userNo, String title, String contents, int counts, String userNicname
		
		// 사용자는 session 번호 알아내면 넣기
		PostDTO dto = new PostDTO(type, userNo, title, contents, 0, nickName);

		int result = postService.insertPost(dto);
		if(result == 0) {
			System.out.println("0임");
		}
		
		mv.setViewName("front?key=post&methodName=selectPost");

		// mv.setViewName("boardTest.jsp");
		mv.setRedirect(true);

		return mv;
	}

	/**
	 * 기존 게시글 하나만 조회 - 수정용
	 */
	public ModelAndView selectBeforePost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		int postNo = Integer.parseInt(request.getParameter("postNo"));
		//int postNo = 75;

		PostDTO beforeDTO = postService.selectPostDetail(postNo); // 수정하기전 사용자 기존 게시글 정보

		/*
		 * private int no; //게시글 번호 private int postTypeNo; //게시글 타입 private int userNo;
		 * //사용자 번호 (작성자) private String title; //게시글 제목 private String contents; //게시글
		 * 내용 private int counts; //게시글 조회수 private String date; //게시글 작성일 private
		 * String userNicname; //사용자 닉네임
		 */		
		request.setAttribute("beforePostDTO", beforeDTO);
		request.setAttribute("beforeTitle", beforeDTO.getTitle());

		mv.setViewName("board/boardUpdate.jsp");
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

		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int type = Integer.parseInt(request.getParameter("type"));
		int user = Integer.parseInt(request.getParameter("user"));

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String nickName = request.getParameter("nickName");

		// int no, int postTypeNo, int userNo, String title, String contents, int
		// counts, String date, String userNicname

		PostDTO dto = new PostDTO(postNo, type, user, title, contents, 0, "", nickName);

		int result = postService.updatePost(dto);

		mv.setViewName("front?key=post&methodName=selectPostDetail&postNo="+postNo);
		// front?key=post&methodName=selectPost

		mv.setRedirect(true);

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

		int postNo;
		if(request.getParameter("postNo") == null || request.getParameter("postNo") == "") {
			postNo = 3;
		} else {
			postNo = Integer.parseInt(request.getParameter("postNo"));
		}
		
		int user;
		if(request.getParameter("user") == null || request.getParameter("user") == "") {
			user=3;
		} else {
			user = Integer.parseInt(request.getParameter("user"));
		}
		
		int result = postService.deletePost(postNo, user, null); // 이거는 좀 고민...

		System.out.println("삭제완료?");
		mv.setViewName("front?key=post&methodName=selectPost");
		mv.setRedirect(true);

		return mv;
	}

	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 비회원, 회원 공통 사용자 닉네임이 들어간 postDTO & CommentDTO - 확인
	 */
	public ModelAndView selectPostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		int postNo = Integer.parseInt(request.getParameter("postNo")); // 게시물 번호
		
		PostDTO postDTO = postService.selectPostDetail(postNo);

		request.setAttribute("postDTO", postDTO);

		List<CommentDTO> commentDTO = postService.selectComments(postNo); // 이거 어케쓸지
		request.setAttribute("commentDTO", commentDTO);

		mv.setViewName("board/boardRead.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 전체 게시글 조회 - PostDTO <- postDTO에 사용자 닉네임 추가
	 */

	public ModelAndView selectPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		String pageSize = request.getParameter("pageSize"); // 한 페이지에 보여질 게시글 수
		String pageNo = request.getParameter("pageNo"); // 현재 페이지
		Pagenation page = new Pagenation();

		if (pageSize != null)
			page.setPageSize(Integer.parseInt(pageSize));
		if (pageNo != null)
			page.setPageNo(Integer.parseInt(pageNo));

		Entry<List<PostDTO>, Pagenation> entry = postService.selectPost(page);
		request.setAttribute("postList", entry.getKey());
		request.setAttribute("p", entry.getValue());

		// 결과에 따른 성공, 실패 나누기

		mv.setViewName("board/board.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */

	public ModelAndView selectPostDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		String pageSize = request.getParameter("pageSize"); // 한 페이지에 보여질 게시글 수
		String pageNo = request.getParameter("pageNo"); // 현재 페이지
		Pagenation page = new Pagenation();

		if (pageSize != null)
			page.setPageSize(Integer.parseInt(pageSize));
		if (pageNo != null)
			page.setPageNo(Integer.parseInt(pageNo));

		Entry<List<PostDTO>, Pagenation> entry = postService.selectPostDate(page);
		request.setAttribute("postList", entry.getKey());
		request.setAttribute("page", entry.getValue());

		mv.setViewName("board/board.jsp");
		mv.setRedirect(false);
		return mv;
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */

	public ModelAndView selectPostType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		int postTypeNo = Integer.parseInt(request.getParameter("postTypeNo"));

		String pageSize = request.getParameter("pageSize"); // 한 페이지에 보여질 게시글 수
		String pageNo = request.getParameter("pageNo"); // 현재 페이지
		Pagenation page = new Pagenation();

		if (pageSize != null)
			page.setPageSize(Integer.parseInt(pageSize));
		if (pageNo != null)
			page.setPageNo(Integer.parseInt(pageNo));

		Entry<List<PostDTO>, Pagenation> entry = postService.selectPostType(page, postTypeNo);
		request.setAttribute("postList", entry.getKey());
		request.setAttribute("page", entry.getValue());

		mv.setViewName("front?key=post&methodName=selectPostType");
		mv.setRedirect(false);

		return mv;

	}

	/**
	 * 게시판 조회순으로 조회
	 */
	public ModelAndView selectPostCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		String pageSize = request.getParameter("pageSize"); // 한 페이지에 보여질 게시글 수
		String pageNo = request.getParameter("pageNo"); // 현재 페이지
		Pagenation page = new Pagenation();

		if (pageSize != null)
			page.setPageSize(Integer.parseInt(pageSize));
		if (pageNo != null)
			page.setPageNo(Integer.parseInt(pageNo));

		Entry<List<PostDTO>, Pagenation> entry = postService.selectPostCount(page);
		request.setAttribute("postList", entry.getKey());
		request.setAttribute("page", entry.getValue());

		mv.setViewName("board/board.jsp");
		mv.setRedirect(false);

		return mv;

	}

	/**
	 * 게시판 게시글 이름으로 검색
	 */

	public ModelAndView searchPostName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		String postName = request.getParameter("search-container");

		String pageSize = request.getParameter("pageSize"); // 한 페이지에 보여질 게시글 수
		String pageNo = request.getParameter("pageNo"); // 현재 페이지
		Pagenation page = new Pagenation();

		if (pageSize != null)
			page.setPageSize(Integer.parseInt(pageSize));
		if (pageNo != null)
			page.setPageNo(Integer.parseInt(pageNo));

		Entry<List<PostDTO>, Pagenation> entry = postService.searchPostName(page, postName);
		request.setAttribute("postList", entry.getKey());
		request.setAttribute("page", entry.getValue());

		mv.setViewName("board/board.jsp");
		mv.setRedirect(false);

		return mv;
	}
	
//----------------------------------------------------------------------------------------------------------------

	/**
	 * 댓글 추가 - 회원이거나 관리자(?)일 때 댓글 추가 메소드 접근가능.
	 */

	public ModelAndView insertComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// HttpSession session = request.getSession();
		// int userNo = (int) session.getAttribute("loginUserNo"); //회원번호

		String user = request.getParameter("user");
		String postNo = request.getParameter("postNo");
		String top = request.getParameter("top");
		String comments = request.getParameter("comments"); //널이 안들어갈꺼라서 상관 없지 않나?
		
		int topNullCheck;

		if (user == null || user=="") {
			user = "2";
			System.out.println("userNull");
		}
		if (postNo == null|| postNo=="") {
			//postNo = "14";
			System.out.println("postNoNull");
		}
		if (comments == null|| comments=="") {
			//comments = "하이염";
			System.out.println("comments");
		}
		
		if (top==null || top == "") {
			topNullCheck = -1;
		} else {
			topNullCheck = Integer.parseInt(top);
		}
		
		// int no, int postNo, int userNo, int top, String content, String date, boolean
		// deleteYN

		// 사용자는 session 번호 알아내면 넣기
		CommentDTO dto = new CommentDTO(0, Integer.parseInt(postNo), Integer.parseInt(user), topNullCheck, comments, "", true);

		int result = postService.insertComment(dto);
		if(result == 0) {
			System.out.println(0);
		}

		mv.setViewName("front?key=post&methodName=selectPostDetail&postNo=" + postNo);
		// mv.setViewName("front?key=post&methodName=selectPostDetail&postNo=" +
		// postNo);
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 댓글 하나만 조회 - 수정용
	 */
	public ModelAndView updateBeforeComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		// HttpSession session = request.getSession();
		// int userNo = (int)session.getAttribute("loginUserNo"); //회원번호

		int commentNo = Integer.parseInt(request.getParameter("commentNo")); // 게시물 번호
		int top = Integer.parseInt(request.getParameter("top")); // 상위

		CommentDTO beforeDTO = postService.stateComment(commentNo); // 수정하기전 사용자 기존 게시글 정보

		request.setAttribute("beforeCommentDTO", beforeDTO);

		mv.setViewName("board/boardRead.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 댓글 수정
	 */
	public ModelAndView updateComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// HttpSession session = request.getSession();
		// int userNo = (int)session.getAttribute("loginUserNo"); //회원번호

		int commentNo = Integer.parseInt(request.getParameter("commentNo")); // 게시물 번호
		int user = Integer.parseInt(request.getParameter("user")); // 사용자 번호
		int top = Integer.parseInt(request.getParameter("top")); // 상위 댓글 번호

		// int no, int postNo, int userNo, int top, String content, String date,
		// boolean deleteYN

		// 사용자는 session 번호 알아내면 넣기
		CommentDTO dto = new CommentDTO(commentNo, 0, user, top, request.getParameter("content"), "", true);

		int result = postService.updateComment(dto);

		mv.setViewName("boardRead.jsp");
		mv.setRedirect(false);

		return mv;
	}

	/**
	 * 댓글 삭제 - 상태만 바꾸는거 - 사용자가 관리자인지 구분하는 기준이 필요 그냥 관리자의 유저번호는 의미 없음
	 */
	public ModelAndView deleteComment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		// HttpSession session = request.getSession();
		// int userNo = (int)session.getAttribute("loginUserNo"); //회원번호

		int commentNo = Integer.parseInt(request.getParameter("commentNo")); // 게시물 번호
		int user = Integer.parseInt(request.getParameter("user")); // 사용자 번호

		int result = postService.deleteComment(user, commentNo);

		mv.setViewName("boardRead.jsp");
		mv.setRedirect(false);

		return mv;
	}

}