package com.kooking.dao;

import com.kooking.dto.CommentDTO;

public class CommentDAOImpl implements CommentDAO{

	/**
	 * 댓글 추가
	 */
	@Override
	public int insertComment(int UserNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 댓글 수정
	 */
	@Override
	public int updateComment(int UserNo, CommentDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 댓글 삭제 (댓글번호만 가져올까?)
	 */
	@Override
	public int deleteComment(int UserNo, CommentDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 댓글 상태 확인 (댓글번호만 가져올까?)
	 */
	@Override
	public int stateComment(CommentDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
