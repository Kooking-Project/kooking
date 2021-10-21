package com.kooking.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

import com.kooking.dao.AdminDAO;
import com.kooking.dao.AdminDAOImpl;
import com.kooking.dao.BoardDAO;
import com.kooking.dao.UserDAO;
import com.kooking.dao.UserDAOImpl;
import com.kooking.dto.BookmarkDTO;
import com.kooking.dto.CommentDTO;
import com.kooking.dto.PostDTO;
import com.kooking.dto.RecipeDTO;
import com.kooking.dto.UserDTO;
import com.kooking.dto.wrapper.RecipeWrapper;
import com.kooking.exception.KookingException;
import com.kooking.paging.Pagenation;

public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDAOImpl();
	private AdminDAO adminDao = new AdminDAOImpl();
	private BoardDAO boardDao = new BoardDAO(); 

	@Override
	public UserDTO loginCheck(String id, String pwd) throws SQLException, KookingException {
	    UserDTO userDTO = userDao.loginCheck(id,pwd);
	    if(userDTO==null)
	    	throw new KookingException("정보를 다시 확인해주세요.");

	    switch (userDTO.getStatus()) {
		case 1:
			throw new KookingException("활동 정지된 회원 입니다.");
		case 2:
			throw new KookingException("탈퇴한 회원 입니다.");
		}
        
		return userDTO;
	}

	@Override
	public void insert(UserDTO userDTO) throws SQLException, KookingException {
		if( userDao.idCheck(userDTO.getId())) {
			throw new SQLException("이미 등록된 아이디입니다.");
		}
		if( userDao.pwdCheck(userDTO.getPwd())) {
			throw new SQLException("비밀번호가 일치하지 않습니다.");
		}
		if( userDao.nicknameCheck(userDTO.getNickName())) {
			throw new SQLException("이미 등록된 닉네임입니다.");
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
	public Entry<List<RecipeWrapper>, Pagenation> postSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Entry<List<RecipeWrapper>, Pagenation> postList = userDao.postSelectByUserNo(userNo, page);
		if(postList==null)
			throw new KookingException("작성하신 게시물이 없습니다.");
		return postList;
	}

	@Override
	public Entry<List<CommentDTO>, Pagenation> commentSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Entry<List<CommentDTO>, Pagenation> commentList = userDao.commentSelectByUserNo(userNo, page);
		if(commentList==null)
			throw new KookingException("작성하신 댓글이 없습니다.");
		return commentList;
	}

	@Override
	public Entry<List<BookmarkDTO>, Pagenation> bookmarkSelectByUserNo(int userNo, Pagenation page) throws Exception {
		Entry<List<BookmarkDTO>, Pagenation> bookmarkList = userDao.bookmarkSelectByUserNo(userNo, page);
		if(bookmarkList==null)
			throw new KookingException("즐겨찾기 목록이 없습니다.");
		return bookmarkList;
	}

	@Override
	public void bookmarkInsert(int userNo, int postNo) throws Exception {
		if(userDao.bookmarkInsert(userNo, postNo)==0)
			throw new KookingException("즐겨찾기 추가를 실패했습니다.");
	}

	@Override
	public void bookmarkDelete(int userNo, int postNo) throws Exception {
		if(userDao.bookmarkDelete(userNo, postNo)==0)
			throw new KookingException("즐겨찾기 삭제를 실패했습니다.");
	}

	@Override
	public void changeUserStatus(UserDTO user) throws Exception {
		if(user.getStatus()!=2)
			throw new KookingException("입력된 값이 잘못 되었습니다.");
		if(adminDao.changeUserStatus(user)==0)
			throw new KookingException("탈퇴 되지 않았습니다.");
	}

	@Override
	public void postDelete(int userNo, int postNo) throws Exception {
		if(boardDao.deletePost(postNo, userNo, null)==0)
			throw new KookingException("게시물 삭제를 실패했습니다.");
	}

	@Override
	public void commentDelete(int userNo, int commentNo) throws Exception {
		if(boardDao.deleteComment(commentNo, userNo, null)==0)
			throw new KookingException("댓글 삭제를 실패했습니다.");
	}

	@Override
	public Entry<List<UserDTO>, Pagenation> userSelectAll(Pagenation page) throws Exception {
		Entry<List<UserDTO>, Pagenation> userList = adminDao.userSelectAll(page);
		if (userList==null)
			throw new KookingException("회원 정보가 없습니다.");
		return userList;
	}

	@Override
	public UserDTO userSelectByNo(int userNo) throws Exception {
		UserDTO user = adminDao.userSelectByNo(userNo);
		if (user==null)
			throw new KookingException("선택한 회원 정보가 없습니다.");
		return user;
	}

	@Override
	public Entry<List<PostDTO>, Pagenation> communitySelectByUserNo(int userNo, Pagenation page) throws Exception {
		Entry<List<PostDTO>, Pagenation> communityList = userDao.communitySelectByUserNo(userNo, page);
		if(communityList==null)
			throw new KookingException("작성하신 커뮤니티 게시물이 없습니다.");
		return communityList;
	}
}
