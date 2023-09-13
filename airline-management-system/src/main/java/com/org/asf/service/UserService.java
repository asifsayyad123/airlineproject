package com.org.asf.service;

import com.org.asf.dto.UserDTO;

public interface UserService {

	long register(UserDTO user);

	UserDTO login(String username, String password);
}
