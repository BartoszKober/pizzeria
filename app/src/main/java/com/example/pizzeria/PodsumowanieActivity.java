package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class PodsumowanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podsumowanie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        float price = getIntent().getFloatExtra("cena", 0);
        TextView SummaryTextView = findViewById(R.id.SummaryTextView);
        TextView RozmiarTextview = findViewById(R.id.RozmiarTextView);
        TextView CiastoTextview = findViewById(R.id.CiastoTextView);
        TextView IloscTextview = findViewById(R.id.SztukTextView);

        RozmiarTextview.setText(getIntent().getStringExtra("rozmiar"));
        CiastoTextview.setText(getIntent().getStringExtra("Ciasto"));
        IloscTextview.setText(getIntent().getStringExtra("ilosc"));


        SummaryTextView.setText("Razem: "+price+" PLN");


        Button button = findViewById(R.id.GoBackBtn);
        button.setOnClickListener(v -> {
            finish();
        });

    }
}