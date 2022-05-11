package com.example.snickersdevops.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Component
@Entity
@Table(name = "question")
public class Question extends BaseModel implements UserOwned {
    @Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
    @NotEmpty(message = "Question text not provided")
    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JsonIgnore
    private Quiz quiz;

    @Column(name = "q_order")
    private Integer order;

    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    @JsonIgnore
    @OneToOne
    private Answer correctAnswer;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Calendar dateCreated;

    @JsonIgnore
    private Boolean isValid = false;

    @Override
    @JsonIgnore
    public User getUser() {
        return quiz.getUser();
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
