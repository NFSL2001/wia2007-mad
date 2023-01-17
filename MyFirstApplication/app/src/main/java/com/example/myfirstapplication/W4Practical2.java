package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class W4Practical2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w4_practical2);

    }

    public void BtnSubmitOnClick(View v){
        CheckBox CBRed = findViewById(R.id.CBRed);
        CheckBox CBGreen = findViewById(R.id.CBGreen);
        CheckBox CBBlue = findViewById(R.id.CBBlue);

        ConstraintLayout CSLayout = findViewById(R.id.CLayoutCS);

        int final_hex = 0;
        if(CBRed.isChecked()) final_hex+=Color.RED;
        if(CBGreen.isChecked()) final_hex+=Color.GREEN;
        if(CBBlue.isChecked()) final_hex+=Color.BLUE;
        CSLayout.setBackgroundColor(final_hex);
        if(final_hex==0xFF000000){
            CBRed.setTextColor(Color.parseColor("#FFFFFF"));
            CBGreen.setTextColor(Color.parseColor("#FFFFFF"));
            CBBlue.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }
}