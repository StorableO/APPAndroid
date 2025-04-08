package com.example.activitiesproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private Button button1;
    private EditText editText2;
    private Button button2;
    private EditText editText3;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);
        editText2 = findViewById(R.id.editText2);
        button2 = findViewById(R.id.button2);
        editText3 = findViewById(R.id.editText3);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText1.getText().toString();
                Intent intent = new Intent(MainActivity.this, Pole_kola_activity.class);
                intent.putExtra("EXTRA_TEXT1", text);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText2.getText().toString();
                Intent intent = new Intent(MainActivity.this, Pole_kwadratu_activity.class);
                intent.putExtra("EXTRA_TEXT2", text);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText1.getText().toString();
                Intent intent = new Intent(MainActivity.this, Password_verif_activity.class);
                intent.putExtra("EXTRA_TEXT3", text);
                startActivity(intent);
            }
        });
    }
}