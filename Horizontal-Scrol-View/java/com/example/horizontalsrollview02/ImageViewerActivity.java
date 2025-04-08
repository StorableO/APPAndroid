package com.example.horizontalsrollview02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ImageViewerActivity extends AppCompatActivity {
    private String[] imageInfo = {
            "Obraz 1 - Autor: Jan Kowalski, Rozmiar: 500 KB",
            "Obraz 2 - Autor: Anna Nowak, Rozmiar: 600 KB",
            "Obraz 3 - Autor: Piotr Wiśniewski, Rozmiar: 550 KB"
    };
    Integer[] obrazki = new Integer[6];
    private ImageSwitcher imageSwitcher;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_viewer);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new com.example.horizontalsrollview02.MyViewFactory(this));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right));

        for (int i = 0; i<obrazki.length; i++){
            obrazki[i] = getResources().getIdentifier("r" + i,"drawable", getPackageName());
        }

        Button btnPrevious = findViewById(R.id.btnPrevious);
        Button btnNext = findViewById(R.id.btnNext);

        id = Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra(Intent.EXTRA_TEXT)));
        Toast.makeText(getBaseContext(), "Wybrano obrazek nr."+id, Toast.LENGTH_SHORT).show();

        loadImage(id);

        btnPrevious.setOnClickListener(v -> {
            if (id>1) {
                id -= 1;
                loadImage(id);
            }else{
                Toast.makeText(getBaseContext(), "Za malo zdjec", Toast.LENGTH_SHORT).show();
            }
        });

        btnNext.setOnClickListener(v -> {
            if(id < obrazki.length){
                id += 1;
                loadImage(id);
            }else{
                Toast.makeText(getBaseContext(), "Za malo zdjec", Toast.LENGTH_SHORT).show();
            }

        });
    }
    private void loadImage(int id) {

          imageSwitcher.setImageResource(obrazki[id]);

    }
    class MyViewFactory implements ViewSwitcher.ViewFactory {
        Context context;
        public MyViewFactory(Context c){
            context = c;
        }
        @Override
        public View makeView() {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setLayoutParams(new
                    FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    }
}