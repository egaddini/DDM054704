package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i;
    TextView tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tc = findViewById(R.id.textviewhello);
        i = 0;
        tc.setText(Integer.toString(i));
    }

    public void contaClick(View view) {
        i++;
        tc.setText(Integer.toString(i));
    }
}