package com.ht.androidstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by niehongtao on 16/5/31.
 * android群英传chapter3
 */
public class BgTextView extends TextView {

    private Paint mPaint1;
    private Paint mPaint2;

    public BgTextView(Context context) {
        super(context);
        init();
    }


    public BgTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);

        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制外层矩形
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint1);
        // 绘制内层矩形
        canvas.drawRect(10, 10, getWidth() - 10, getHeight() - 10, mPaint2);
        canvas.save();
        // 事实证明这样是有问题的
//        canvas.translate(10, 0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
