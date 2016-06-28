package com.juilyoon.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by juil on 16-06-27.
 */
public class MultipleChoice extends Question{
    protected String[] options = new String[4];
    protected ArrayList<String> optionList;

    public MultipleChoice(String question, String[] answers, String[] options) {
        super(question, answers);
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    /**
     * randomizeOptions shuffles the order of the question's multiple choice options
     *
     * Fisher-Yates algorithm taken from http://stackoverflow.com/a/18456998/745776
     */
    public void randomizeOptions() {
        int index;
        String temp;
        Random random = new Random();
        for (int i = answers.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = answers[index];
            answers[index] = answers[i];
            answers[i] = temp;
        }
    }

    /**
     * isCorrect checks if all answers are in guess, no more no less.
     * @param guess Array of strings selected by player
     * @return
     */
    public boolean isCorrect(String[] guess) {
        // Check that guess is no more and no less than correctAnswers; catches 0 guess case
        if (guess.length == answers.length) {
            for (int i=0; i < answers.length; i++){
                if (!answerList.contains(guess[i])) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
