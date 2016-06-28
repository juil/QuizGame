package com.juilyoon.quiz;

import java.util.ArrayList;
import java.util.Arrays;

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
