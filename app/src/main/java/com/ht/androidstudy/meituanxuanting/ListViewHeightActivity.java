package com.ht.androidstudy.meituanxuanting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import com.ht.androidstudy.R;
import java.util.ArrayList;

public class ListViewHeightActivity extends Activity implements ListViewHeight.OnScrollChangedListener {
    private ListViewHeight mListViewHeight;
    private EditText mEditText;
    private EditText mFakeEt;
    private ImageView mIv;
    private int searchLayoutTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_height);
        mListViewHeight = (ListViewHeight) findViewById(R.id.lv_height);
        mEditText = (EditText) findViewById(R.id.search_edit_fake);

        View headView = getLayoutInflater().inflate(R.layout.listview_head, null);
        mFakeEt = (EditText) headView.findViewById(R.id.search_edit_fake);
        mIv = (ImageView) headView.findViewById(R.id.iv);
        mListViewHeight.addHeaderView(headView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                getData());
        mListViewHeight.setAdapter(adapter);

        mListViewHeight.setOnScrollListener(this);
    }


    private ArrayList<String> getData() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 99; i++) {
            list.add(i + "第几个第几个");
        }
        return list;
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            searchLayoutTop = mFakeEt.getTop();//获取searchLayout的顶部位置
        }
    }


    @Override
    public void onScroll(int scrollY) {
        if (scrollY >= searchLayoutTop) {
            mEditText.setVisibility(View.VISIBLE);
            mFakeEt.setVisibility(View.INVISIBLE);
        } else {
            mEditText.setVisibility(View.INVISIBLE);
            mFakeEt.setVisibility(View.VISIBLE);
        }
    }
}
