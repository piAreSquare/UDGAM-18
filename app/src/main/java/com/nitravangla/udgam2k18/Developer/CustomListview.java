package com.nitravangla.udgam2k18.Developer;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitravangla.udgam_2k18.R;

public class CustomListview extends ArrayAdapter {


    private String[] fruit;
    private String[] desc;
    private Integer[] imgid;
    private Activity context;

    public CustomListview(Activity context,String[] fruit,String[] desc,Integer[] imgid) {
        super(context, R.layout.single_row_layout2, fruit);

        this.context = context;
        this.fruit = fruit;
        this.desc = desc;
        this.imgid = imgid;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View r=convertView;
        com.nitravangla.udgam_2k18.Developer.CustomListview.viewHolder viewholder=null;
        if(r==null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.single_row_layout, null, true);


            viewholder=new com.nitravangla.udgam_2k18.Developer.CustomListview.viewHolder(r);
            r.setTag(viewholder);
        }
        else {
            viewholder = (com.nitravangla.udgam_2k18.Developer.CustomListview.viewHolder) r.getTag();
        }

        viewholder.iv.setImageResource(imgid[position]);
        viewholder.tv1.setText(fruit[position]);
        viewholder.tv2.setText(desc[position]);

        return r;

    }

    class viewHolder{
        TextView tv1;
        TextView tv2;
        ImageView iv;

        viewHolder(View v){
            tv1=v.findViewById(R.id.nameTxt);
            tv2=v.findViewById(R.id.posTxt);
            iv=v.findViewById(R.id.imageView);
        }
    }

}



