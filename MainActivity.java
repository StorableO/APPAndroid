package com.example.resourceapp;

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

public class MainActivity extends AppCompatActivity {
    private String[] questions = {
            "Stolicą Polski jest ...",
            "Najduższa rzeka Polski to ...",
            "Pierwszy władca Polski to ..."
    };
    private String[] correctAnswers = {
            "Warszawa", "Wisa", "Mieszko"
    };
    private int currentAnswerIndex = 0;
    private TextView textViewQuestion;
    private EditText editTextAnswer;
    private Button buttonCheck;

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

        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonCheck = findViewById(R.id.buttonCheck);

        showQuestion();
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkAnswer();
           }
     });

    }


    private void showQuestion() {
        textViewQuestion.setText(questions[currentAnswerIndex]);
        editTextAnswer.setText("");
    }

    private void checkAnswer() {
        String correctAnswer = correctAnswers[currentAnswerIndex];
        String userAnswer = editTextAnswer.getText().toString().trim();
        if (correctAnswer.equalsIgnoreCase(userAnswer)) {
            Toast.makeText(this, "Poprawna odpowiedz! :)", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Zła odpowiedz! :(", Toast.LENGTH_LONG).show();
        }
        currentAnswerIndex = (currentAnswerIndex+1)%questions.length;
        showQuestion();
    }
}