package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvHelloWorld;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloWorld = findViewById(R.id.tvHelloWorld);
    }

    public void onClick(View view) {
        counter ++;
        tvHelloWorld.setText(Integer.toString(counter));
    }

}