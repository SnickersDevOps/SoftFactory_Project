package com.example.snickersdevops.services;

import com.example.snickersdevops.exсeptions.ResourceUnavailableException;
import com.example.snickersdevops.exсeptions.UnauthorizedActionException;
import com.example.snickersdevops.models.Quiz;
import com.example.snickersdevops.models.User;
import com.example.snickersdevops.models.support.Response;
import com.example.snickersdevops.models.support.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface QuizService {
    Quiz save(Quiz quiz, User user);

    Page<Quiz> findAll(Pageable pageable);

    Page<Quiz> findAllPublished(Pageable pageable);

    Page<Quiz> findQuizzesByUser(User user, Pageable pageable);

    Quiz find(Long id) throws ResourceUnavailableException;

    Quiz update(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

    void delete(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

    Page<Quiz> search(String query, Pageable pageable);

    Result checkAnswers(Quiz quiz, List<Response> answersBundle);

    void publishQuiz(Quiz quiz);
}
