package com.kooking.service;

import com.kooking.dto.UserDTO;

public interface AdminService {
	void changeUserStatus(int adminStatus, UserDTO user) throws Exception;
	
	void commentDelete(int adminNo, int commentNo) throws Exception;

	void postDelete(int adminNo, int postNo) throws Exception;
}
