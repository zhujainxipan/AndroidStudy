package com.ht.androidstudy.meituanxuanting;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ht.androidstudy.R;

public class ScrollHeightViewActivity extends Activity implements ScrollHeightView.OnScrollListener{
    private EditText search_edit;
    private ScrollHeightView myScrollView;
    private int searchLayoutTop;
    RelativeLayout rlayout;
    private EditText mEditTextFake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_height_view);
        //初始化控件
        init();
    }

    private void init() {
        search_edit = (EditText)findViewById(R.id.search_edit);
        myScrollView = (ScrollHeightView)findViewById(R.id.myScrollView);
        rlayout = (RelativeLayout)findViewById(R.id.rlayout);
        mEditTextFake = (EditText) findViewById(R.id.search_edit_fake);
        myScrollView.setOnScrollListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            searchLayoutTop = rlayout.getBottom();//获取searchLayout的顶部位置
        }
    }

    //监听滚动Y值变化，通过控制是否可见来实现悬停效果
    @Override
    public void onScroll(int scrollY) {
        if(scrollY >= searchLayoutTop){
            search_edit.setVisibility(View.INVISIBLE);
            mEditTextFake.setVisibility(View.VISIBLE);
        }else{
            search_edit.setVisibility(View.VISIBLE);
            mEditTextFake.setVisibility(View.INVISIBLE);
        }
    }
}
