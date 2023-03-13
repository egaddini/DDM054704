package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSlide(View view) {
        Intent intent = new Intent(this, SlideShow.class);
        startActivity(intent);
        setContentView(R.layout.activity_slide_show);

    }

    public void onClickIMC(View view) {
        Intent intent = new Intent(this, IMC.class);
        startActivity(intent);
        setContentView(R.layout.activity_imc);
    }

}