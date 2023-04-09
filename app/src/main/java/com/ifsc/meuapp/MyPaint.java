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

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaints.add(mPaint);
        mPaths.add(mPath);

    }

    public void addNewLayer() {
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaints.add(mPaint);
        mPaths.add(mPath);
        invalidate();
    }

    public void setCurrentLayerColor(int color) {
        mPaints.get(mPaints.size() - 1).setColor(color);
    }

    public void setCurrentLayerWidth(int width) {
        mPaints.get(mPaints.size() - 1).setStrokeWidth(width);
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
}
