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
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    ImageSwitcher imageSwitcher;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout =
                (LinearLayout) findViewById(R.id.linearLayout);
        btn = (Button) findViewById(R.id.btn1);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new MyViewFactory(this));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right));
        for (int i = 0; i < 7; i++) {
            ImageView localView = new ImageView(this);
            localView.setLayoutParams(
                    new ViewGroup.LayoutParams(400, 400));
            localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int resId = getResources().getIdentifier("r" + i, "drawable",
                    getPackageName());
            localView.setTag(i);
            localView.setImageResource(resId);
            localView.setOnClickListener(this);
            linearLayout.addView(localView);
//          Toast.makeText(getBaseContext(), "Wybrano obrazek nr."+i, Toast.LENGTH_SHORT).show();

        }
    }
    public void onClick(View view) {
    ImageView localview = (ImageView) view;
    imageSwitcher.setImageDrawable(localview.getDrawable());
     int index = (int) view.getTag();
     btn.setOnClickListener(v -> {
         String id = Integer.toString(index);
         Intent intent = new Intent(MainActivity.this, ImageViewerActivity.class);
         intent.putExtra(Intent.EXTRA_TEXT, id);
         startActivity(intent);
     });
//
    }
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