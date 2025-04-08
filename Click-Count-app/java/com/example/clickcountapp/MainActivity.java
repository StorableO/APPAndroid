package com.example.clickcountapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int ilosc = 0;
    Button btn_plus;
    Button btn_minus;
    Button btn_reset;
    TextView txt_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_count = findViewById(R.id.textView);
        btn_plus = findViewById(R.id.button_plus);
        btn_minus = findViewById(R.id.button_minus);
        btn_reset = findViewById(R.id.button_reset);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ilosc >= 20){
                    txt_count.setText("Maksymalnie "+ Integer.toString(ilosc) +" razy");
                }else{
                    ilosc++;
                    txt_count.setText("kliknięto: "+ Integer.toString(ilosc) +" raz");
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ilosc <= -19){
                    txt_count.setText("Minimalnie: "+ -20 +" razy");
                }else{
                    ilosc-=2;
                    txt_count.setText("kliknięto: "+ Integer.toString(ilosc) +" raz");
                }
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilosc = 0;
                txt_count.setText("kliknięto: "+ Integer.toString(ilosc));
            }
        });


    }
}