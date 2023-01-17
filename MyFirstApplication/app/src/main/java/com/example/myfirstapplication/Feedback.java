package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        RatingBar ratingBar = findViewById(R.id.RateBarFeedback);
        TextView ratingDesc = findViewById(R.id.RatingDesc);
        EditText ETfeedback = findViewById(R.id.ETFeedback);
        Button Btnfeedback = findViewById(R.id.BtnFeedback);

        Btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Thank you for your feedback!";
                if(!ETfeedback.getText().toString().isEmpty()){
                    message += " Please enjoy your RM5 voucher code: FDBK2022";
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String description = "Tell us more:";
                switch ((int) Math.ceil(ratingBar.getRating())){
                    case 1:
                        description = "We are sincerely sorry to hear that! " + description; break;
                    case 2:
                        description = "Aww, sorry to hear that! " + description; break;
                    case 4:
                        description = "Thank you! " + description; break;
                    case 5:
                        description = "A generous thanks for you! " + description; break;
                }
                ratingDesc.setText(description);
            }
        });
    }
}