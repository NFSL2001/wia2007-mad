package com.example.loginw9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText ETBgColourCode;
    EditText ETImageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ETBgColourCode = findViewById(R.id.ETBgColourCode);
        ETImageNumber = findViewById(R.id.ETImageNumber);

        //get preferences storage
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //get values
        String SPBgColourCode = sharedPref.getString("BgColourCode", "");
        int SPImageNumber = sharedPref.getInt("ImageNumber", 3);

        ETBgColourCode.setText(SPBgColourCode);
        ETImageNumber.setText(String.valueOf(SPImageNumber));
    }

    public void onClickBtnSave(View v){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        //prepare editor
        SharedPreferences.Editor SPEditor = sharedPref.edit();

        String BgColourCode = ETBgColourCode.getText().toString();
        Integer ImageNumber = Integer.parseInt(ETImageNumber.getText().toString());

        //save into pref
        SPEditor.putString("BgColourCode", BgColourCode);
        SPEditor.putInt("ImageNumber", ImageNumber);

        //commit
        SPEditor.commit();

        //refresh UI
        startActivity(new Intent(this, this.getClass()));
    }
}