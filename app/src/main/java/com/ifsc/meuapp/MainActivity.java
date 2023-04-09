package com.ifsc.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {

    MyPaint myPaint;
    ImageView ivColorPicker;
    SeekBar seekBar;
    Button apagar, apagartudo, quadrado, linha, circulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPaint = findViewById(R.id.myPaint);
        seekBar = findViewById(R.id.seekBar);
        apagar = findViewById(R.id.apg);
        apagartudo = findViewById(R.id.apgtd);
        linha = findViewById(R.id.line);
        quadrado = findViewById(R.id.square);
        circulo = findViewById(R.id.circle);

        ivColorPicker = findViewById(R.id.ivColorPicker);
        ivColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorPickerSelectColor();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setStroke(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void colorPickerSelectColor() {
        new ColorPickerDialog.Builder(this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton(getString(R.string.confirm),
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true) // the default value is true.
                .attachBrightnessSlideBar(true)  // the default value is true.
                .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                .show();
    }

    private void setColor(ColorEnvelope envelope) {
        myPaint.setCurrentPaintColor(Color.valueOf(envelope.getColor()));
        ivColorPicker.setColorFilter((Color.valueOf(envelope.getColor())).toArgb());
    }

    private void setStroke(int width) {
        myPaint.setCurrentLayerWidth(width);
    }

    public void onClickApagar(View view) {
        myPaint.apagaTudo();
    }

    public void onClickApagarUlt(View view) {
        myPaint.apagaUlt();
    }

}