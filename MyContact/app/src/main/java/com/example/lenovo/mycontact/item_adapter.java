package com.example.lenovo.mycontact;

/**
 * Created by lenovo on 2018/3/31.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class item_adapter extends BaseAdapter {
    private List<contact_item> mDatas;
    private int mItemLayoutId;
    private Context context;

    public item_adapter(Context mContext, List<contact_item> mDatas, int mItemLayoutId) {
        this.mDatas = mDatas;
        this.mItemLayoutId = mItemLayoutId;
        this.context = mContext;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(mItemLayoutId, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
            viewHolder.txtName.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/PAPYRUS.TTF"));
            TextPaint paint = viewHolder.txtName.getPaint();
            paint.setFakeBoldText(true);
            viewHolder.head = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(mDatas.get(position).getName());
        viewHolder.head.setImageResource(mDatas.get(position).getHead());
        return convertView;
    }

    public class ViewHolder {
        TextView txtName;
        ImageView head;
    }


}
