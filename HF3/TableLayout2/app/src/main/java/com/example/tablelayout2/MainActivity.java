package com.example.tablelayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
;import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  TextView  productsView;


    private final List<Product> productsList = new ArrayList<>();
    private final List<StringBuilder> productListDelete=new ArrayList<StringBuilder>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.addButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button showButton = findViewById(R.id.showButton);


        EditText productCode = findViewById(R.id.productCode);
        EditText productName = findViewById(R.id.productName);
        EditText productPrice = findViewById(R.id.productPrice);
        productsView = findViewById(R.id.productsView);





        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = productCode.getText().toString();
                String name = productName.getText().toString();
                String price = productPrice.getText().toString();
                Product pd1 = new Product(code, name, price);


                int isEmpty = 0;

                if (code.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Code line is empty", Toast.LENGTH_SHORT).show();
                    isEmpty = 1;

                }
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Name line is empty", Toast.LENGTH_SHORT).show();
                    isEmpty = 1;
                }
                if (price.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Price line is empty", Toast.LENGTH_SHORT).show();
                    isEmpty = 1;
                }
                if (isEmpty != 1) {
                    productsList.add(pd1);
                    productCode.getText().clear();
                    productName.getText().clear();
                    productPrice.getText().clear();




                }

            }

        });



        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayProducts();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText=productsView.getText().toString();

                if(!currentText.isEmpty()){
                    String[] lines=currentText.split("\n");

                    if(lines.length>0){
                        StringBuilder newproductsView=new StringBuilder();
                        for (int i = 1; i < lines.length; i++) {
                            newproductsView.append(lines[i]);

                            if(i<lines.length-1){
                                newproductsView.append("\n");
                            }

                            
                        }
                        productsView.setText(newproductsView.toString());

                    }else{
                        productsView.setText("");
                    }
                }
            }
        });


    }
    private void displayProducts() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : productsList) {
            stringBuilder.append(product.toString()).append("\n");
        }

        productsView.setText(stringBuilder.toString());
        productsView.setVisibility(View.VISIBLE);

    }



}