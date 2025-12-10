package com.example.englishquiz35;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    private TextView etSlowo, etBledy, etWynik;
    private EditText etTlumaczenie;
    private Button btnSprawdz, btnZakoncz, btnZagraj;
    private int licznik = 0;
    private String Name = "";
    Random random = new Random();
    private List<Integer> availableIndices = new ArrayList<>();
    private int currentIndex;

    private String[][] words = {
            {"cat", "kot"},
            {"dog", "pies"},
            {"car", "samochód"},
            {"apple", "jabłko"},
            {"school", "szkoła"},
            {"house", "dom"},
            {"book", "książka"},
            {"sun", "słońce"},
            {"tree", "drzewo"},
            {"milk", "mleko"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        InitialItems();
        LoadIntentData();
        initializeQuiz();

        btnSprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void InitialItems(){
        etSlowo = findViewById(R.id.etSlowo);
        etBledy = findViewById(R.id.etBledy);
        etTlumaczenie = findViewById(R.id.etTlumaczenie);
        btnSprawdz = findViewById(R.id.btnSprawdz);
        btnZagraj = findViewById(R.id.btnZagrajPonow);
        btnZakoncz = findViewById(R.id.btnZakoncz);
        etWynik = findViewById(R.id.twWynik);
    }

    private void LoadIntentData(){
        Intent intent = getIntent();
        Name = intent.getStringExtra("NAME");
    }

    private void initializeQuiz() {
        for (int i = 0; i < words.length; i++) {
            availableIndices.add(i);
        }
        Collections.shuffle(availableIndices);

        getNextWord();
    }

    private void getNextWord() {
        if (availableIndices.isEmpty()) {
            endQuiz();
            return;
        }
        currentIndex = availableIndices.remove(0);
        etSlowo.setText(words[currentIndex][0]);
        etTlumaczenie.setText("");
    }

    private void checkAnswer() {
        String userAnswer = etTlumaczenie.getText().toString().trim();
        String correctAnswer = words[currentIndex][1];

        if (userAnswer.equals(correctAnswer)) {
            Toast.makeText(Quiz.this, "Poprawna odpowiedź!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Quiz.this, "Niepoprawna odpowiedź!", Toast.LENGTH_SHORT).show();
            licznik++;
            etBledy.setText("Ilość błędów: " + licznik);
        }
        getNextWord();
    }

    private void endQuiz() {
        etSlowo.setVisibility(INVISIBLE);
        etTlumaczenie.setVisibility(INVISIBLE);
        btnSprawdz.setVisibility(INVISIBLE);
        etBledy.setVisibility(INVISIBLE);

        etWynik.setVisibility(VISIBLE);
        btnZakoncz.setVisibility(VISIBLE);
        btnZagraj.setVisibility(VISIBLE);

        String resultMessage = "Gratulacje, " + Name.toString().trim() +"! Ukończyłeś quiz. Liczba błędnych odpowiedzi: "+ licznik;
        etWynik.setText(resultMessage);

        btnZakoncz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnZagraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSlowo.setVisibility(VISIBLE);
                etTlumaczenie.setVisibility(VISIBLE);
                btnSprawdz.setVisibility(VISIBLE);
                etBledy.setVisibility(VISIBLE);

                etWynik.setVisibility(INVISIBLE);
                btnZakoncz.setVisibility(INVISIBLE);
                btnZagraj.setVisibility(INVISIBLE);
                etBledy.setText("Ilosc bledow: 0");
                licznik = 0;
                initializeQuiz();
            }
        });
    }
}