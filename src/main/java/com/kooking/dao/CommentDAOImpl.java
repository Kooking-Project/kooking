package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.util.DbUtil;

public class CommentDAOImpl implements CommentDAO{

	String sql;
	
	/**
	 * 게시글 번호에 해당하는 댓글 리스트 - 어디서 할지는 미정
	 */
	@Override
	public List<CommentDTO> selectComments(int postNo) throws Exception{
		 Connection con = null; 
		  PreparedStatement st = null; 
		  ResultSet rs = null;
	  
		  List<CommentDTO> commentList = null;
		  
		  sql = "SELECT C.COMMENT_NO, C.USER_NO, C.POST_NO, C.COMMENT_CONTENTS, TO_CHAR(C.COMMENT_DATE, 'YYYYMMDD'), C.COMMENT_TOP, C.COMMENT_DELETE_YN, U.USER_NICNAME "
		  		+ "FROM COMMENTS C INNER JOIN USERS U ON C.USER_NO = U.USER_NO AND POST_NO=?";
	  
		  con = DbUtil.getConnection(); 
		  st = con.prepareStatement(sql); 
		  st.setInt(1,postNo);
		  
		  rs = st.executeQuery();
		  
		  //int no, int postNo, int userNo, int top, String content, String date, boolean deleteYN, String userNickName
		  
		  while(rs.next()) {
			  CommentDTO commentDTO = new CommentDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), 
					  rs.getString(6), 0 != rs.getInt(7), rs.getString(8));
			  commentList.add(commentDTO);
		  }

		  DbUtil.dbClose(con, st, rs);
	  
		  return commentList;
	}
	
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
