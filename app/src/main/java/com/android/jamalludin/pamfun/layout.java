package com.android.jamalludin.pamfun;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jamal on 04/12/15.
 */
public class layout extends BaseAdapter {
    List<String> data;
    Context context;
    private static LayoutInflater infalater = null;
    layout(FragmentActivity activity){

        infalater = LayoutInflater.from(activity);
    }



    @Override
    public int getCount() {

        return 4;

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class Holder{
        TextView t1,t2;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowV = infalater.inflate(R.layout.list,null);
        return rowV;
    }
}
