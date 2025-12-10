package com.example.zadanie22201czer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnPlus, btnMinus, btnSave;
    private TextView tvLikes;
    private Integer index = 0;
    private static final String PREFS_NAME = "Domek_w_gorach_likes";
    private static final String FAVORITE_KEY = "likes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        InitialItems();
        LoadReferense();

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                tvLikes.setText(index + " polubien");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index > 0){
                    index--;
                    tvLikes.setText(index+ " polubien");
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveReferense();
            }
        });
    }
    private void InitialItems(){
        btnPlus = findViewById(R.id.btnIncrease);
        btnMinus = findViewById(R.id.btnDecrease);
        tvLikes = findViewById(R.id.tvLikes);
        btnSave = findViewById(R.id.btnSave);
    }
    private void SaveReferense(){
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(FAVORITE_KEY, index.toString());
        editor.apply();

        Toast.makeText(this, "Zapisano likes", Toast.LENGTH_SHORT).show();
    }
    private void LoadReferense() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        index = Integer.parseInt(prefs.getString(FAVORITE_KEY, "0"));
        tvLikes.setText(index + " polubien");
    }
}
// ***********************************************************************************
// nazwa funkcji:   <LoadReferense()>
// argumenty:       <Brak>
// typ zwracalny:   <void>, <Nie zwracawartosci>
// informacje:      <Wczytuje index zapisany wczesniej w strukturze SharedPreference
//                   i ustawia wartosc tvLikes zgodnie z tym indexem>
// autor:           <05303008412>
//************************************************************************************