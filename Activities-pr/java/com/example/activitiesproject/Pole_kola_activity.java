package com.example.activitiesproject;

import android.content.Intent;
import android.location.altitude.AltitudeConverter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pole_kola_activity extends AppCompatActivity {

    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pole_kola);

        textView = findViewById(R.id.textViewkolo);

        Intent intent = getIntent();
        int recived = Integer.parseInt(intent.getStringExtra("EXTRA_TEXT1"));
        double pole = recived*recived*3.14;
        textView.setText("Pole kola:" + Double.toString(pole));
    }
}