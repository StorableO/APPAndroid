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

public class Pole_kwadratu_activity extends AppCompatActivity {

    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pole_kwadratu);

        textView = findViewById(R.id.textViewkwadrat);

        Intent intent = getIntent();
        int recived = Integer.parseInt(intent.getStringExtra("EXTRA_TEXT2"));
        double pole = recived*recived;
        textView.setText("Pole kwadratu: " + Double.toString(pole));
    }
}