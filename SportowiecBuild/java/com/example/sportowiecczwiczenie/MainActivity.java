package com.example.sportowiecczwiczenie;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
        private TextView tvID, tvName, tvSurname, tvEmail, tvCreateDate, tvModifyDate;
        private Button btnEdit;

        private String playerID = "1";
        private String playerName = "Jan";
        private String playerSurname = "Kowalski";
        private String playerEmail ="Jan.Kowalski@gmail.com";
        private String createDate;
        private String modifyDate;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initializeViews();
            setupInitialData();
            setupButtonListener();
        }

        private void initializeViews() {
            tvID = findViewById(R.id.tvID);
            tvName = findViewById(R.id.tvName);
            tvSurname = findViewById(R.id.tvSurname);
            tvEmail = findViewById(R.id.tvEmail);
            tvCreateDate = findViewById(R.id.tvCreate);
            tvModifyDate = findViewById(R.id.tvModify);
            btnEdit = findViewById(R.id.btnEdit);
        }

        private void setupInitialData() {
            createDate = LocalDate.of(1999,10,21).toString();
            modifyDate = "Nie modyfikowano";

            updateDisplay();
        }
        private void updateDisplay() {
        tvID.setText(playerID);
        tvName.setText(playerName);
        tvSurname.setText(playerSurname);
        tvEmail.setText(playerEmail);
        tvCreateDate.setText(createDate);
        tvModifyDate.setText(modifyDate);
    }
        private void setupButtonListener() {
            btnEdit.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("ID", playerID);
                intent.putExtra("NAME", playerName);
                intent.putExtra("SURNAME", playerSurname);
                intent.putExtra("EMAIL", playerEmail);
                startActivityForResult(intent, 1);
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK) {
                playerID = data.getStringExtra("ID");
                playerName = data.getStringExtra("NAME");
                playerSurname = data.getStringExtra("SURNAME");
                playerEmail = data.getStringExtra("EMAIL");
                modifyDate = LocalDate.now().toString();

                updateDisplay();
            }
        }
    }