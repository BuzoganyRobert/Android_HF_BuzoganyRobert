package com.example.activitylifecyclemonito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityThree extends AppCompatActivity {
    private static final String lookHere="AcitivityLifeCycle2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
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