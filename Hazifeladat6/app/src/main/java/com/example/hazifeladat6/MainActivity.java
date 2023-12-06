package com.example.hazifeladat6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String FRAG1 = "1";
    private static final String FRAG2 = "2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentTransaction.add(R.id.fragment1,new Fragment1(), FRAG1);
            fragmentTransaction.add(R.id.fragment2,new Fragment2(), FRAG2);
        }
        else{
            if(fragmentManager.findFragmentByTag(FRAG2)!=null)
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(FRAG2));
            fragmentTransaction.add(R.id.fragment1,new Fragment1(), FRAG1);
        }
        fragmentTransaction.commit();

    }
}