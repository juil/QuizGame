package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class Question {
    private String question;
    private String answer;

    public Question(String q, String a) {
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
