package com.example.isaacglennjaranilla.calculatorwithapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething (View v){

        switch (v.getId()){
            case R.id.btnCalculator:
                i = new Intent(this,Calculator.class);
                startActivity(i);
                break;
            case R.id.btnCurrency:
                i = new Intent(this,Currency.class);
                startActivity(i);
                break;
        }

    }
}

