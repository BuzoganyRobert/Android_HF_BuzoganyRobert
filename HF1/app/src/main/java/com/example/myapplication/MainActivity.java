package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView elso_szam;
    TextView masodik_szam;
    TextView erdm;
    int eredmeny=0;
     boolean aktivalas1;
     boolean aktivalas2;
     char utolso_szam='\0';




    final String[] szoveg2 = new String[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elso_szam=(TextView)findViewById(R.id.elso_szam);
        masodik_szam=(TextView)findViewById(R.id.masodik_szam);
        erdm=(TextView)findViewById(R.id.erdm);
        aktivalas1=true;
        aktivalas2=false;








        Button gomb1=findViewById(R.id.button1);
        Button gomb0=findViewById(R.id.button0);
        Button gomb2=findViewById(R.id.button2);
        Button gomb3=findViewById(R.id.button3);
        Button gomb4=findViewById(R.id.button4);
        Button gomb5=findViewById(R.id.button5);
        Button gomb6=findViewById(R.id.button6);
        Button gomb7=findViewById(R.id.button7);
        Button gomb8=findViewById(R.id.button8);
        Button gomb9=findViewById(R.id.button9);

        Button gombegy=findViewById(R.id.buttonegy);
        Button gombmin=findViewById(R.id.buttonmin);
        Button gombszor=findViewById(R.id.buttonszor);
        Button gomboszt=findViewById(R.id.buttonosszt);
        Button gomboszz=findViewById(R.id.buttonossz);
        Button gombdel=findViewById(R.id.buttondel);

        Button gomb_valtas_elso=findViewById(R.id.gombelso_szam_valtas);
        Button gomb_valtas_masodik=findViewById(R.id.gombmasodik_szam_valtas);




        gomboszz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int szam1=Integer.parseInt(elso_szam.getText().toString());
                int szam2=Integer.parseInt(masodik_szam.getText().toString());

                 eredmeny = (szam1) + (szam2);




                szoveg2[0]= "Eredmeny: "+ String.valueOf(eredmeny);

                gombegy.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        erdm.setText(szoveg2[0]);

                    }
                });



            }

        });
        gombmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam1=Integer.parseInt(elso_szam.getText().toString());
                int szam2=Integer.parseInt(masodik_szam.getText().toString());

                eredmeny = (szam1) - (szam2);




                szoveg2[0]= "Eredmeny: "+ String.valueOf(eredmeny);
                gombegy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        erdm.setText(szoveg2[0]);

                    }
                });

            }
        });
        gombszor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam1=Integer.parseInt(elso_szam.getText().toString());
                int szam2=Integer.parseInt(masodik_szam.getText().toString());

                eredmeny = (szam1) * (szam2);




                szoveg2[0]= "Eredmeny: "+ String.valueOf(eredmeny);
                gombegy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        erdm.setText(szoveg2[0]);

                    }
                });

            }
        });
        gomboszt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int szam1=Integer.parseInt(elso_szam.getText().toString());
                int szam2=Integer.parseInt(masodik_szam.getText().toString());

                eredmeny = (szam1) / (szam2);




                szoveg2[0]= "Eredmeny: "+ String.valueOf(eredmeny);
                gombegy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        erdm.setText(szoveg2[0]);

                    }
                });

            }
        });

        gombdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                char utolso_szam_elso = '\0';
                char utolso_szam_masodik = '\0';

                if (aktivalas1) {
                    tartalom = elso_szam.getText().toString();
                } else {
                    tartalom = masodik_szam.getText().toString();
                }

                for (int i = tartalom.length() - 1; i >= 0; i--) {
                    char karakter = tartalom.charAt(i);
                    if (Character.isDigit(karakter)) {
                        if (aktivalas1) {
                            utolso_szam_elso = karakter;
                        } else {
                            utolso_szam_masodik = karakter;
                        }
                        break;
                    }
                }

                if (aktivalas1 && utolso_szam_elso != '\0') {
                    int utolso_szam_index = tartalom.lastIndexOf(utolso_szam_elso);
                    String uj_tartalom = tartalom.substring(0, utolso_szam_index) + tartalom.substring(utolso_szam_index + 1);
                    elso_szam.setText(uj_tartalom);
                } else if (!aktivalas1 && utolso_szam_masodik != '\0') {
                    int utolso_szam_index = tartalom.lastIndexOf(utolso_szam_masodik);
                    String uj_tartalom = tartalom.substring(0, utolso_szam_index) + tartalom.substring(utolso_szam_index + 1);
                    masodik_szam.setText(uj_tartalom);
                }
            }
        });

        gomb_valtas_elso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  aktivalas1=true;
                  aktivalas2=false;

            }
        });
        gomb_valtas_masodik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktivalas1=false;
                aktivalas2=true;
            }
        });
        gomb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="0";

                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="0";


                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="1";

                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="1";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="2";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="2";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });
        gomb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="3";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="3";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="4";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="4";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="5";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="5";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="6";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="6";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });

        gomb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="7";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="7";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });
        gomb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="8";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="8";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });
        gomb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tartalom;
                if (aktivalas1){
                    tartalom=elso_szam.getText().toString();
                    tartalom+="9";
                }else{
                    tartalom=masodik_szam.getText().toString();
                    tartalom+="9";

                }
                if(aktivalas1){
                    elso_szam.setText(tartalom);
                }else{
                    masodik_szam.setText(tartalom);
                }
            }
        });



    }


}