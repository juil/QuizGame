package com.juilyoon.quiz;

import java.util.ArrayList;

/**
 * Created by juil on 16-06-27.
 */
public class Question {
    protected String question;
    protected String[] answers;
    protected ArrayList<String> answerList;

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

    /**
     * isCorrect() checks to see if guess is correct
     * #TODO: check for all cases and iterations
     * @param guess
     * @return
     */
    public boolean isCorrect(String guess) {
        return answerList.contains(guess);
    }
}
