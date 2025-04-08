package com.example.implicity_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebSite extends AppCompatActivity {
    protected Button btnCheckWeb;
    protected EditText editTextWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_site);

        Button btnCheckWeb = findViewById(R.id.btnCheckWeb);
        EditText editTextWeb = findViewById(R.id.editTextWeb);

        btnCheckWeb.setOnClickListener(r ->{
            String Text = editTextWeb.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+Text));
            startActivity(intent);
        });
    }
}