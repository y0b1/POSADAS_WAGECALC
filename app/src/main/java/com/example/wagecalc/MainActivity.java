package com.example.wagecalc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGrossSalary, editTextTax;
    private TextView textViewNetSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGrossSalary = findViewById(R.id.editTextGrossSalary);
        editTextTax = findViewById(R.id.editTextTax);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewNetSalary = findViewById(R.id.textViewNetSalary);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateNetSalary();
            }
        });
    }

    private void calculateNetSalary() {
        String grossSalaryStr = editTextGrossSalary.getText().toString().trim();
        String taxPercentageStr = editTextTax.getText().toString().trim();

        if (TextUtils.isEmpty(grossSalaryStr) || TextUtils.isEmpty(taxPercentageStr)) {
            textViewNetSalary.setText("Please enter valid values.");
            return;
        }

        double grossSalary = Double.parseDouble(grossSalaryStr);
        double taxPercentage = Double.parseDouble(taxPercentageStr);

        double taxAmount = (taxPercentage / 100) * grossSalary;
        double netSalary = grossSalary - taxAmount;

        textViewNetSalary.setText(String.format("Net Salary: %.2f", netSalary));
    }
}
