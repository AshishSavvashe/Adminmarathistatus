package com.example.admin.adminmarathistatus.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.adminmarathistatus.Model.Categories;
import com.example.admin.adminmarathistatus.R;

import java.util.ArrayList;

/**
 * Created by Admin on 06-11-2017.
 */

public class CustomCategorySpinnerAdapter extends BaseAdapter {

    ArrayList<Categories> data = new ArrayList<Categories>();
    LayoutInflater inflater;
    Context context;

    public CustomCategorySpinnerAdapter(Context context, ArrayList<Categories> myList) {
        this.data = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return data==null?0:data.size();
    }

    @Override
    public Categories getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.catgory_spinner_row, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        Categories data = getItem(position);
        mViewHolder.tvCatname.setText(data.getTitle());
        return convertView;
    }

    private class MyViewHolder {
        TextView tvCatname;

        public MyViewHolder(View item) {
            tvCatname = (TextView)item.findViewById(R.id.tvCatname);
        }
    }
}