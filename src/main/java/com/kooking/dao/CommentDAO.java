package com.kooking.dao;

import java.util.List;

import com.kooking.dto.CommentDTO;

public interface CommentDAO {

	/**
	 * 게시글 번호에 해당하는 댓글 리스트 - 어디서 할지는 미정
	 */
	public List<CommentDTO> selectComments(int postNo) throws Exception;
	
	/**
	 * 댓글 추가
	 */
	public int insertComment(int UserNo);
	
	/**
	 * 댓글 수정
	 */
	public int updateComment(int UserNo, CommentDTO dto);
	
	/**
	 * 댓글 삭제 (댓글번호만 가져올까?)
	 */
	public int deleteComment(int UserNo, CommentDTO dto);
	
	/**
	 * 댓글 상태 확인 (댓글번호만 가져올까?)
	 */
	public int stateComment(CommentDTO dto);
}
