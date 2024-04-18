package edu.bzu.ass1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {
    private EditText edtName, edtID, edtSection, edtEmail, edtPassword, edtConPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
     setupViews();
    }

    private void setupViews() {
        edtName = findViewById(R.id.edtName);
        edtID = findViewById(R.id.edtID);
        edtSection = findViewById(R.id.edtSection);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConPassword = findViewById(R.id.edtConPassword);
    }
    public void onClickGoHome(View view) {
        saveUserData();
         Intent intent = new Intent(this, HomePage.class);
         startActivity(intent);
         finish();
    }

    private void saveUserData() {
        String name = edtName.getText().toString();
        String id = edtID.getText().toString();
        String section = edtSection.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtConPassword.getText().toString();

        // Check if the passwords match
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("ID", id);
        editor.putString("Section", section);
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.apply();
        Toast.makeText(this, "User data saved successfully", Toast.LENGTH_SHORT).show();
    }
}
