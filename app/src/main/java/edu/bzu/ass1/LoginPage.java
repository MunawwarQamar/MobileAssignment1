package edu.bzu.ass1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    private EditText edtID, edtPassword;
    private CheckBox chk;
    private Button btnSignIn;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        loadPreferences();
        setupViews();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void setupViews() {
        edtID = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);
        chk = findViewById(R.id.chk);
        btnSignIn = findViewById(R.id.btnSignIn);
    }
        private void login() {
        String savedID = sharedPreferences.getString("ID", "");
        String savedPassword = sharedPreferences.getString("Password", "");
        String inputID = edtID.getText().toString();
        String inputPassword = edtPassword.getText().toString();

        if (inputID.equals(savedID) && inputPassword.equals(savedPassword)) {
            if (chk.isChecked()) {
                saveLogin(inputID, inputPassword);
            } else {
                clearLogin();
            }
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(this, HomePage.class);
             startActivity(intent);
        } else {
            Toast.makeText(this, "Invalid ID or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLogin(String id, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("SavedID", id);
        editor.putString("SavedPassword", password);
        editor.apply();
    }

    private void clearLogin() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("SavedID");
        editor.remove("SavedPassword");
        editor.apply();
    }

    private void loadPreferences() {
        String savedID = sharedPreferences.getString("SavedID", null);
        String savedPassword = sharedPreferences.getString("SavedPassword", null);
        if (savedID != null && savedPassword != null) {
            edtID.setText(savedID);
            edtPassword.setText(savedPassword);
            chk.setChecked(true);
        }
    }
}
