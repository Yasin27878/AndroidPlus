package com.yasinyao.hencoderplus.Draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PieChart extends View {
    public static final int RADIUS = (int) Utils.dp2px(150);
    public static final int TRANSLATE = (int) Utils.dp2px(20);

    private int[] angles = {60, 100, 120, 80};
    private int[] colors = {Color.parseColor("#DC143C"),
            Color.parseColor("#87CEFA"),
            Color.parseColor("#3CB371"),
            Color.parseColor("#FF8C00")};
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF rectF = new RectF();

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF.set(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS,
                getWidth() / 2 + RADIUS, getHeight() / 2 + RADIUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int curAngle = 0;
        for (int i = 0; i < angles.length; i++) {
            canvas.save();
            paint.setColor(colors[i]);
            if (i == 0) {
                canvas.translate((float) Math.cos(Math.toRadians(curAngle + angles[i] / 2)) * TRANSLATE,
                        (float) Math.sin(Math.toRadians(curAngle + angles[i] / 2)) * TRANSLATE);
            }
            canvas.drawArc(rectF, curAngle, angles[i], true, paint);
            canvas.restore();
            curAngle += angles[i];
        }


    }
}
