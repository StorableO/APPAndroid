package com.example.imageswitcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImageDetailActivity extends AppCompatActivity {
    private float currentRating;
//    float[] OldRatings = {0f,0f,0f,0f,0f,0f,0f};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        ImageView imageView = findViewById(R.id.detailImageView);
        TextView nameView = findViewById(R.id.detailName);
        TextView authorView = findViewById(R.id.detailAuthor);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btn = findViewById(R.id.btn01);

        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("imageResId", 0);
        String name = intent.getStringExtra("name");
        String author = intent.getStringExtra("author");
        int index = intent.getIntExtra("id",0);
        float ratingC = intent.getFloatExtra("rating",0f);




        imageView.setImageResource(imageResId);
        nameView.setText(name);
        authorView.setText(author);
        ratingBar.setRating(ratingC);

        btn.setOnClickListener(v -> {
//            Toast.makeText(getBaseContext(),"Rating "+ ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(ImageDetailActivity.this, MainActivity.class);
            intent2.putExtra("NewRating",ratingBar.getRating());
            intent2.putExtra("id", index);
            startActivity(intent2);
        });

        ratingBar.setOnRatingBarChangeListener((bar, rating, fromUser) -> {
            if (fromUser) {
                currentRating = rating;
            }

        });
    }
}