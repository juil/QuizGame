package com.juilyoon.quiz;

/**
 * Created by juil on 16-06-27.
 */
public class Quiz {
    private Question[] questions;
    private int questionNumber;

    public Quiz(Question[] questions) {
        this.questions = questions;
        questionNumber = 0;
    }

    /**
     * length returns the number of questions in the quiz
     * @return int: the number of questions
     */
    public int length() {
        return questions.length;
    }

    public int getQuestionNumber() {
        return questionNumber;
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
        questionNumber++;
        if (questionNumber < length()) {
            return questions[questionNumber];
        }
        else {
            return null;
        }
    }
}


