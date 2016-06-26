package com.juilyoon.animequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DirectoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
    }

    public void openQuiz(View view) {
        setContentView(R.layout.activity_quiz);
        Intent intent = new Intent(this, QuizActivity.class);
        Log.v("DirectoryActivity", "Open quiz.");
        startActivity(intent);
    }
}
