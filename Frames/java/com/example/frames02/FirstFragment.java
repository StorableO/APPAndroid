package com.example.frames02;

import android.content.Context;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

 @Override
    public void onAttach(@NonNull Context context){
     super.onAttach(context);
     Toast.makeText(context,"OnAttach() w dzialaniu ",Toast.LENGTH_SHORT).show();
 }
 @Override
    public  void onCreate(@Nullable Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     Toast.makeText(getActivity(),"OnCreate() w dzialaniu ", Toast.LENGTH_SHORT).show();
 }
 @Override
    public void onResume(){
     super.onResume();
     Toast.makeText(getActivity(),"OnResume() w dzialaniu ", Toast.LENGTH_SHORT).show();
 }

 @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedIntanceState){

     View view = inflater.inflate(R.layout.first_fragment, container, false);

     Button firstbtn = view.findViewById(R.id.first_btn);
     TextView text = view.findViewById(R.id.text_frag1);

     firstbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(getActivity(),"Widzisz Pierwszy Fragment",Toast.LENGTH_SHORT).show();
         }
     });
     return view;
 }
}
