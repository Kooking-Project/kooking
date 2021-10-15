package com.kooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.util.DBTestUtil;

public class RecipeDAOImpl implements RecipeDAO {

	@Override
	public int insert(RecipeWrapper recipe) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RecipeWrapper recipe) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String SQL = "UPDATE POSTS SET POST_TITLE='테스트 ㅇㅇㅇㅇ' WHERE POST_NO=1;";

			System.out.println("커넥션 진입");
			con = DBTestUtil.getConnection();
			System.out.println("커넥션 완료");
			ps = con.prepareStatement(SQL);
			System.out.println("UPDATE 진입");
			result = ps.executeUpdate();
			System.out.println("UPDATE 실행");
			System.out.println(result);

		return result;
	}

	@Override
	public int delete(int no, int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			System.out.println("커넥션 진입");
			con = DBTestUtil.getConnection();
			System.out.println("커넥션 완료");
			ps = con.prepareStatement("DELETE FROM POSTS WHERE POST_NO = ? AND USER_NO = ?");
			ps.setInt(1, no);
			ps.setInt(2, userNo);
			
			System.out.println("딜리트 진입");
			result = ps.executeUpdate();
			System.out.println("결과 : " + result);
		}finally {
			DBTestUtil.dbClose(ps, con);
		}
		return result;
		
	}
	

	public static void main(String[] args){
		RecipeDAO recipeDAO = new RecipeDAOImpl();
		System.out.println("112312");
		
		int r = 0;
		try {
			r = recipeDAO.delete(1, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r);
	}
}
