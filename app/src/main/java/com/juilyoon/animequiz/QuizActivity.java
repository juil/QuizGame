package com.juilyoon.animequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    // Quiz metadata
    protected int quizLength = 10;
    protected int[] correctAnswers = new int[quizLength];
    // Question data
    private int questionNum = 1;
    // Question views
//    RadioGroup multipleChoice_single = (RadioGroup) findViewById(R.id.multiple_choice_single);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    private void nextQuestion() {
//        multipleChoice_single.setVisibility(View.GONE);
    }
}
