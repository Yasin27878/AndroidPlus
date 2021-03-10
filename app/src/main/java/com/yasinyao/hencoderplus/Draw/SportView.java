package com.yasinyao.hencoderplus.Draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Yasin Yao
 * @since 3/3/21
 */
public class SportView extends View {
    public static final int CIRCLE_COLOR = Color.parseColor("#666666");
    public static final int CIRCLE_BROAD_WIDTH = Utils.dp2px(10);
    public static final int CIRCLE_RADIUS = Utils.dp2px(50);
    public static final int HIGHLIGHT_COLOR = Color.parseColor("#562b12");

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect = new Rect();
    Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();

    public SportView(Context context) {
        super(context);
    }


    public SportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SportView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(Utils.dp2px(20));
        // mPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"a.tff"));
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.getFontMetrics(mFontMetrics);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆环
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(CIRCLE_COLOR);
        mPaint.setStrokeWidth(CIRCLE_BROAD_WIDTH);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, CIRCLE_RADIUS, mPaint);

        // 绘制进度条
        mPaint.setColor(HIGHLIGHT_COLOR);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(getWidth() / 2 - CIRCLE_RADIUS, getHeight() / 2 - CIRCLE_RADIUS,
                getWidth() / 2 + CIRCLE_RADIUS, getHeight() / 2 + CIRCLE_RADIUS,
                -90, 225, false, mPaint);
        // 绘制文字(局中，随文字居中)
/*        mPaint.setStyle(Paint.Style.FILL);
        mPaint.getTextBounds("abab", 0, "abab".length(), rect);
        int offset = (rect.top + rect.bottom) / 2;
        canvas.drawText("Yasin", getWidth() / 2, getHeight() / 2 - offset, mPaint);*/
        // 绘制文字2(局中，一直不变)
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setStyle(Paint.Style.FILL);
        float offset = (mFontMetrics.top + mFontMetrics.bottom) / 2;
        canvas.drawText("Yasin", getWidth() / 2, getHeight() / 2 - offset, mPaint);

        // 绘制文字3 左对齐
        mPaint.setTextSize(Utils.dp2px(50));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.getTextBounds("abab", 0, "abab".length(), rect);

        canvas.drawText("abab", -rect.left, 200, mPaint);

        // 绘制文字4 左对齐
        mPaint.setTextSize(Utils.dp2px(10));
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("abab", 0, 200+mPaint.getFontSpacing(), mPaint);
    }
}
