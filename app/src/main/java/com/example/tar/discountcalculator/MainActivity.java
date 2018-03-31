package com.example.tar.discountcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText priceEditText, discountEditText, discountSumEditTextt, priceSum;
    Button checkButton,clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceEditText = findViewById(R.id.priceEditText);
        discountEditText = findViewById(R.id.discountEditText);
        discountSumEditTextt = findViewById(R.id.discountSumEditTextt);
        priceSum = findViewById(R.id.priceSum);
        checkButton = findViewById(R.id.checkButton);
        clearButton = findViewById(R.id.clearButton);

        checkButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double price,discount,sumPrice,sumDiscount;
        if(v==checkButton) {
            if(priceEditText.getText().toString()!=""&&discountEditText.getText().toString()!="") {
                price = Double.parseDouble(priceEditText.getText().toString());
                discount = Double.parseDouble(discountEditText.getText().toString());
                sumDiscount = (price * discount) / 100;
                sumPrice = price - sumDiscount;

                priceSum.setText("" + sumPrice);
                discountSumEditTextt.setText("" + sumDiscount);
            }else Toast.makeText(this,"กรุณากรองข้อมูลให้ครบ",Toast.LENGTH_LONG).show();
        }else if(v==clearButton){
            priceEditText.setText("");
            discountEditText.setText("");
            discountSumEditTextt.setText("");
            priceSum.setText("");
        }
    }
}
