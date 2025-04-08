package com.example.listviewpr;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int[] obrazki = new int[6];
    private final String[] opisy = {
            "Muzyka",
            "Pies",
            "Ptak",
            "Kot",
            "Byk",
            "Adam B"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja obrazków z walidacją
        for (int i = 0; i < obrazki.length; i++) {
            obrazki[i] = getResources().getIdentifier("r" + i , "drawable", getPackageName());
            if (obrazki[i] == 0) {
                Toast.makeText(this, "Brak obrazka r" + i, Toast.LENGTH_SHORT).show();
            }
        }

        ListView listView = findViewById(R.id.listView);
        MyListAdapter adapter = new MyListAdapter(this, obrazki, opisy);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < opisy.length) {
                Toast.makeText(MainActivity.this,
                        "Wybrano: " + opisy[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}