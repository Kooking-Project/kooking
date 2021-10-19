package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.util.DBTestUtil;

public class BoardDAO {
	/**
	 * 게시판 게시글 추가
	 */
	public int insertPost(PostDTO postDTO, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = 0;
		try {
			// String sql = proFile.getProperty("post.insertPost");
			// 게시글 번호빼고 저장
			st = con.prepareStatement("INSERT INTO POSTS(POST_NO,POST_TYPE_NO, USER_NO, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS, POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL,?,?,?,?,0,SYSDATE)");
			st.setInt(1, postDTO.getPostTypeNo());
			st.setInt(2, postDTO.getUserNo());
			st.setString(3, postDTO.getTitle());
			st.setString(4, postDTO.getContents());

			result = st.executeUpdate();
		}finally {
			
			if(isConnected) {
				DBTestUtil.dbClose(st, rs);
			}else {
				DBTestUtil.dbClose(con, st, rs);
			}
			
		}
		
		return result;

	}

	/**
	 * 게시판 게시글 수정 - 게시글 번호, 사용자 번호, 조회수, 게시글 타입, 조회수, 작성일 변경 불가
	 */
	public int updatePost(PostDTO post, Connection con) throws Exception {
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		
		int result = 0;
		PreparedStatement st = null;
		
		try {
			st = con.prepareStatement("UPDATE POSTS SET POST_TITLE=?, POST_CONTENTS=? WHERE USER_NO=? AND POST_NO=?");
			st.setString(1, post.getTitle());
			st.setString(2, post.getContents());
			st.setInt(3, post.getUserNo());
			st.setInt(4, post.getNo());
			result = st.executeUpdate();
		}finally {
			
			if(isConnected) {
				DBTestUtil.dbClose(st);
			}else {
				DBTestUtil.dbClose(con, st);
			}
			
		}
		return result;
	}

	/**
	 * 게시판 게시글 삭제 - 관리자도 하나씩 삭제
	 */
	public int deletePost(int postNo, Connection con) throws Exception { // 댓글도 같이 삭제되는지 확인
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement st = null;
		int result = 0;
		try {
			String sql = "DELETE FROM POSTS WHERE POST_NO=?";
			st = con.prepareStatement(sql);
			st.setInt(1, postNo);
			
			result = st.executeUpdate();
		}finally {
			if(isConnected) {
				DBTestUtil.dbClose(st);
			}else {
				DBTestUtil.dbClose(con, st);
			}
		}
		return result;
	}
	
	public List<CommentDTO> getComments(int postNo, Connection con) throws Exception{
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		List<CommentDTO> comments = new ArrayList<CommentDTO>();
		try {
			String sql = "SELECT COMMENT_NO, COMMENTS.USER_NO, USER_NICNAME, POST_NO, COMMENT_CONTENTS, COMMENT_DATE, COMMENT_TOP, COMMENT_DELETE_YN FROM COMMENTS, USERS WHERE COMMENTS.USER_NO = USERS.USER_NO AND POST_NO = ? ORDER BY COMMENT_DATE";
			//TODO : SQL USER_NICNAME 오타 확인
			st = con.prepareStatement(sql);
			st.setInt(1, postNo);
			rs = st.executeQuery();
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setNo(rs.getInt(1));
				comment.setUserNo(rs.getInt(2));
				comment.setUserNickName(rs.getString(3));
				comment.setPostNo(rs.getInt(4));
				comment.setDeleteYN(rs.getInt(8) == 0); // 0일 때 사용, 1일 때 삭제				
				comment.setContent(comment.isDeleteYN() ? rs.getString(5) : "삭제된 댓글입니다.");
				comment.setDate(rs.getString(6));
				comment.setTop(rs.getInt(7));
				comments.add(comment);
			}
			
		}finally {
			if(isConnected) {
				DBTestUtil.dbClose(st);
			}else {
				DBTestUtil.dbClose(con, st);
			}
		}
		return comments;
	}
	
	public int updateComments(CommentDTO comment, Connection con) throws Exception{
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		PreparedStatement st = null;
		int result = 0;
		try {
			String sql = "UPDATE COMMENTS SET COMMENT_CONTENTS=?  WHERE COMMENT_NO = ? AND USER_NO = ?";
			st = con.prepareStatement(sql);
			st.setString(1, comment.getContent());
			st.setInt(2, comment.getNo());
			st.setInt(3, comment.getUserNo());
			result = st.executeUpdate();
		}finally {
			if(isConnected) {
				DBTestUtil.dbClose(st);
			}else {
				DBTestUtil.dbClose(con, st);
			}
		}
		
		return result;
	}
	
	public int deleteComment(int commentNo, int userNo, Connection con) throws Exception{
		boolean isConnected = (con != null);
		if(!isConnected) {
			con = DBTestUtil.getConnection();
		}
		
		int result = 0;
		
		
		return result;
	}
	
	
	//게시글 하나 셀렉트, 조회수, 댓글>????
	//
	
}



