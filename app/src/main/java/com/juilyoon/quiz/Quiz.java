package com.juilyoon.quiz;

import java.util.Queue;

/**
 * Created by juil on 16-06-27.
 */
public class Quiz {
    private Question[] questions;
    private int currentQuestion;

    public Quiz(Question[] questions) {
        this.questions = questions;
        currentQuestion = 0;
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

    /**
     * nextQuestion iterates to the next question
     * @return Next question in quiz or null at the end of the quiz
     */
    public Question nextQuestion() {
        currentQuestion++;
        if (currentQuestion < length()) {
            return questions[currentQuestion];
        }
        else {
            return null;
        }
    }
}


