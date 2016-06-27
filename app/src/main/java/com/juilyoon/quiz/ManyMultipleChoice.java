package com.juilyoon.quiz;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by juil on 16-06-27.
 */
public class ManyMultipleChoice extends MultipleChoice {
    private String[] correctAnswers;
    private ArrayList<String> correctAnswerList;

    /**
     * Constructor for ManyMultipleChoice question class.
     * @param question
     * @param answer
     * @param options Always 4 options per question
     * @param correctAnswers Array of integer values that correspond to correct answers in
     */
    public ManyMultipleChoice(String question, String[] answer, String[] options, String[] correctAnswers) {
        super(question, answer, options);
        this.correctAnswers = correctAnswers;
        correctAnswerList = new ArrayList<String>(Arrays.asList(this.correctAnswers));
    }

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }

    public boolean isCorrect(String[] guess) {
        // Check that guess is no more and no less than correctAnswers
        int correctNum = correctAnswers.length;
        if (guess.length == correctNum) {
            for (int i=0; i < correctNum; i++){
                if (!correctAnswerList.contains(guess[i])) {
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
