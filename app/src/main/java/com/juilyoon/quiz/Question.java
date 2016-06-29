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
     *                The first string should be the ideal answer, with the following strings
     *                being all possible iterations of the answer.
     */
    public Question(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
        answerList.add(0, answers[0]);
        for (int i=1; i < answers.length-1; i++) {
            answerList.add(answers[i].toLowerCase());
        }
    }

    public String getQuestion() {
        return question;
    }

    /**
     * isCorrect() checks to see if guess is correct
     * @param guess Case-insensitive
     * @return boolean: whether guess is contained in the set of possible answers
     */
    public boolean isCorrect(String guess) {
        return answerList.contains(guess.toLowerCase());
    }
}
