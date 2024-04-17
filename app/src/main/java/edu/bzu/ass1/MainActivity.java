package edu.bzu.ass1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setUpViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btnSignUp);
    }


    public void onClickLogin(View view) {
        Intent intent = new Intent(MainActivity.this,LoginPage.class);
        startActivity(intent);
    }

    public void onClickSignUp(View view) {
        Intent intent = new Intent(MainActivity.this,SignUpPage.class);
        startActivity(intent);
    }

}