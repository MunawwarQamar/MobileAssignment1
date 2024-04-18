package edu.bzu.ass1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizPage extends AppCompatActivity {
    private TextView question, rate, answer, word;
    private Button btn1, btn2, btn3, btn4;
    private int counterRate = 0, counterQuestion = 0;
    private QuestionDatabase questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_page);
        setupViews();
        getData();
        checkAns();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupViews() {
        question = findViewById(R.id.question);
        rate = findViewById(R.id.rate);
        word = findViewById(R.id.word);
        answer = findViewById(R.id.txtAns);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
    }

    private void getData() {
        QuestionDatabase questionDatabase =new QuestionDatabase();
        if (counterQuestion < questionDatabase.questionList.size()) {
            questions = questionDatabase.questionList.get(counterQuestion);
            counterQuestion++;
            question.setText("Q: " + counterQuestion + "/10");
            rate.setText("Rate: " + counterRate + "/10");
            word.setText(questions.getQuestion());
            btn1.setText(questions.getOption1());
            btn2.setText(questions.getOption2());
            btn3.setText(questions.getOption3());
            btn4.setText(questions.getOption4());
        } else {
            // Quiz completed, navigate to the result screen
            Intent intent = new Intent(QuizPage.this, ResultActivity.class);
            intent.putExtra("score", counterRate);
            startActivity(intent);
            finish(); // Finish the current activity
        }
    }

    private void checkAns() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn1.getText().toString());
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn2.getText().toString());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn3.getText().toString());
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(btn4.getText().toString());
            }
        });
    }

    private void checkAnswer(String selectedOption) {
        if (selectedOption.equals(questions.getRightOption())) {
            answer.setText("Right Answer");
            counterRate++;
        } else {
            answer.setText("Wrong Answer, the Right is: " + questions.getRightOption());
        }
        getData(); // Load next question data
    }
}
