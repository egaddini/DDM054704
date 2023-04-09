package com.ifsc.meuapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyPaint extends View {
    private List<Paint> mPaints = new ArrayList<>();
    private List<Path> mPaths = new ArrayList<>();
    private Paint mPaint;
    private Path mPath;

    private int colorNumber = -16777216;

    private int lineStrokeWidth = 5;

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(colorNumber);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(lineStrokeWidth);
        mPaints.add(mPaint);
        mPaths.add(mPath);

    }

    public void addNewLayer() {
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(colorNumber);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(lineStrokeWidth);
        mPaints.add(mPaint);
        mPaths.add(mPath);
        invalidate();
    }

    public void setCurrentPaintColor(Color color) {
        mPaint.setColor(color.toArgb());
        colorNumber = color.toArgb();
    }

    public void setCurrentLayerWidth(int width) {
        mPaint.setStrokeWidth(width);
        lineStrokeWidth = width;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mPaths.size(); i++) {
            canvas.drawPath(mPaths.get(i), mPaints.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x, y;
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                mPath.moveTo(x, y);
                mPath.lineTo(x, y);
                break;
            case (MotionEvent.ACTION_MOVE):
                mPath.lineTo(x, y);
                break;
            case (MotionEvent.ACTION_UP):
                mPath.lineTo(x, y);
                addNewLayer();
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    public void apagaTudo() {
        mPaints.clear();
        mPaths.clear();
        invalidate();
    }

    public void apagaUlt() {
        if (mPaints.size() > 0) {
            mPaints.remove(mPaints.size() - 1);
            mPaths.remove(mPaths.size() - 1);
        }
        invalidate();
    }
}
