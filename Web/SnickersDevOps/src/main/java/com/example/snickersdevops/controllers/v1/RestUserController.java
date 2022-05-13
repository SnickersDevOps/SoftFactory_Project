package com.example.snickersdevops.controllers.v1;

import com.example.snickersdevops.controllers.WebUserController;
import com.example.snickersdevops.models.AuthenticatedUser;
import com.example.snickersdevops.models.Quiz;
import com.example.snickersdevops.models.User;
import com.example.snickersdevops.services.QuizService;
import com.example.snickersdevops.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestUserController.ROOT_MAPPING)
public class RestUserController {

	public static final String ROOT_MAPPING = "/api/users";
	private static final Logger logger = LoggerFactory.getLogger(WebUserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = "/{user_id}", method = RequestMethod.DELETE)
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long user_id) {

		userService.delete(user_id);
	}

	@RequestMapping(value = "/{user_id}/quizzes", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public Page<Quiz> getQuizzesByUser(Pageable pageable, @PathVariable Long user_id) {
		logger.debug("Requested page " + pageable.getPageNumber() + " from user " + user_id);
		
		User user = userService.find(user_id);
		return quizService.findQuizzesByUser(user, pageable);
	}

	@RequestMapping(value = "/login")
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public User login(@AuthenticationPrincipal AuthenticatedUser authenticatedUser) {
		logger.debug("Logged in as " + authenticatedUser.getUsername());
		return authenticatedUser.getUser();
	}

	@RequestMapping(value = "/myQuizzes", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public Page<Quiz> getQuizzesByCurrentUser(@AuthenticationPrincipal AuthenticatedUser authenticatedUser,
			Pageable pageable) {
		logger.debug("Requested page " + pageable.getPageNumber() + " from user " + authenticatedUser.getUsername());
		
		return getQuizzesByUser(pageable, authenticatedUser.getId());
	}

}
