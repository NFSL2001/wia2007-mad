package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class W4Practical1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w4_practical);

        final Button btnCalculate = findViewById(R.id.BtnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num1 = findViewById(R.id.ETNum1);
                EditText num2 = findViewById(R.id.ETNum2);
                TextView resultview = findViewById(R.id.TVResult);
                Double result = Double.parseDouble(num1.getText().toString()) +
                        Double.parseDouble(num2.getText().toString());
                resultview.setText(Double.toString(result));
            }
        });
    }
}