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
}
