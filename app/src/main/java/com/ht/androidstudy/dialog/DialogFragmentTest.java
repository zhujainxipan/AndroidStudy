package com.ht.androidstudy.dialog;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.ht.androidstudy.R;

import java.io.Serializable;
import java.util.List;


/**
 * Created by niehongtao on 16/6/2.
 * dialogfragment测试，要实现把dialogfrgment中的数据传递给activity，就只能用接口回调了
 */
public class DialogFragmentTest extends DialogFragment implements View.OnClickListener {

    private GridView mGridview;
    private ImageView mCloseDialog;
    private List<DialogFragmentTestDemo> demoList;
    public static final String DIALOGFRAGMENTTEST = "dialogfragmenttest";
    private CallBack mCallBack;

    public void setCallBack(CallBack callBack) {
        mCallBack = callBack;
    }

    public interface CallBack {
        void getChoicedTxt(String str);
    }

    /**
     * 这种封装方式非常的好，可以给给外界提供一个数据访问的入口
     *
     * @return
     */
    public static DialogFragmentTest getInstance(List<DialogFragmentTestDemo> demoList) {
        DialogFragmentTest dialogFragmentTest = new DialogFragmentTest();
        Bundle b = new Bundle();
        b.putSerializable("demoList", (Serializable) demoList);
        dialogFragmentTest.setArguments(b);
        return dialogFragmentTest;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        // 设置dialog的layout
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.width = dm.widthPixels;
        layoutParams.height = layoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
        getDialog().getWindow().setAttributes(layoutParams);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setWindowAnimations(R.style.animate_dialog);
        View view = inflater.inflate(R.layout.dialogfragment_test, container);
        mGridview = (GridView) view.findViewById(R.id.gdv_content);
        mCloseDialog = (ImageView) view.findViewById(R.id.cancel_dialog);
        mCloseDialog.setOnClickListener(this);
        handleArgs();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        return view;
    }

    private void handleArgs() {
        Bundle bundle = getArguments();
        demoList = (List<DialogFragmentTestDemo>) bundle.getSerializable("demoList");
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getActivity(), demoList);
        mGridview.setAdapter(gridViewAdapter);

        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), demoList.get(position).getStr(), Toast.LENGTH_LONG).show();
                mCallBack.getChoicedTxt(demoList.get(position).getStr());
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_dialog:
                dismissDialog();
                break;
            default:
        }

    }


    public void dismissDialog() {
        android.app.Fragment prev = getFragmentManager().findFragmentByTag(DIALOGFRAGMENTTEST);
        if (prev != null) {
            DialogFragment df = (DialogFragment) prev;
            df.dismiss();
        }
    }



}
