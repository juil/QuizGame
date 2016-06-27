package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class SingleMultipleChoice extends MultipleChoice {
    private int correctAnswer;

    /**
     *
     * @param question
     * @param answer
     * @param options Alwayy 4 options
     * @param correctAnswer
     */
    public SingleMultipleChoice(String question, String[] answer, String[] options, int correctAnswer) {
        super(question, answer, options);
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
