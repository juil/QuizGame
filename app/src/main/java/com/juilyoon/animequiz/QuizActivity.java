package com.juilyoon.animequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import com.juilyoon.quiz.*;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    // Quiz metadata
    protected int quizLength = 10;
    // Question data
    private int questionNum = 1;
    private Quiz quizFMA;
    // Question views
    RadioGroup singleMultipleChoice;
    ListView multiMultipleChoice;
    EditText textAnswer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Question views
        singleMultipleChoice = (RadioGroup) findViewById(R.id.single_multipleChoice);
        multiMultipleChoice = (ListView) findViewById(R.id.multi_multipleChoice);
        textAnswer = (EditText) findViewById(R.id.text_answer);

        // Example quiz
        Question q1 = new Question("What is the most important law of alchemy?", new String[]{"The Law of Equivalent Exchange", "Equivalent Exchange"});
        quizFMA = new Quiz(new Question[]{q1});
    }

    public void nextQuestion(View view) {
        clearQuestion();
    }

    private void clearQuestion() {
        singleMultipleChoice.setVisibility(View.GONE);
        multiMultipleChoice.setVisibility(View.GONE);
        textAnswer.setVisibility(View.GONE);
    }
}
