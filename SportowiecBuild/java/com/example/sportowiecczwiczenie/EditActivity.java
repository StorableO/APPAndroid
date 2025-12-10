package com.example.sportowiecczwiczenie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditActivity extends AppCompatActivity {
    private EditText etID, etName, etSurname, etEmail;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initializeViews();
        loadPlayerData();
        setupSaveButton();
    }

    private void initializeViews() {
        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);
    }

    private void loadPlayerData() {
        Intent intent = getIntent();
        etID.setText(intent.getStringExtra("ID"));
        etName.setText(intent.getStringExtra("NAME"));
        etSurname.setText(intent.getStringExtra("SURNAME"));
        etEmail.setText(intent.getStringExtra("EMAIL"));
    }

    private void setupSaveButton() {
        btnSave.setOnClickListener(v -> {
            if (validateData()) {
                saveChanges();
            }
        });
    }

    private boolean validateData() {
        String email = etEmail.getText().toString().trim();

        if (etID.getText().toString().trim().isEmpty()) {
            showToast("ID nie może być puste");
            return false;
        }

        if (etName.getText().toString().trim().isEmpty()) {
            showToast("Imię nie może być puste");
            return false;
        }

        if (etSurname.getText().toString().trim().isEmpty()) {
            showToast("Nazwisko nie może być puste");
            return false;
        }

        if (email.isEmpty()) {
            showToast("E-mail nie może być pusty");
            return false;
        }

        if (!isValidEmail(email)) {
            showToast("Nieprawidłowy format e-mail");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }

    private void saveChanges() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("ID", etID.getText().toString().trim());
        resultIntent.putExtra("NAME", etName.getText().toString().trim());
        resultIntent.putExtra("SURNAME", etSurname.getText().toString().trim());
        resultIntent.putExtra("EMAIL", etEmail.getText().toString().trim());

        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}