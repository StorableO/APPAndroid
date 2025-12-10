package com.example.zapisdannychlocal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "FavoriteGames";
    private static final String FAVORITE_GAME_KEY = "favorite_game";

    private LinearLayout cs2Card, valorantCard, minecraftCard, lolCard, rustCard, wotCard;
    private TextView twCS2, twValorant, twMinecraft, twLoL,twRust, twWot;

    private String currentFavoriteGame = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupClickListeners();
        loadFavoriteGame();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFavoriteGame();
    }

    private void initializeViews() {
        cs2Card = findViewById(R.id.cs2Card);
        valorantCard = findViewById(R.id.valorantCard);
        minecraftCard = findViewById(R.id.minecraftCard);
        lolCard = findViewById(R.id.lolCard);
        rustCard = findViewById(R.id.rustCard);
        wotCard = findViewById(R.id.wotCard);

        twCS2 = findViewById(R.id.twCS2);
        twValorant = findViewById(R.id.twValorant);
        twMinecraft = findViewById(R.id.twMinecraft);
        twLoL = findViewById(R.id.twLoL);
        twRust = findViewById(R.id.twRust);
        twWot = findViewById(R.id.twWot);

    }

    private void setupClickListeners() {
        cs2Card.setOnClickListener(v -> openGameDetails("CS2"));
        valorantCard.setOnClickListener(v -> openGameDetails("Valorant"));
        minecraftCard.setOnClickListener(v -> openGameDetails("Minecraft"));
        lolCard.setOnClickListener(v -> openGameDetails("LoL"));
        rustCard.setOnClickListener(v -> openGameDetails("Rust"));
        wotCard.setOnClickListener(v -> openGameDetails("Wot"));
    }

    private void openGameDetails(String gameName) {
        Intent intent = new Intent(MainActivity.this, Activity_details.class);
        intent.putExtra("GAME_NAME", gameName);
        startActivity(intent);
    }

    private void loadFavoriteGame() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        currentFavoriteGame = prefs.getString(FAVORITE_GAME_KEY, "");
        highlightFavoriteGame();
    }

    private void highlightFavoriteGame() {
        resetFavoriteGame();
        switch (currentFavoriteGame) {
            case "CS2":
                twCS2.setText("CS2 - ⭐");
                break;
            case "Valorant":
                twValorant.setText("Valorant - ⭐");
                break;
            case "Minecraft":
                twMinecraft.setText("Minecraft - ⭐");
                break;
            case "LoL":
                twLoL.setText("LoL - ⭐");
                break;
            case "Rust":
                twRust.setText("Rust - ⭐");
                break;
            case "Wot":
                twWot.setText("Wot - ⭐");
                break;
        }
    }
    private void resetFavoriteGame(){
        twCS2.setText("CS2");
        twCS2.setText("CS2");
        twValorant.setText("Valorant");
        twMinecraft.setText("Minecraft");
        twLoL.setText("LoL");
        twRust.setText("Rust");
        twWot.setText("Wot");
    }
}