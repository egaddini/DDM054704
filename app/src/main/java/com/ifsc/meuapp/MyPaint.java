package com.ifsc.meuapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyPaint extends View {

//    List<Paint> mPaints = new ArrayList<>();
//    List<Path> mPaths = new ArrayList<>();
    Paint mPaint;
    Path mPath;

    public MyPaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
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
                mPaint.setColor(Color.RED);
//                mPaints.add(mPaint);
//                mPaths.add(mPath);
                break;
            default:
                break;
        }
        invalidate();
        return true;
    }
}
