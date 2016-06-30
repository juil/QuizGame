package com.juilyoon.quiz;

import android.util.Log;

/**
 * Created by juil on 16-06-27.
 */
public class Quiz {
    private Question[] questions;
    private int questionNumber;
    private boolean[] correctGuess;

    public Quiz(Question[] questions) {
        this.questions = questions;
        questionNumber = 0;
        correctGuess = new boolean[length()];
    }

    /**
     * length returns the number of questions in the quiz
     * @return int: the number of questions
     */
    public int length() {
        return questions.length;
    }

    public int getQuestionNumber() {
        return questionNumber + 1;
    }

    public int getScore() {
        int score = 0;
        for (int i=0; i < questionNumber; i++) {
            if (correctGuess[i]) {
                score++;
            }
        }
        return score;
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
     * checkAnswer for text input answer
     * @param guess Text input answer.
     * @return
     */
    public boolean checkAnswer(String guess) {
        boolean correct = getQuestion().isCorrect(guess);
        correctGuess[questionNumber] = correct;
        return correct;
    }

    /**
     * checkAnswer for multiple choice
     * @param guesses Choices selected in radio group or check boxes
     * @return
     */
    public boolean checkAnswer(String[] guesses) {
        boolean correct = ((MultipleChoice) getQuestion()).isCorrect(guesses);
        correctGuess[questionNumber] = correct;
        return correct;
    }

    /**
     * getQuestion returns the current question of the quiz
     * @return Question: the current question
     */
    public Question getQuestion() {
        return questions[questionNumber];
    }

    /**
     * nextQuestion iterates to the next question
     * @return Next question in quiz or null at the end of the quiz
     */
    public Question nextQuestion() {
        Log.v("Quiz", "Score: " + getScore() + "/" + questionNumber);
        questionNumber++;
        if (questionNumber < length()) {
            return questions[questionNumber];
        }
        else {
            return null;
        }
    }
}


