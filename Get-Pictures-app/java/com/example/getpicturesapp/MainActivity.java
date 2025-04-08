package com.example.getpicturesapp;

import android.content.Intent;
import android.net.Uri;
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

public class MainActivity extends AppCompatActivity {

    Integer[] obrazki = new Integer[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i<obrazki.length; i++){
            obrazki[i] = getResources().getIdentifier("r" + i,"drawable", getPackageName());
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter((ListAdapter) new ImageAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v,int position, long id){
                Toast.makeText(getBaseContext(), "Wybrano obrazek nr."+position, Toast.LENGTH_SHORT).show();
                String pos = Integer.toString(position);
                Intent intent = new Intent(MainActivity.this, Obrazek.class);
                intent.putExtra(Intent.EXTRA_TEXT, pos);
                startActivity(intent);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return obrazki.length;
        }

        @Override
        public Object getItem(int position){
            return obrazki[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }

    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(getBaseContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(500,500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(10,10,10,10);
        }else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(obrazki[position]);
        return imageView;
    }
}}