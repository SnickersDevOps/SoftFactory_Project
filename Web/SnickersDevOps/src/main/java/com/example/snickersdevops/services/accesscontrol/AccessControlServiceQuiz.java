package com.example.snickersdevops.services.accesscontrol;

import com.example.snickersdevops.exсeptions.UnauthorizedActionException;
import com.example.snickersdevops.models.AuthenticatedUser;
import com.example.snickersdevops.models.Quiz;
import org.springframework.stereotype.Service;

@Service("AccessControlQuiz")
public class AccessControlServiceQuiz extends AccessControlServiceUserOwned<Quiz> {

	/*
	 * As long as the user is authenticated, it can create a Quiz.
	 */
	@Override
	public void canUserCreateObject(AuthenticatedUser user, Quiz object) throws UnauthorizedActionException {
		if (user == null) {
			throw new UnauthorizedActionException();
		}
	}

}
