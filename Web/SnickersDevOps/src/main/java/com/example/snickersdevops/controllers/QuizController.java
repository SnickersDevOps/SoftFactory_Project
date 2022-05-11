//package com.example.snickersdevops.controllers;
//
//import com.example.snickersdevops.models.*;
//import com.example.snickersdevops.services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.web.*;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class QuizController {
//
//	@Autowired
//	QuizService quizService;
//
//	@Autowired
//	QuestionService questionService;
//
//	@Autowired
//	UserService userService;
////
////	@Autowired
////	AccessControlService<Quiz> accessControlServiceQuiz;
////
////	@Autowired
////	AccessControlService<Question> accessControlServiceQuestion;
//
//	@GetMapping(value = "/quizList")
//	@PreAuthorize("permitAll")
//	public String getUserList(@RequestParam(value = "name", required = false) String name, Model model,
//			@PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
//					@SortDefault(sort = "name", direction = Direction.DESC),
//					@SortDefault(sort = "description", direction = Direction.ASC) }) Pageable pageable) {
//
//		// Page<Quiz> quizzes = quizService.search(name, pageable);
//
//		Page<Quiz> quizzes = quizService.findAll(pageable); // TODO
//
//		model.addAttribute("quizzes", quizzes);
//		return "pages/quizList";
//	}
//
//	@GetMapping(value = "/quizDetail")
//	@PreAuthorize("permitAll")
//	public ModelAndView quizDetail() {
//
//
//		//accessControlServiceQuiz.canCurrentUserUpdateObject(quiz); TODO
//
//		ModelAndView mav = new ModelAndView();
//		//mav.addObject("quiz", quiz);
//		mav.setViewName("/pages/quizDetail");
//
//		return mav;
//	}
//
//
//
//	@GetMapping(value = "/quizDetail/{quiz_id}")
//	@PreAuthorize("permitAll")
//	public ModelAndView quizDetail(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//
//		System.err.println(quiz_id);
//		//accessControlServiceQuiz.canCurrentUserUpdateObject(quiz); TODO
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("/pages/quizDetail");
//
//		return mav;
//	}
//
////	@PostMapping(value = "/createQuiz")
////	@PreAuthorize("permitAll")
////	public String newQuiz(@AuthenticationPrincipal AuthenticatedUser user, Quiz quiz, BindingResult result,
////			Model model) {
////		Quiz newQuiz;
////		System.err.println("asd");
////		try {
//////			RestVerifier.verifyModelResult(result);
//////
////			// User user2 = user.getUser();
////			User user2 = userService.findByUsername(user.getUsername());
////
////			newQuiz = quizService.save(quiz, user2);
////
////		} catch (ModelVerificationException e) {
////			return "quizDetail";
////		}
////
////		return "redirect:/quizDetail/" + newQuiz.getId();
////	}
////
////	@GetMapping(value = "/editQuiz/{quiz_id}")
////	@PreAuthorize("permitAll")
////	public ModelAndView editQuiz(@PathVariable long quiz_id) {
////		Quiz quiz = quizService.find(quiz_id);
////		//accessControlServiceQuiz.canCurrentUserUpdateObject(quiz);
////
////		ModelAndView mav = new ModelAndView();
////		mav.addObject("quiz", quiz);
////		mav.setViewName("/pages/quizDetail");
////
////		return mav;
////	}
////
////	@GetMapping(value = "/editAnswer/{question_id}")
////	@PreAuthorize("isAuthenticated()")
////	public ModelAndView editAnswer(@PathVariable long question_id) {
////		Question question = questionService.find(question_id);
////		accessControlServiceQuestion.canCurrentUserUpdateObject(question);
////
////		ModelAndView mav = new ModelAndView();
////		mav.addObject("question", question);
////		mav.setViewName("editAnswers");
////
////		return mav;
////	}
//
//	@GetMapping(value = "/quiz/{quiz_id}")
//	@PreAuthorize("permitAll")
//	public ModelAndView getQuiz(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("quizView");
//
//		return mav;
//	}
//
//	@GetMapping(value = "/quiz/{quiz_id}/play")
//	@PreAuthorize("permitAll")
//	public ModelAndView playQuiz(@PathVariable long quiz_id) {
//		Quiz quiz = quizService.find(quiz_id);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("quiz", quiz);
//		mav.setViewName("playQuiz");
//
//		return mav;
//	}
//}
