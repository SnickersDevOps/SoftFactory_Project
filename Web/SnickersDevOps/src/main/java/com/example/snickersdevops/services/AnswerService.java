package com.example.snickersdevops.services;

import com.example.snickersdevops.exсeptions.ResourceUnavailableException;
import com.example.snickersdevops.exсeptions.UnauthorizedActionException;
import com.example.snickersdevops.models.Answer;
import com.example.snickersdevops.models.Question;

import java.util.List;

public interface AnswerService {
	Answer save(Answer answer) throws UnauthorizedActionException;

	Answer find(Long id) throws ResourceUnavailableException;

	Answer update(Answer newAnswer) throws UnauthorizedActionException, ResourceUnavailableException;

	void delete(Answer answer) throws UnauthorizedActionException, ResourceUnavailableException;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}
