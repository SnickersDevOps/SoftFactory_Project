package com.example.snickersdevops.services.usermanagement;

import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.usermanagement.token.TokenDeliverySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private UserService userService;
	private TokenDeliverySystem tokenDeliveryService;

	@Autowired
	public UserManagementServiceImpl(UserService userService,
			TokenDeliverySystem tokenDeliveryService) {
		this.tokenDeliveryService = tokenDeliveryService;
		this.userService = userService;
	}

}
