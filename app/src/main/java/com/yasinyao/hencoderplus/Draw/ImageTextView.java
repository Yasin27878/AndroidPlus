package com.yasinyao.hencoderplus.Draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.yasinyao.hencoderplus.R;

import org.jetbrains.annotations.Nullable;

/**
 * @author Yasin Yao
 * @since 3/3/21
 */
public class ImageTextView extends View {
    public static final int CIRCLE_COLOR = Color.parseColor("#666666");

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint mTextPaint = new TextPaint();
    Bitmap mBitmap;
    float[] curWidth = new float[1];

    public static final String TEXT_STR = "将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看将哈伦裤大家发了快递发空间发了看";

    public ImageTextView(Context context) {
        super(context);
    }


    public ImageTextView(Context context, Nullable attrs) {
        super(context, attrs);
    }

    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mTextPaint.setTextSize(Utils.dp2px(15));
        mBitmap = getAvatar((int) Utils.dp2px(50));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
 /*       StaticLayout staticLayout = new StaticLayout("ImageTextViewImageTextViewImageTextView" +
                "ImageTextViewImageTextViewImageTextViewImageTextViewImageTextViewImageTextViewImage" +
                "TextViewImageTextViewImageTextViewImageTextViewImageTextViewImageTextViewImageText" +
                "ViewImageTextViewImageTextView", mTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
        staticLayout.draw(canvas);*/
        canvas.drawBitmap(mBitmap, getWidth() - Utils.dp2px(50), 100, mPaint);
        int index = mPaint.breakText(TEXT_STR, true, getWidth(), curWidth);
        canvas.drawText(TEXT_STR, 0, index, 0, 50, mPaint);

    }

    private Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.yasin, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.yasin, options);

    }
}
