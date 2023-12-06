package com.example.countrymoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

    public class MainActivity extends AppCompatActivity {
        String[] moneyNameShort={"EUR","USD","GBP","AUD","CAD","CHF","DKK","HUF"};
        String[] moneyName={"Euro","United States dollar","Great Britain Pound","Australian dollar","Canadian dollar","Swiss franc","Danish Krone","Hungarian forint "};

        Integer[] moneyPic={R.drawable.eu,
                R.drawable.usd,
                R.drawable.uk,
                R.drawable.australia,
                R.drawable.canada,
                R.drawable.switzerland,
                R.drawable.denmark,
                R.drawable.hungary,

        };
        Double[] money_buy={4.4100,3.9750,6.1250,2.9600,3.0950,4.2300,0.5850,0.01360};
        Double[] money_sell={4.5500,4.1450,6.3550,3.0600,3.2650,4.3300,0.6150,0.0146};

        ListView myList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            myList=findViewById(R.id.myList);
            CustomListViewAdapter simpleAdapter = new CustomListViewAdapter(this, moneyNameShort, moneyName, money_buy, money_sell, moneyPic);
            myList.setAdapter(simpleAdapter);

        }
    }