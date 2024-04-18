package edu.bzu.ass1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickLetters(View view) {
        Intent intent = new Intent(HomePage.this,LetterPage.class);
        startActivity(intent);
    }

    public void onClickNumber(View view) {
        Intent intent = new Intent(HomePage.this,NumberPage.class);
        startActivity(intent);
    }

    public void onClickColor(View view) {
        Intent intent = new Intent(HomePage.this,ColorPage.class);
        startActivity(intent);
    }

    public void onClickFamily(View view) {
        Intent intent = new Intent(HomePage.this,FamilyPage.class);
        startActivity(intent);
    }

    public void onClickQuiz(View view) {
        Intent intent = new Intent(HomePage.this,QuizPage.class);
        startActivity(intent);
    }
}