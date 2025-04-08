package com.example.getpicturesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Obrazek extends AppCompatActivity {

    Integer[] obrazki = new Integer[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obrazek);


        int id = Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra(Intent.EXTRA_TEXT)));
        obrazki[0] = getResources().getIdentifier("r" + id,"drawable", getPackageName());
        Toast.makeText(getBaseContext(), "Wybrano obrazek nr++++."+id, Toast.LENGTH_SHORT).show();

        GridView gridView = (GridView) findViewById(R.id.imgView);
        gridView.setAdapter(new Obrazek.ImageAdapter());

    }
    public class ImageAdapter extends BaseAdapter{
        public View getView(int position,View convertView, ViewGroup parent){
            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(getBaseContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(800,1500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(10,10,10,10);
            }else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(obrazki[0]);
            return imageView;
        }
    }}