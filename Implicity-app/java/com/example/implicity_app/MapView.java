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

public class MapView extends AppCompatActivity {
    protected Button btnCheckMap;
    protected EditText editTextKoord1;
    protected EditText editTextKoord2;
    protected EditText editTextCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_map_view);

        Button btnCheckMap = findViewById(R.id.btnMap);
        EditText editTextKoord1 = findViewById(R.id.editTextKoord1);
        EditText editTextKoord2 = findViewById(R.id.editTextKoord2);
        EditText editTextCity= findViewById(R.id.editTextCity);

        btnCheckMap.setOnClickListener(r ->{
            String Text = editTextKoord1.getText().toString() +","+ editTextKoord2.getText().toString()+"?q="+editTextCity.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+Text));
            startActivity(intent);
        });
    }
}