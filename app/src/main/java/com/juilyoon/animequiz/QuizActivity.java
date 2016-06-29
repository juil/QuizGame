package com.juilyoon.animequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.juilyoon.quiz.*;

public class QuizActivity extends AppCompatActivity {
    // Question data
    private int questionNum = 1;
    private Question currentQuestion;
    private Quiz quiz;
    // Question views
    TextView questionView;
    RadioGroup singleMultipleChoice;
    ListView multiMultipleChoice;
    EditText textAnswer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Question views
        questionView = (TextView) findViewById(R.id.question_text);
        singleMultipleChoice = (RadioGroup) findViewById(R.id.single_multipleChoice);
        multiMultipleChoice = (ListView) findViewById(R.id.multi_multipleChoice);
        textAnswer = (EditText) findViewById(R.id.text_answer);

        // Example quiz
        Question q1 = new Question("What is the most important law of alchemy?", new String[]{"The Law of Equivalent Exchange", "Equivalent Exchange"});
        MultipleChoice q2 = new MultipleChoice("Which humonculos has the ability to transform?",
                                                new String[]{"Envy"}, new String[]{"Envy", "Wrath", "Greed", "Lust"});
        MultipleChoice q3 = new MultipleChoice("Whom of the following are state alchemists?",
                                                new String[]{"Roy Mustang", "Edward Elric"}, new String[]{"Roy Mustang", "Edward Elric", "Riza Hawkeye", "Alphonse Elric"});
        quiz = new Quiz(new Question[]{q1, q2, q3});
    }

    public void nextQuestion(View view) {
        clearQuestion();
        currentQuestion = quiz.nextQuestion();
        loadQuestion(currentQuestion);
        // When player has reached final question
        if (quiz.getQuestionNumber() == quiz.length()-1) {
            Button finish = (Button) findViewById(R.id.next_button);
            finish.setText(R.string.finish);
            finish.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finishQuiz();
                }
            });
        }
    }

    private void loadQuestion(Question question) {
        questionView.setText(question.getQuestion());
        if (question instanceof MultipleChoice) {
            if (((MultipleChoice) question).isSingleChoice()) {
                singleMultipleChoice.setVisibility(View.VISIBLE);
            }
        }
    }

    private void clearQuestion() {
        singleMultipleChoice.setVisibility(View.GONE);
        multiMultipleChoice.setVisibility(View.GONE);
        textAnswer.setVisibility(View.GONE);
    }

    private void finishQuiz() {

    }
}
