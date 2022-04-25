package com.example.snickersdevops.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name ="results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String email;
    private int totalCorrect = 0;

    public Result() {
    }

    public Result(int ID, int totalCorrect, String email) {
        this.ID = ID;
        this.totalCorrect = totalCorrect;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }
}
