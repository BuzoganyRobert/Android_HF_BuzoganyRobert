package com.example.activitylifecyclemonito;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {






    private  static  final String lookHere="AcitivityLifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(lookHere,"onCreate() called");
        Button startActivityTwo = findViewById(R.id.button2);

        startActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent myIntent=new Intent(MainActivity.this,ActivityTwo.class);
            startActivity(myIntent);


            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.d(lookHere,"onStart() called");

    }
    protected  void onResume(){
        super.onResume();
        Log.d(lookHere, "onResume() called ");

    }
    protected void onStop(){
        super.onStop();
        Log.d(lookHere, "onStop() called");
    }
    protected  void onRestart(){
        super.onRestart();
        Log.d(lookHere, "onRestart() called");
    }
    protected  void onDestroy(){
        super.onDestroy();
        Log.d(lookHere, "onDestroy() called");
    }



}