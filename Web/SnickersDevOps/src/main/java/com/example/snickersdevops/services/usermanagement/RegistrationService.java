package com.example.snickersdevops.services.usermanagement;


import com.example.snickersdevops.models.User;

public interface RegistrationService {
	User startRegistration(User user);

	User continueRegistration(User user, String token);

	boolean isRegistrationCompleted(User user);
}
