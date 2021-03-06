package com.example.snickersdevops.repository;

import com.example.snickersdevops.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

    int countByQuestion(Question question);

    List<Answer> findByQuestionOrderByOrderAsc(Question question);

}
