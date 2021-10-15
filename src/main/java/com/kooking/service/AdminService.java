package com.kooking.service;

import com.kooking.dto.UserDTO;

public interface AdminService {
	void changeUserStatus(int adminStatus, UserDTO user) throws Exception;
}
