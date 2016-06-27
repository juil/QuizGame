package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class SingleMultipleChoice extends MultipleChoice {
    private String correctAnswer;

    /**
     *
     * @param question
     * @param answer
     * @param options Alwayy 4 options
     * @param correctAnswer
     */
    public SingleMultipleChoice(String question, String[] answer, String[] options, String correctAnswer) {
        super(question, answer, options);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String guess) {
        if (guess.equals(correctAnswer)) {
            return true;
        }
        else {
            return false;
        }
    }
}
