package com.example.administrator.urltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yh on 2017-05-16.
 */

public class CustomAdapter  extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<listItem> infoList;
    private ViewHolder viewHolder;

    public CustomAdapter(Context c , ArrayList<listItem> array){
        inflater = LayoutInflater.from(c);
        infoList = array;
    }

    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        View v = convertview;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.listitem, null);
            viewHolder.name = (TextView)v.findViewById(R.id.item_text1);
            viewHolder.contact = (TextView)v.findViewById(R.id.item_text2);
            viewHolder.email = (TextView)v.findViewById(R.id.item_text3);


        }

        viewHolder.name.setText(infoList.get(position).getTitle());
        viewHolder.contact.setText(infoList.get(position).getUrl());
        viewHolder.email.setText(infoList.get(position).getDate());

        return v;
    }

    public void setArrayList(ArrayList<listItem> arrays){
        this.infoList = arrays;
    }

    public ArrayList<listItem> getArrayList(){
        return infoList;
    }


    /*
     * ViewHolder
     */
    class ViewHolder{
        TextView name;
        TextView contact;
        TextView email;
    }

}
