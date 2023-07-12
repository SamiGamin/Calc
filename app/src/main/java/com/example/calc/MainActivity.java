package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String currentNumber = "";
    private double result = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
    }

    public void onButtonClick(View view){
        Button button =(Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText){
            case "C":
                currentNumber="";
                result=0;
                operator="";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                result = Double.parseDouble(currentNumber);
                currentNumber = "";
                break;
            case "=":
                double secondNumber = Double.parseDouble(currentNumber);

                switch (operator) {
                    case "+":
                        result += secondNumber;
                        break;
                    case "-":
                        result -= secondNumber;
                        break;
                    case "*":
                        result *= secondNumber;
                        break;
                    case "/":
                        result /= secondNumber;
                        break;
                }

                currentNumber = String.valueOf(result);
                result = 0;
                operator = "";
                break;
            default:
                currentNumber += buttonText;
                break;



        }
        tvResult.setText(currentNumber);
    }
}