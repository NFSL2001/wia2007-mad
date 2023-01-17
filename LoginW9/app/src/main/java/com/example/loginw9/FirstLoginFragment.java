package com.example.loginw9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstLoginFragment extends Fragment {


    public FirstLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_login, null, false);
        Button BtnSubmit = view.findViewById(R.id.BtnSubmit);
        Context context = view.getContext();
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ETusername = getView().findViewById(R.id.ETUsername);
                String filename = "user_file";
                String fileContents = ETusername.getText().toString();
                if (fileContents.length() == 0){
                    Toast.makeText(context, "Please input a username", Toast.LENGTH_SHORT).show();
                    return;
                }
                try(FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)){
                    fos.write(fileContents.getBytes(StandardCharsets.UTF_8));
                } catch (FileNotFoundException f) {
                    f.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}