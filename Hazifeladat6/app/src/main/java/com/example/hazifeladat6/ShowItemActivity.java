package com.example.hazifeladat6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import android.content.res.Configuration;

public class ShowItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_2);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String selectedItem = extras.getString("item");
            TextView textView = findViewById(R.id.selectedopt);
            textView.setText("You have selected " + selectedItem);
        }
    }
}
