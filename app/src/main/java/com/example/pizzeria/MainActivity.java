package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        CheckBox isThickCheckBox = findViewById(R.id.isThickCheckbox);
        EditText amountEditText = findViewById(R.id.EditTextAmount);

        Button button = findViewById(R.id.SummaryBtn);
        button.setOnClickListener(v -> {
            float price = 0;
            String rozmiar = "";
            String Ciasto = "Cienkie";
            int checkedId = radioGroup.getCheckedRadioButtonId();
            if (checkedId != -1) {
                if (checkedId == 1) {
                    price = 25;
                    rozmiar = "Mała";
                } else if (checkedId == 2) {
                    price = 35;
                    rozmiar = "Średnia";
                } else if (checkedId == 3) {
                    price = 45;
                    rozmiar = "Duża";
                }
                if (isThickCheckBox.isChecked() == true) {
                    price += 5;
                    Ciasto = "Grube";
                }
                String text = amountEditText.getText().toString().trim();
                int amount = Integer.parseInt(text);
                price *= amount;

                Intent intent = new Intent(this, PodsumowanieActivity.class);
                intent.putExtra("cena", price);
                intent.putExtra("rozmiar", rozmiar);
                intent.putExtra("Ciasto", Ciasto);
                intent.putExtra("ilosc", ""+amount);
                startActivity(intent);
            }else {
                Toast.makeText(this, "wybierz rozmiar", Toast.LENGTH_SHORT);
            }




        });
    }
}