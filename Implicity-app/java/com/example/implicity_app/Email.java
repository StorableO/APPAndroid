package com.example.implicity_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Email extends AppCompatActivity {
    protected Button btnCheckMail;
    protected EditText editTextMail;
    protected EditText editTextMailHeader;
    protected EditText editTextMailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_email);

        Button btnCheckMail = findViewById(R.id.btnMail);
        EditText editTextMail = findViewById(R.id.editTextMail);
        EditText editTextMailHeader = findViewById(R.id.editTextMailHeader);
        EditText editTextMailText = findViewById(R.id.editTextMailText);

        btnCheckMail.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"+editTextMail.getText().toString()));
            intent.putExtra(Intent.EXTRA_SUBJECT, editTextMailHeader.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, editTextMailText.getText().toString());
            startActivity(intent);
        });

    }
}