package com.greenbotsite.uiGimmicks;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by gaurav on 30/1/17.
 */

public class LabelCustomView extends View {

    private Paint backgroundPaint;
    private TextPaint textPaint;

    public LabelCustomView(Context context) {
        super(context);
        init();
    }

    public LabelCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        backgroundPaint = new Paint();
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

        backgroundPaint.setColor(Color.parseColor("#234567"));

        textPaint.setColor(Color.parseColor("#ffffff"));
        textPaint.setTextSize(32f * getResources().getDisplayMetrics().scaledDensity);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        float centreX = Math.round(canvasWidth * 0.5f);
        float centreY = Math.round(canvasHeight * 0.5f);

        float radius = (canvasWidth < canvasHeight ? canvasWidth : canvasHeight) * 0.5f;

        float textOffsetX = textPaint.measureText("hello world") * 0.5f;
        float textOffsetY = textPaint.getFontMetrics().ascent * -0.4f;

        canvas.drawCircle(centreX, centreY, radius, backgroundPaint);
        // Draw # of seconds.
        canvas.drawText("hello world", centreX - textOffsetX, centreY + textOffsetY, textPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.v("Chart onMeasure w", MeasureSpec.toString(widthMeasureSpec));
        Log.v("Chart onMeasure h", MeasureSpec.toString(heightMeasureSpec));

        Paint.FontMetrics numberFontMetrics = textPaint.getFontMetrics();
        int maxTextWidth = (int) Math.ceil(textPaint.measureText(String.valueOf("hello world"))) + getPaddingLeft() + getPaddingRight();
        int maxTextHeight = (int) Math.ceil(-numberFontMetrics.top + numberFontMetrics.bottom);

        int contentSize = Math.max(maxTextWidth, maxTextHeight);

        setMeasuredDimension(resolveSize(contentSize, widthMeasureSpec), resolveSize(contentSize, heightMeasureSpec));
    }
}
