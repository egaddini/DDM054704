package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SlideShow extends AppCompatActivity {

    ImageView imageView;

    Integer[] imagens = {R.drawable.cachorro, R.drawable.gardem, R.drawable.happy, R.drawable.patinho, R.drawable.porquinho};
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);
        imageView = findViewById(R.id.imageviewSlide);
        position = 0;
        imageView.setImageResource(imagens[position]);
    }

    public void next(View v) {
        if (position == 4) position = 0; else position ++ ;
        imageView.setImageResource(imagens[position]);
    }

    public void home(View v) {
        position = 0;
        imageView.setImageResource(imagens[position]);
    }

    public void previus(View v) {
        if (position == 0) position = 4; else position -- ;
        imageView.setImageResource(imagens[position]);
    }

}