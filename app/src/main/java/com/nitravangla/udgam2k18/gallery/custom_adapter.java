package com.nitravangla.udgam2k18.gallery;

/**
 * Created by root on 27/3/18.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nitravangla.udgam_2k18.R;

/**
 * Created by root on 22/3/18.
 */

public class custom_adapter extends PagerAdapter {
    private int[] imgs = {R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i7,R.drawable.i8};
    private LayoutInflater inflater;
    private Context ctx;

    public custom_adapter(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slide,container,false);
        ImageView img = (ImageView)v.findViewById(R.id.imageView);
        TextView tv = (TextView)v.findViewById(R.id.textView);
        img.setImageResource(imgs[position]);
        tv.setText("Image :"+position);
        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }
}