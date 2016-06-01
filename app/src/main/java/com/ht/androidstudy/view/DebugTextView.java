package com.ht.androidstudy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by niehongtao on 16/5/31.
 */
public class DebugTextView extends TextView {

    public DebugTextView(Context context) {
        super(context);
    }

    public DebugTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("dd", "");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
