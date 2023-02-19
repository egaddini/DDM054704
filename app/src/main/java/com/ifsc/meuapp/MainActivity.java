package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {

        EditText maxValue = findViewById(R.id.maxValue);
        EditText minValue = findViewById(R.id.minValue);

        int max = Integer.parseInt(maxValue.getText().toString());
        int min = Integer.parseInt(minValue.getText().toString());

        int valor = (int) (Math.random() * (max - min +1) + min);

        TextView text = findViewById(R.id.painel);
        text.setText(Integer.toString(valor));
    }

}