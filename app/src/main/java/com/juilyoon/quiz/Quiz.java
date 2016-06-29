package com.juilyoon.quiz;

import java.util.Queue;

/**
 * Created by juil on 16-06-27.
 */
public class Quiz {
    private Question[] questions;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    /**
     * length returns the number of questions in the quiz
     * @return int: the number of questions
     */
    public int length() {
        return questions.length;
    }

    public void randomizeOptions() {
        MultipleChoice question;
        for (int i = 0; i < length(); i++) {
            if (questions[i] instanceof MultipleChoice) {
                question = (MultipleChoice) questions[i];
                questions[i] = question.randomizeOptions();
            }
        }
    }
}


