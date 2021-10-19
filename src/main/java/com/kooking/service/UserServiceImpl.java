package com.kooking.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dao.AdminDAO;
import com.kooking.dao.AdminDAOImpl;
import com.kooking.dao.UserDAO;
import com.kooking.dao.UserDAOImpl;
import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDAOImpl();
	private AdminDAO adminDao = new AdminDAOImpl();

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
		if(userDao.loginCheck(userDTO.getId(), userDTO.getPwd())==null)
			throw new KookingException("비밀번호가 틀렸습니다.");
		if( userDao.userUpdate(userDTO) == 0 )
			throw new KookingException("회원정보가 수정되지 않았습니다.");
	}
	@Override
	public void userUpdate(UserDTO userDTO, String pwd) throws Exception {
		if(userDao.loginCheck(userDTO.getId(), pwd)==null)
			throw new KookingException("이전 비밀번호가 틀렸습니다.");
		if( userDao.userUpdate(userDTO) == 0 )
			throw new KookingException("회원정보가 수정되지 않았습니다.");
	}

	@Override
	public Entry<PostDTO, RecipeDTO> postSelectByUserNo(int userNo) throws Exception {
		Entry<PostDTO, RecipeDTO> postList = userDao.postSelectByUserNo(userNo);
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

	@Override
	public List<BookmarkDTO> bookmarkSelectByUserNo(int userNo) throws Exception {
		List<BookmarkDTO> bookmarkList = userDao.bookmarkSelectByUserNo(userNo);
		if(bookmarkList==null)
			throw new KookingException("즐겨찾기 목록이 없습니다.");
		return bookmarkList;
	}

	@Override
	public void bookmarkInsert(int userNo, int postNo) throws Exception {
		if(userDao.bookmarkInsert(userNo, postNo)==0)
			throw new KookingException("즐겨찾기 추가가 실패했습니다.");
	}

	@Override
	public void bookmarkDelete(int userNo, int postNo) throws Exception {
		if(userDao.bookmarkDelete(userNo, postNo)==0)
			throw new KookingException("즐겨찾기 삭제가 실패했습니다.");
	}

	@Override
	public void changeUserStatus(UserDTO user) throws Exception {
		if(user.getStatus()!=2)
			throw new KookingException("입력된 값이 잘못 되었습니다.");
		if(adminDao.changeUserStatus(user)==0)
			throw new KookingException("탈퇴 되지 않았습니다.");
		
	}
}
