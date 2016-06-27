package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class Question {
    private String question;
    private String[] answers;

    /**
     * Constructor for Question class.
     * @param question
     * @param answers All possible answers to question.
     */
    public Question(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public boolean isCorrect(String guess) {
        return true;
    }
}
