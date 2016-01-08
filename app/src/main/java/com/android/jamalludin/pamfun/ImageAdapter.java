package com.android.jamalludin.pamfun;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jamal on 14/12/15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;

    public Integer[] mThumbIds = {
            R.drawable.meme1, R.drawable.meme2,
            R.drawable.meme3, R.drawable.meme4,
            R.drawable.meme5,
    };

    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(80, 80));
        return imageView;
    }
}
