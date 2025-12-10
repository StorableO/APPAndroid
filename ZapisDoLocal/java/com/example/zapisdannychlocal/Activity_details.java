package com.example.zapisdannychlocal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_details extends AppCompatActivity {

    private static final String PREFS_NAME = "FavoriteGames";
    private static final String FAVORITE_GAME_KEY = "favorite_game";
    private TextView gameTitle, gameDescription;
    private ImageView gameImage;
    private Button btnSetFavorite;

    private String currentGameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        initializeViews();
        loadGameData();
        setupButtonListener();
    }
    private void initializeViews() {
        gameTitle = findViewById(R.id.gameTitle);
        gameDescription = findViewById(R.id.gameDescription);
        gameImage = findViewById(R.id.gameImageDetail);
        btnSetFavorite = findViewById(R.id.btnSetFavorite);
    }
    private void loadGameData() {
        currentGameName = getIntent().getStringExtra("GAME_NAME");
        if (currentGameName != null) {
            displayGameDetails(currentGameName);
        }
    }
    private void displayGameDetails(String gameName) {
        switch (gameName) {
            case "CS2":
                gameTitle.setText("Counter-Strike 2");
                gameDescription.setText("Counter-Strike 2 to odświeżona wersja legendarnego shooter taktycznego. Gracze wcielają się w terrorystów lub antyterrorystów w intensywnych rozgrywkach opartych na pracy zespołowej i strategicznym myśleniu.");
                gameImage.setImageResource(R.drawable.cs2);
                break;
            case "Valorant":
                gameTitle.setText("Valorant");
                gameDescription.setText("Valorant to taktyczny shooter pierwszoosobowy łączący elementy strzelanek z umiejętnościami bohaterów. Każdy agent posiada unikalne zdolności, które mogą zmienić przebieg rundy.");
                gameImage.setImageResource(R.drawable.valorant);
                break;
            case "Minecraft":
                gameTitle.setText("Minecraft");
                gameDescription.setText("Minecraft to gra sandboxowa oferująca nieograniczone możliwości tworzenia i eksploracji. Gracze mogą budować, craftować i przetrwać w świecie złożonym z bloków.");
                gameImage.setImageResource(R.drawable.minecraft);
                break;
            case "LoL":
                gameTitle.setText("League of Legends");
                gameDescription.setText("League of Legends to popularna gra MOBA, w której dwie drużyny pięcioosobowe rywalizują, by zniszczyć nexus przeciwnika. Gracze wybierają spośród setek championów o unikalnych umiejętnościach.");
                gameImage.setImageResource(R.drawable.lol);
                break;
            case "Rust":
                gameTitle.setText("Rust");
                gameDescription.setText("Rust to grę komputerową typu survival, w której gracze walczą o przetrwanie, zbierając surowce i budując schronienia, lub język programowania, który kładzie nacisk na bezpieczeństwo pamięci i wydajność");
                gameImage.setImageResource(R.drawable.rust);
                break;
            case "Wot":
                gameTitle.setText("Wot");
                gameDescription.setText("Wot to gra symulacyjna typu MMO (Massively Multiplayer Online) oparta na modelu free-to-play, w której gracze walczą w bitwach pancernych, sterując czołgami z połowy XX wieku");
                gameImage.setImageResource(R.drawable.wot);
                break;
        }
    }
    private void setupButtonListener() {
        btnSetFavorite.setOnClickListener(v -> setAsFavorite());
    }
    private void setAsFavorite() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(FAVORITE_GAME_KEY, currentGameName);
        editor.apply();

        Toast.makeText(this, "Ustawiono ulubiona gre", Toast.LENGTH_SHORT).show();
        finish();
    }
}