package com.kooking.service;

import java.sql.SQLException;
import java.util.List;

import com.kooking.dao.UserDAO;
import com.kooking.dao.UserDAOImpl;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDAOImpl();

	@Override
	public UserDTO loginCheck(String id, String pwd) throws SQLException, KookingException {
	    UserDTO userDTO = userDao.loginCheck(id,pwd);
        if(userDTO==null)
        	throw new KookingException("정보를 다시 확인해주세요.");
        
		return userDTO;
	}

	@Override
	public void insert(UserDTO userDTO) throws SQLException, KookingException {
		if( userDao.idCheck(userDTO.getId())) {
			throw new SQLException("아이디가 중복입니다.");
		}
		 if( userDao.insert(userDTO) == 0 )
			  throw new SQLException("등록되지 않았습니다.");
		
	}

	@Override
	public void userUpdate(UserDTO userDTO) throws Exception {
		if( userDao.userUpdate(userDTO) == 0 )
			throw new KookingException("회원정보가 수정되지 않았습니다.");
	}

	@Override
	public List<PostDTO> postSelectByUserNo(int userNo) throws Exception {
		List<PostDTO> postList = userDao.postSelectByUserNo(userNo);
		if(postList==null)
			throw new KookingException("작성하신 게시물이 없습니다.");
		return postList;
	}

	@Override
	public List<CommentDTO> commentSelectByUserNo(int userNo) throws Exception {
		List<CommentDTO> commentList = userDao.commentSelectByUserNo(userNo);
		if(commentList==null)
			throw new KookingException("작성하신 댓글이 없습니다.");
		return commentList;
	}

}
