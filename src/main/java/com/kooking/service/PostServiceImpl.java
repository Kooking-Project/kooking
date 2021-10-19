package com.kooking.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kooking.dao.BoardDAO;
import com.kooking.dao.PostDAO;
import com.kooking.dao.PostDAOImpl;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;

public class PostServiceImpl implements PostService {
	private PostDAO dao = new PostDAOImpl();
	private BoardDAO boardDAO = new BoardDAO();
	
	/**
	 * 게시판 게시글 추가 - 제목, 내용, 작성자(사용자 번호), 날짜
	 */
	public int insertPost(PostDTO postDTO) throws Exception {
		int result = 0;
		
		result = boardDAO.insertPost(postDTO, null);

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
		
		int result = dao.postViewCount(postNo);
		
		if(result != 0) {
			postDTO = dao.selectPostDetail(postNo);
		} else {
			//에러메세지
		}

		return postDTO;
	}

	/**
	 * 게시판 전체 게시글 조회 - 사용자 닉네임 어떻게 보여줄 지 & 페이징 처리
	 */
	@Override
	public List<PostDTO> selectPost() throws Exception {
		
		List<PostDTO> postDTO = dao.selectPost(); //여기서 댓글이랑 

		return postDTO;
	}

	@Override
	public List<PostDTO> selectPostDate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> selectPostType(int postTypeNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> selectPostCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> searchPostName(String postTitle) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> searchPostType(String postType) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> boardList(String userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
