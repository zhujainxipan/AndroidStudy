package com.ht.androidstudy.animation;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.ht.androidstudy.R;

/**
 * Created by niehongtao on 16/6/8.
 * zaker自定义效果页面
 */
public class PullDoorView extends RelativeLayout {

    private Scroller mScroller;
    private int mScreenWidth = 0;
    private int mScreenHeigh = 0;
    private float mLastDownY;

    public PullDoorView(Context context) {
        super(context);
        init(context);
    }

    public PullDoorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        // 这个Interpolator你可以设置别的 我这里选择的是有弹跳效果的Interpolator
        Interpolator polator = new BounceInterpolator();
        mScroller = new Scroller(context, polator);
        // 获取屏幕分辨率
        WindowManager wm = (WindowManager) (context.getSystemService(Context.WINDOW_SERVICE));
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenHeigh = dm.heightPixels;
        mScreenWidth = dm.widthPixels;
        // 这里你一定要设置成透明背景,不然会影响你看到底层布局
        this.setBackgroundColor(Color.argb(0, 0, 0, 0));
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);// 填充整个屏幕
        imageView.setImageResource(R.mipmap.test1); // 默认背景
        addView(imageView);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastDownY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float currY = event.getY();
                float delY = currY - mLastDownY;
                Log.d("delY", delY + "");
                // 说明向上滑动了,让自己的内容也向上滑动
                if (delY < 0) {
                    scrollTo(0, (int) -delY);
                }
                break;
            case MotionEvent.ACTION_UP:
                // 当手离开屏幕时
                float currY1 = event.getY();
                float offsetY = currY1 - mLastDownY;
                // 说明是上滑
                if (offsetY < 0) {
                    if (Math.abs(offsetY) > mScreenHeigh / 2) {
                        //todo 这几个位置感觉理解起来有点问题
                        // 向上滑动超过半个屏幕高的时候，开启向上消失动画
                        startBounceAnim(this.getScrollY(), mScreenHeigh, 450);
                    } else {
                        // 向上滑动未超过半个屏幕高的时候，开启向下弹动动画
                        startBounceAnim(this.getScrollY(), -this.getScrollY(), 1000);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }


    // 推动门的动画
    //todo ????
    public void startBounceAnim(int startY, int dy, int duration) {
        mScroller.startScroll(0, startY, 0, dy, duration);
        invalidate();
    }


    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            // 不要忘记更新界面
            postInvalidate();
        } else {

        }
    }
}
