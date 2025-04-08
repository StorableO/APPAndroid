package com.example.imageswitcher;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageSwitcher imageSwitcher;
    String[] imageNames = {"Obrazek 1", "Obrazek 2", "Obrazek 3", "Obrazek 4", "Obrazek 5", "Obrazek 6", "Obrazek 7"};
    String[] authors = {"Autor 1", "Autor 2", "Autor 3", "Autor 4", "Autor 5", "Autor 6", "Autor 7"};
    float[] ratings = {3.5f, 4.0f, 2.5f, 5.0f, 3.0f, 4.5f, 3.8f};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        Intent intent2 = getIntent();
        int id = intent2.getIntExtra("id", 0);
        float NewRating = intent2.getFloatExtra("NewRating", 0f);
        ratings[id] = NewRating;



        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new MyViewFactory(this));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));



        for (int i = 0; i < 7; i++) {
            ImageView localView = new ImageView(this);
            localView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int resId = getResources().getIdentifier("r" + i, "drawable", getPackageName());
            localView.setImageResource(resId);
            localView.setTag(i);
            localView.setOnClickListener(this);
            linearLayout.addView(localView);
        }

    }

    public void onClick(View view) {
        int index = (int) view.getTag();
        int resId = getResources().getIdentifier("r" + index, "drawable", getPackageName());
        imageSwitcher.setImageResource(resId);

        Intent intent = new Intent(MainActivity.this, ImageDetailActivity.class);
        intent.putExtra("imageResId", resId);
        intent.putExtra("name", imageNames[index]);
        intent.putExtra("author", authors[index]);
        intent.putExtra("id", index);
        intent.putExtra("rating", ratings[index]);
        startActivity(intent);
    }
}
