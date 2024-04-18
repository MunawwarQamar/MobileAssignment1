package edu.bzu.ass1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class NumberPage extends AppCompatActivity {
    private Spinner spinner;
    private ListView lstVeiw;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_number_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setUpViews();
        populateSpinner();
        btn.setOnClickListener(new View.OnClickListener() {//event handler
            @Override
            public void onClick(View v) {
                NumberDatabase db = new NumberDatabase();
                String cat = spinner.getSelectedItem().toString();

                List<Items> result = db.getItems(cat);
                Items[] arr = result.toArray(new Items[result.size()]);
                ArrayAdapter<Items> adapter = new ArrayAdapter<Items>(NumberPage.this,
                        android.R.layout.simple_list_item_1, arr);
                lstVeiw.setAdapter(adapter);


            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setUpViews() {
        spinner =findViewById(R.id.spnMenu);
        lstVeiw=findViewById(R.id.lstView);
        btn=findViewById(R.id.btnSearch);
    }
    private void populateSpinner() {
        NumberDatabase db = new NumberDatabase();
        String[] cats = db.getCategory();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cats);
        spinner.setAdapter(adapter);
    }
}