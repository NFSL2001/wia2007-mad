package com.example.loginw9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private static final String USER_FILE_NAME = "user_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get internal directory
        Context context = getApplicationContext();
        //create file handler with filename
        File UserFile = new File(context.getFilesDir(), USER_FILE_NAME);

        //check if internal storage has user_file
        if(UserFile.exists()){
            //hide fcv
            FragmentContainerView FCVCreateUser = findViewById(R.id.FCVCreateUser);
            FCVCreateUser.setVisibility(View.GONE);

            //read username
            String username = readUsername(context);
            TextView TVWelcome = findViewById(R.id.TVTitle);
            TVWelcome.setText("Welcome " + username);
        }

    }

    protected String readUsername(Context context){
        String FileContent = "";
        FileInputStream FIS = null;
        try{
            FIS = context.openFileInput(USER_FILE_NAME);
        } catch (FileNotFoundException f){
            f.printStackTrace();
        }

        InputStreamReader inputStreamReader = new InputStreamReader(FIS, StandardCharsets.UTF_8);
        StringBuilder strBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)){
            String line = reader.readLine();
            while (line != null){
                strBuilder.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            FileContent = strBuilder.toString();
        }

        return FileContent;
    }

    public void onClickBtnGallery(View v){
        Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
        startActivity(intent);
    }
    public void onClickBtnSettings(View v){
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }
}