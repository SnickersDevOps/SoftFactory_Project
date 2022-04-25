package com.example.snickersdevops.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_ID;
    private String title;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;

    private int answer;
    private int chose;

    public Question(){
    }

    public Question(int question_ID, String title, String optionA, String optionB, String optionC, String optionD, String optionE, int answer, int chose) {
        this.question_ID = question_ID;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.answer = answer;
        this.chose = chose;
    }

    public int getQuestion_ID() {
        return question_ID;
    }

    public void setQuestion_ID(int question_ID) {
        this.question_ID = question_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getChose() {
        return chose;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_ID=" + question_ID +
                ", title='" + title + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", optionE='" + optionE + '\'' +
                ", answer=" + answer +
                ", chose=" + chose +
                '}';
    }
}
