package com.example.snickersdevops.repository;

import com.example.snickersdevops.models.Question;
import com.example.snickersdevops.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    int countByQuiz(Quiz quiz);

    int countByQuizAndIsValidTrue(Quiz quiz);

    List<Question> findByQuizOrderByOrderAsc(Quiz quiz);

    List<Question> findByQuizAndIsValidTrueOrderByOrderAsc(Quiz quiz);
}
