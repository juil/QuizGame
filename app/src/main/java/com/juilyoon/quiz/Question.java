package com.juilyoon.quiz;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by juil on 16-06-27.
 */
public class Question {
    protected String question;
    protected String[] answers;

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
        for (int i = 0; i < answers.length; i++) {
            if (guess.toLowerCase().replaceAll("\\s", "").equals(answers[i].toLowerCase().replaceAll("\\s", ""))) {
                Log.v("Question", "Answer is correct.");
                return true;
            }
        }
        Log.v("Question", "Answer is incorrect.");
        return false;
    }
}
