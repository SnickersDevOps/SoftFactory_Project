package com.example.snickersdevops.services.usermanagement.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenGeneratorUUID implements TokenGenerator {

	@Override
	public String generateRandomToken() {
		return UUID.randomUUID().toString();
	}

}
