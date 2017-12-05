package com.example.student.db2017112101;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by student on 2017/11/21.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<String> data;
    ArrayList<String> pics;
    public boolean chkArray[];
    Context context;
    public MyAdapter(Context context, ArrayList<String> data, ArrayList<String> pics)
    {
        this.context = context;
        this.data = data;
        this.pics = pics;
        chkArray = new boolean[data.size()];
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.myitem, null);
            holder = new ViewHolder();
            holder.tv = (TextView) view.findViewById(R.id.textView);
            holder.chk = (CheckBox) view.findViewById(R.id.checkBox);
            holder.img = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv.setText(data.get(i));
        final int p = i;
        holder.chk.setChecked(chkArray[i]);
        holder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkArray.length - 1 >= p)
                {
                    chkArray[p] = b;
                }
            }
        });
        Picasso.with(context).load(pics.get(i)).into(holder.img);
        Log.d("getView", "position:" + i);
        return view;
    }
    static class ViewHolder
    {
        TextView tv;
        CheckBox chk;
        ImageView img;
    }
}
