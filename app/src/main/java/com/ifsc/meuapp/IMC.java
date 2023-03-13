package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IMC extends AppCompatActivity {

    ImageView imcImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        imcImage = findViewById(R.id.imageView);
        imcImage.setImageResource(R.drawable.perfil);
    }

    public void calcular(View view) {
        EditText peso = findViewById(R.id.peso);
        EditText altura = findViewById(R.id.altura);

        verificaPeso(Double.parseDouble(peso.getText().toString()), Double.parseDouble(altura.getText().toString())/100);
    }

    private String verificaPeso(Double peso, Double altura) {

        TextView mostraPeso = findViewById(R.id.mostrar);

        Double pesoTotal = (peso / (altura * altura));
        DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");

        String pesoFormatado = decimalFormat.format(pesoTotal).toString();

        if (pesoTotal <= 18.5) {
            mostraPeso.setText(pesoFormatado);
            imcImage.setImageResource(R.drawable.abaixopeso);
            return "";
        }
        if (pesoTotal < 25) {
            mostraPeso.setText(pesoFormatado);
            imcImage.setImageResource(R.drawable.normal);
            return "";
        }
        if (pesoTotal < 30) {
            mostraPeso.setText(pesoFormatado);
            imcImage.setImageResource(R.drawable.obesidade1);
            return "";
        }
        if (pesoTotal < 40) {
            mostraPeso.setText(pesoFormatado);
            imcImage.setImageResource(R.drawable.obesidade2);
            return "";
        }
        mostraPeso.setText(pesoFormatado);
        imcImage.setImageResource(R.drawable.obesidade3);
        return "";
    }
}