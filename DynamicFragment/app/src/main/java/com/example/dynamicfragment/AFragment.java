package com.example.dynamicfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(getArguments()!= null) {
            String name  = getArguments().getString("Name");
            int roll = getArguments().getInt("Roll");

            Log.d("values are",name+roll);


            ((MainActivity)getActivity()).callFromFragment();
        }

        View v =  inflater.inflate(R.layout.fragment_a, container, false);


        return v;
    }





}