package com.kooking.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kooking.dao.BoardDAO;
import com.kooking.dao.CommentDAO;
import com.kooking.dao.CommentDAOImpl;
import com.kooking.dao.PostDAO;
import com.kooking.dao.PostDAOImpl;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.exception.KookingException;

public class PostServiceImpl implements PostService {
	private PostDAO postDAO = new PostDAOImpl();
	private BoardDAO boardDAO = new BoardDAO();
	private CommentDAO commentDAO = new CommentDAOImpl();
	
	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자(사용자 번호), 날짜
	 */
	public int insertPost(PostDTO postDTO) throws Exception {
		int result = 0;
		
		result = boardDAO.insertPost(postDTO, null);
		
		if(result == 0)
		{
			throw new KookingException("게시물이 안들어갔어....");
		}

		return result;
	}
	
	/**
	 * 게시판 게시글 수정 - 사용자가 수정할 게시글의 정보가 필요하다. 
	 */
	@Override
	public int updatePost(PostDTO postDTO) throws Exception {
		int result = 0;
		
		result = boardDAO.updatePost(postDTO, null);
		
		return result;
	}

	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제
	 */
	@Override
	public int deletePost(int postNo, Connection con) throws Exception {
		int result = 0;
		
		result = boardDAO.deletePost(postNo, null);
		
		return result;
	}

	/**
	 * 게시판 클릭했을 때 해당 게시물 하나보여주기 - 게시글, 댓글, 사용자 닉네임, 어케가져올지 생각해
	 */
	public PostDTO selectPostDetail(int postNo) throws Exception {
		PostDTO postDTO=null;
		
		int result = postDAO.postViewCount(postNo);
		
		if(result != 0) {
			postDTO = postDAO.selectPostDetail(postNo);
		} else {
			//에러메세지
		}

		return postDTO;
	}
	
	/**
	 * 게시글에 해당하는 전체 댓글 조회
	 */
	@Override
	public List<CommentDTO> selectComments(int postNo) throws Exception {
		
		//어디서 만들진 모르겠지만 게시물 번호에 해당하는 commentDTO를 가져온다. 임시로 select에 연결
		List<CommentDTO> commentList = commentDAO.selectComments(postNo); 
		
		return commentList;
	}

	/**
	 * 게시판 전체 게시글 조회 - 사용자 닉네임 어떻게 보여줄 지 & 페이징 처리
	 */
	@Override
	public List<PostDTO> selectPost() throws Exception {
		
		List<PostDTO> postDTO = postDAO.selectPost();

		return postDTO;
	}

	/**
	 * 게시판 게시글 날짜별 조회(최신순)
	 */
	@Override
	public List<PostDTO> selectPostDate() throws SQLException {
		List<PostDTO> postDTO = postDAO.selectPostDate();
		
		return postDTO;
	}

	/**
	 * 게시판 게시글 타입별 조회
	 */
	@Override
	public List<PostDTO> selectPostType(int postTypeNo) throws SQLException {
		List<PostDTO> postDTO = postDAO.selectPostType(postTypeNo);
		
		return postDTO;
	}

	/**
	 * 게시판 조회수별 조회
	 */
	@Override
	public List<PostDTO> selectPostCount() throws Exception {
		List<PostDTO> postDTO = postDAO.selectPostCount();
		
		return postDTO;
	}

	/**
	 * 게시판 게시글 이름으로 검색
	 */
	@Override
	public List<PostDTO> searchPostName(String postTitle) throws SQLException {
		List<PostDTO> postDTO = postDAO.searchPostName(postTitle);
		/*
		 * List<PostDTO> selectPostDTO;
		 * 
		 * for (PostDTO post : postDTO) { int num = post.getPostTypeNo(); switch() }
		 */
		return postDTO;
	}

	/**
	 * 게시판 타입으로 검색  - 굳이?
	 */
	@Override
	public List<PostDTO> searchPostType(String postType) throws SQLException {
		List<PostDTO> postDTO = null;
		
		return null;
	}

	//테스트용
	@Override
	public List<PostDTO> boardList(String userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
}
