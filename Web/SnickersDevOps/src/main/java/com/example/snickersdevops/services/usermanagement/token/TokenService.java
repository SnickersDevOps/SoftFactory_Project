package com.example.snickersdevops.services.usermanagement.token;

import com.example.snickersdevops.exсeptions.InvalidTokenException;
import com.example.snickersdevops.models.TokenModel;
import com.example.snickersdevops.models.User;

import java.util.Date;

public interface TokenService<T extends TokenModel> {
	T generateTokenForUser(User user);

	void validateTokenForUser(User user, String token) throws InvalidTokenException;

	void invalidateToken(String token);

	void invalidateExpiredTokensPreviousTo(Date date);
}
