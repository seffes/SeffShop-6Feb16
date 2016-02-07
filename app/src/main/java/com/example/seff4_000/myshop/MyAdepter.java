package com.example.seff4_000.myshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by seff4_000 on 7/2/2559.
 */
public class MyAdepter extends BaseAdapter {

    //Explicit
    private Context objContext;
    private String[] foodStrings, priceString, sourceStrings;

    public MyAdepter(Context objContext, String[] foodStrings, String[] priceString, String[] sourceStrings) {
        this.objContext = objContext;
        this.foodStrings = foodStrings;
        this.priceString = priceString;
        this.sourceStrings = sourceStrings;
    } //constructure

    @Override
    public int getCount() {
        return foodStrings.length;
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

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.food_listview, viewGroup, false);

        TextView foodTextView = (TextView) objView1.findViewById(R.id.textView3);
        foodTextView.setText(priceString[i]);

        TextView priceTextView = (TextView) objView1.findViewById(R.id.textView4);
        priceTextView.setText(priceString[i]);

        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView);
        Picasso.with(objContext).load(sourceStrings[i]).resize(120,120).into(iconImageView);



        return null;
    }
}  //mainn class
