package com.example.snickersdevops.services.usermanagement.token;

import com.example.snickersdevops.models.TokenModel;
import com.example.snickersdevops.models.TokenType;
import com.example.snickersdevops.models.User;
import org.springframework.scheduling.annotation.Async;

public interface TokenDeliverySystem {
	@Async
	void sendTokenToUser(TokenModel token, User user, TokenType tokenType);
}
