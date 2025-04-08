package com.example.fragments01;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

//    public SimpleFragment() {
//        // Required empty public constructor
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);

        // Znajdź TextView i ustaw tekst
//        TextView textView = rootView.findViewById(R.id.textView);
//        textView.setText("Hello, this is a simple fragment!");

        return rootView;   
    }
}

