package com.ht.androidstudy.meituanxuanting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by niehongtao on 16/6/2.
 */
public class ListViewHeight extends ListView{
    private OnScrollChangedListener onScrollListener;
    private int headerHeight;


    /**
     * 设置滚动接口
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollChangedListener onScrollListener){
        this.onScrollListener = onScrollListener;
    }

    /**
     * 滚动的回调接口
     */
    public interface OnScrollChangedListener {
        /**
         * 回调方法， 返回MyScrollView滑动的Y方向距离
         */
        void onScroll(int scrollY);
    }


    public ListViewHeight(Context context) {
        super(context);
    }

    public ListViewHeight(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScroll(getLvScrollY());
        }
    }

    /**
     * 得到listview滚动的距离,考虑了headview的情况，假设每个item的高度都是固定的
     * @return
     */
    private int getLvScrollY() {
        // 方案1
        View c = this.getChildAt(0);//这里拿到的是可见部分的第一个View
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = this.getFirstVisiblePosition();
        int top = c.getTop();
        final int height = c.getHeight();

        int scrollY;
        if (firstVisiblePosition == 0) {
            //如果当前可见的第一个位是0，表示当前第一位是Header，再此保存Head而的height
            headerHeight = height;

            scrollY = -top;
        } else {
            scrollY = -top + (firstVisiblePosition - 1) * height + headerHeight;
        }

        return scrollY;

        // 方案2
//        View view = this.getChildAt(0);
//        if (view  == null) {
//            return 0;
//        }
//        int firstVisiblePosition = this.getFirstVisiblePosition();
//        int top = view.getTop();
//
//        int headerHeight = 0;
//        if (firstVisiblePosition >= 1) {
//            headerHeight = getHeight();
//        }
//        return -top + firstVisiblePosition * view.getHeight() + headerHeight;
    }
}
