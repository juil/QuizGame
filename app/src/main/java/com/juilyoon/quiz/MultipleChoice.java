package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class MultipleChoice extends Question{
    private String[] options = new String[4];

    /**
     *
     * @param question
     * @param answer
     * @param options Always 4 options per question
     */
    public MultipleChoice(String question, String[] answer, String[] options) {
        super(question, answer);
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }
}
