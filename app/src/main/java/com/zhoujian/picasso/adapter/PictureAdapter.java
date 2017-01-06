package com.zhoujian.picasso.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.zhoujian.picasso.R;
import com.zhoujian.picasso.bean.Person;
import com.zhoujian.picasso.transform.RoundedTransformationBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhoujian on 2017/1/6.
 */

public class PictureAdapter extends BaseAdapter
{

    private ArrayList<Person> persons;
    private Context context;
    public PictureAdapter(Context mContext, ArrayList<Person> personList)
    {
        this.context = mContext;
        this.persons = personList;
    }

    @Override
    public int getCount()
    {
        if (persons != null && persons.size() > 0)
        {
            return persons.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView != null) {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        } else {
            view = View.inflate(context, R.layout.list_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        if (persons != null && persons.size() > 0) {


            Transformation transformation = new RoundedTransformationBuilder()
                    .borderColor(Color.TRANSPARENT)
                    .borderWidthDp(0)
                    .cornerRadiusDp(20)
                    .oval(false)
                    .build();

            Picasso.with(context)
                    .load(persons.get(position).getPictureUrl())
                    .transform(transformation)
                    .placeholder(R.mipmap.image_default)//没有加载图片时显示的默认图像
                    .error(R.mipmap.image_default)// 图像加载错误时显示的图像
                    .into(holder.mImg);// 被加载的控件
            holder.mcontent.setText(persons.get(position).getContent());

        }
        return view;
    }

    static class ViewHolder
    {
        @BindView(R.id.img)
        ImageView mImg;
        @BindView(R.id.content)
        TextView mcontent;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
