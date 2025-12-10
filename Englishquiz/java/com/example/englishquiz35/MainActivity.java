package com.example.englishquiz35;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        InitialItems();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etName.getText().toString().isEmpty()){
                    setStartQuizIntent(etName.getText().toString());
                }else{
                    Toast.makeText(MainActivity.this, "Podaj swoje Imie!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void InitialItems(){
        etName = findViewById(R.id.etName);
        btnStart = findViewById(R.id.btnStart);
    }
    private void setStartQuizIntent(String name){
        Intent intent = new Intent(MainActivity.this, Quiz.class);
        intent.putExtra("NAME", name);
        startActivity(intent);
    }
}