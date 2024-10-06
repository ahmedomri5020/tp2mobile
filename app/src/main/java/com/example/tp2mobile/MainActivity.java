package com.example.tp2mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText text1, text2;
    RadioGroup operationGroup;
    RadioButton r1, r2, r3, r4;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcule);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        btnCalculate = findViewById(R.id.btn);
        res = findViewById(R.id.res);

        operationGroup = findViewById(R.id.operationGroup);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Champs vide", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(text1.getText().toString());
                int num2 = Integer.parseInt(text2.getText().toString());

                int result = 0;

                if (r1.isChecked()) {
                    result = num1 + num2;
                } else if (r2.isChecked()) {
                    result = num1 - num2;
                } else if (r3.isChecked()) {
                    result = num1 * num2;
                } else if (r4.isChecked()) {
                    if (num2 == 0) {
                        Toast.makeText(MainActivity.this, "Division par zéro impossible", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                } else {
                    Toast.makeText(MainActivity.this, "Sélectionnez une opération", Toast.LENGTH_SHORT).show();
                    return;
                }

                res.setText(String.valueOf(result));
            }
        });
    }
}
