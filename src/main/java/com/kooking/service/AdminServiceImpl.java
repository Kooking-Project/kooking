package com.kooking.service;

import java.util.List;

import com.kooking.dao.AdminDAO;
import com.kooking.dao.AdminDAOImpl;
import com.kooking.dao.BoardDAO;
import com.kooking.dto.UserDTO;
import com.kooking.exception.KookingException;

public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDao = new AdminDAOImpl();
	private BoardDAO boardDao = new BoardDAO();
	
	@Override
	public void changeUserStatus(int adminNo, UserDTO user) throws Exception {
		int result = 0;
		
		if(adminDao.checkUserStatues(adminNo)!=10)
			throw new KookingException("관리자가 아닙니다.");
		
		switch(user.getStatus()) {
			case 0:
				result = adminDao.changeUserStatus(user);
				break;
			case 1:
				result = adminDao.changeUserStatus(user);
				break;
			case 2:
				result = adminDao.changeUserStatus(user);
				break;
			case 10:	//일반 회원이 관리자가 될수 없다.
				throw new KookingException("입력된 값이 잘못 되었습니다.");
			default:	// 0,1,2 외의 값은 잘못된 값이다.
				throw new KookingException("입력된 값이 잘못 되었습니다.");
		}
		
		if(result==0)
			throw new KookingException("사용자 활동 상태가 변경되지 않았습니다.");
			
	}

	@Override
	public void commentDelete(int adminNo, int userNo, int commentNo) throws Exception {
		if(adminDao.checkUserStatues(adminNo)!=10)
			throw new KookingException("관리자가 아닙니다.");
		if(boardDao.deleteComment(commentNo, userNo, null)==0);
		throw new KookingException("게시글이 삭제되지 않았습니다.");
	}

	@Override
	public void postDelete(int adminNo, int userNo, int postNo) throws Exception {
		if(adminDao.checkUserStatues(adminNo)!=10)
			throw new KookingException("관리자가 아닙니다.");
		if(boardDao.deletePost(postNo, null)==0);	//유저 넘버 추가
			throw new KookingException("게시글이 삭제되지 않았습니다.");
		
	}

	@Override
	public List<UserDTO> userSelectAll(int adminNo) throws Exception {
		if(adminDao.checkUserStatues(adminNo)!=10)
			throw new KookingException("관리자가 아닙니다.");
		List<UserDTO> userList = adminDao.userSelectAll();
		if (userList==null)
			throw new KookingException("회원 정보가 없습니다.");
		return userList;
	}

}
