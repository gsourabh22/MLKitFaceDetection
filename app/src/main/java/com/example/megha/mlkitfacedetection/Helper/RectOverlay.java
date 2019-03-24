package com.example.megha.mlkitfacedetection.Helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RectOverlay extends GraphicOverlay.Graphic{

    private int RECT_COLOR=Color.RED;
    private float STROKE_WIDTH=2.0f;
    private Paint rectPaint;

    private GraphicOverlay graphicOverlay;
    private Rect rect;
    Float smileProb;
    public RectOverlay(GraphicOverlay graphicOverlay, Rect rect,Float smileProb) {
        super(graphicOverlay);
        rectPaint=new Paint();
        rectPaint.setColor(RECT_COLOR);
        rectPaint.setStrokeWidth(STROKE_WIDTH);
        rectPaint.setStyle(Paint.Style.STROKE);
        this.smileProb=smileProb;
        this.graphicOverlay=graphicOverlay;
        this.rect=rect;
        postInvalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF=new RectF(rect);
        rectF.left=translateX(rectF.left);
        rectF.right=translateX(rectF.right);
        rectF.top=translateY(rectF.top);
        rectF.bottom=translateY(rectF.bottom);

        canvas.drawRect(rectF,rectPaint);
        rectPaint.setTextSize(20f);
        canvas.drawText(String.format("Smiling Probability is : %f",smileProb),rectF.left,rectF.bottom+14,rectPaint);


    }
}
