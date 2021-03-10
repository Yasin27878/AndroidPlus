package com.yasinyao.hencoderplus.Draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class TestView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path path = new Path();
    private PathMeasure pathMeasure;

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.addRect(getWidth() / 2 - 150, getHeight() / 2 - 300,
                getWidth() / 2 + 150, getHeight() / 2, Path.Direction.CCW);
        path.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CCW);
        pathMeasure = new PathMeasure(path,false);
        // 图形周长
      //  pathMeasure.getLength();
        // 获取某个点的位置
      //  pathMeasure.getPosTan();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      /*  canvas.drawLine(100, 100, 200, 200, paint);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2,
                Utils.dp2px(100),
                paint);*/
       // path.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path, paint);
    }
}
