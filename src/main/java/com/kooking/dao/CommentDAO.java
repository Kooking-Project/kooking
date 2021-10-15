package com.kooking.dao;

import com.kooking.dto.CommentDTO;

public interface CommentDAO {

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
