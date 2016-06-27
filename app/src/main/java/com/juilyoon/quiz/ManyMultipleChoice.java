package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class ManyMultipleChoice extends MultipleChoice {
    private int[] correctAnswers;

    /**
     * Constructor for ManyMultipleChoice question class.
     * @param question
     * @param answer
     * @param options Always 4 options per question
     * @param correctAnswers Array of integer values that correspond to correct answers in
     */
    public ManyMultipleChoice(String question, String[] answer, String[] options, int[] correctAnswers) {
        super(question, answer, options);
        this.correctAnswers = correctAnswers;
    }

    public int[] getCorrectAnswers() {
        return correctAnswers;
    }


}
