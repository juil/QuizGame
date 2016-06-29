package com.juilyoon.animequiz;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.juilyoon.quiz.*;

public class QuizActivity extends AppCompatActivity {
    // Question data
    private Question currentQuestion;
    private Quiz quiz;
    // Question views
    TextView questionNum;
    TextView questionView;
    RadioGroup singleMultipleChoice;
    RadioButton radio1, radio2, radio3, radio4;
    LinearLayout multiMultipleChoice;
    ArrayAdapter<String> adapter; // For populating the ListView
    CheckBox check1, check2, check3, check4;
    EditText textAnswer;
    // Keyboard settings
    View keyboard;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Question views
        questionNum = (TextView) findViewById(R.id.question_number);
        questionView = (TextView) findViewById(R.id.question_text);
        singleMultipleChoice = (RadioGroup) findViewById(R.id.single_multipleChoice);
        radio1 = (RadioButton) findViewById(R.id.radioButton1);
        radio2 = (RadioButton) findViewById(R.id.radioButton2);
        radio3 = (RadioButton) findViewById(R.id.radioButton3);
        radio4 = (RadioButton) findViewById(R.id.radioButton4);
        multiMultipleChoice = (LinearLayout) findViewById(R.id.multi_multipleChoice);
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check4 = (CheckBox) findViewById(R.id.checkBox4);
        textAnswer = (EditText) findViewById(R.id.text_answer);

        // Example quiz
        Question q1 = new Question("What is the most important law of alchemy?", new String[]{"The Law of Equivalent Exchange", "Equivalent Exchange"});
        MultipleChoice q2 = new MultipleChoice("Which humonculos has the ability to transform?",
                                                new String[]{"Envy"}, new String[]{"Envy", "Wrath", "Greed", "Lust"});
        MultipleChoice q3 = new MultipleChoice("Whom of the following are state alchemists?",
                                                new String[]{"Roy Mustang", "Edward Elric"}, new String[]{"Roy Mustang", "Edward Elric", "Riza Hawkeye", "Alphonse Elric"});
        quiz = new Quiz(new Question[]{q1, q2, q3});

        // Load first question
        loadQuestion(quiz.getQuestion());
    }

    public void nextQuestion(View view) {
        clearQuestion();
        currentQuestion = quiz.nextQuestion();
        // Hide keyboard
        keyboard = view;
        loadQuestion(currentQuestion);
        // When player has reached final question
        if (quiz.getQuestionNumber() == quiz.length()) {
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
        questionNum.setText(getString(R.string.questionNum) + " " + quiz.getQuestionNumber() + ":");
        questionView.setText(question.getQuestion());
        if (question instanceof MultipleChoice) {
            closeKeyboard(keyboard.getWindowToken());
            String[] options = ((MultipleChoice) question).getOptions();
            if (((MultipleChoice) question).isSingleChoice()) {
                radio1.setText(options[0]);
                radio2.setText(options[1]);
                radio3.setText(options[2]);
                radio4.setText(options[3]);
                singleMultipleChoice.setVisibility(View.VISIBLE);
            }
            else { // More than one choice needed for correct answer
                check1.setText(options[0]);
                check2.setText(options[1]);
                check3.setText(options[2]);
                check4.setText(options[3]);
                multiMultipleChoice.setVisibility(View.VISIBLE);
            }
        }
        else {
            textAnswer.setVisibility(View.VISIBLE);
        }
    }

    private void clearQuestion() {
        singleMultipleChoice.setVisibility(View.GONE);
        singleMultipleChoice.clearCheck();
        multiMultipleChoice.setVisibility(View.GONE);
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
        check4.setChecked(false);
        textAnswer.setVisibility(View.GONE);
        textAnswer.setText("");
    }

    private void finishQuiz() {
        Log.v("QuizActivity", "Quiz completed.");
        // Go back to quiz directory
        setContentView(R.layout.activity_directory);
        Intent intent = new Intent(this, DirectoryActivity.class);
        Log.v("QuizActivity", "Return to directory.");
        startActivity(intent);
        // Display score in toast
        Toast.makeText(getApplicationContext(), "You finished!", Toast.LENGTH_LONG).show();
    }

    private void closeKeyboard(IBinder windowToken) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS);
        Log.v("QuizActivity", "Hide keyboard.");
    }
}
