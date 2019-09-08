package com.raju.calculatetaxamount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText monthlySalaryText;
    private EditText taxAmountText;
    private Button calculateTaxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthlySalaryText = findViewById(R.id.activity_main_entered_salary);
        taxAmountText = findViewById(R.id.activity_main_tax_amount);
        calculateTaxBtn = findViewById(R.id.activity_main_find_tax_btn);

        calculateTaxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double yearlySalary = 12 * Double.parseDouble(monthlySalaryText.getText().toString());
                taxAmountText.setText(Double.toString(calculateTax(yearlySalary)));
            }
        });
    }

    private double calculateTax(double salary){
        double tax = 0;
        if(salary >= 1 && salary < 200000){
            tax = salary / 100; 
        }
        else if(salary >= 200000 && salary < 350000){
            tax = (200000/100) + ((salary - 200000) * 15)/100;
        }
        else{
            tax = (200000/100) + (150000*15)/100 + ((salary - 3500000)* 25)/100;
        }
        return tax;
    }
}
