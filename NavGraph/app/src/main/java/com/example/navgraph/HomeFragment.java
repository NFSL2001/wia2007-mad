package com.example.navgraph;

import android.os.Bundle;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
/*
        //get cat button
        Button BtnCat = view.findViewById(R.id.BtnCat);
        View.OnClickListener OCLCat = new View.OnClickListener() { //prepare onclicklistener
            @Override
            public void onClick(View v) {
                // find the navigation controller       nagivate to cat
                Navigation.findNavController(view).navigate(R.id.DestCat);
            }
        };
        BtnCat.setOnClickListener(OCLCat); //bind onclicklistener


        //get dog button
        Button BtnDog = view.findViewById(R.id.BtnDog);
        View.OnClickListener OCLDog = new View.OnClickListener() { //prepare onclicklistener
            @Override
            public void onClick(View v) {
                // find the navigation controller       nagivate to cat
                Navigation.findNavController(view).navigate(R.id.NextToDog);
            }
        };
        BtnDog.setOnClickListener(OCLDog); //bind onclicklistener
*/
        bindViewNavigationToButton(R.id.BtnCat, view, R.id.DestCat); //using Fragment ID
        bindViewNavigationToButton(R.id.BtnDog, view, R.id.NextToDog); //using NavGraph action
    }

    private void bindViewNavigationToButton (Integer buttonID, View view, Integer destinationViewID){
        //get button
        Button BtnBind = view.findViewById(buttonID);
        View.OnClickListener BindingOCL = new View.OnClickListener() { //prepare onclicklistener
            @Override
            public void onClick(View v) {
                // find the navigation controller       nagivate to cat
                Navigation.findNavController(view).navigate(destinationViewID);
            }
        };
        BtnBind.setOnClickListener(BindingOCL); //bind onclicklistener
    }
}