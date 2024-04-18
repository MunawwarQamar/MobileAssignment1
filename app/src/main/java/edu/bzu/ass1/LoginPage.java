package edu.bzu.ass1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {
    public static final String ID = "ID" ;
    public static final String PASS = "PASS";
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    private EditText edtId;
    private EditText edtPassword;
    private CheckBox chk;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setupViews();
        setupSharedPrefs();
        checkPrefs();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setupViews() {
        edtId = findViewById(R.id.edtID);
        edtPassword = findViewById(R.id.edtPassword);
        chk = findViewById(R.id.chk);
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
            int id = prefs.getInt(ID ,0);
            String password = prefs.getString(PASS, "");
            edtId.setText(id);
            edtPassword.setText(password);
            chk.setChecked(true);
        }
    }

    public void btnLoginOnClick(View view) {
            int id =Integer.parseInt(edtId.getText().toString()) ;
            String password = edtPassword.getText().toString();

            if(chk.isChecked()){
                if(!flag) {
                    editor.putInt(ID, id);
                    editor.putString(PASS, password);
                    editor.putBoolean(FLAG, true);
                    editor.commit();
                }
            }else
                prefs.edit().clear().apply();
        Intent intent = new Intent(LoginPage.this,HomePage.class);
        startActivity(intent);
    }
}