package com.ht.androidstudy.dialog;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ht.androidstudy.R;
import java.util.List;

/**
 * Created by niehongtao on 16/6/2.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<DialogFragmentTestDemo> mDemoList;

    public GridViewAdapter(Context context, List<DialogFragmentTestDemo> demoList) {
        mContext = context;
        mDemoList = demoList;
    }


    @Override
    public int getCount() {
        return mDemoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.dialogfragment_item, null);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setText(mDemoList.get(position).getStr());
        return convertView;
    }


    public static class ViewHolder {
        TextView mTextView;
    }
}
