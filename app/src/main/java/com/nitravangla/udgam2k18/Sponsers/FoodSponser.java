package com.nitravangla.udgam2k18.Sponsers;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitravangla.udgam_2k18.R;

import java.util.ArrayList;


public class FoodSponser extends RecyclerView.Adapter<FoodSponser.ViewHolder> {
    private Context mContext;
    private ArrayList<ModelSponser> mlist;

    FoodSponser(Context context, ArrayList<ModelSponser> list) {
        mContext = context;
        mlist = list;
    }


    @Override
    public FoodSponser.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.sponser_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);



        return viewHolder;

    }


    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelSponser modelSponser = mlist.get(position);

        ImageView image = holder.imageView;
        TextView text, subtext;
        FloatingActionButton button;
        text = holder.textView1;
        subtext = holder.textView2;




        image.setImageResource(modelSponser.getImage());

        text.setText(modelSponser.getName());
        subtext.setText(modelSponser.getSubname());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView1, textView2;
        public ViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textViewTitle);
            textView2 = itemView.findViewById(R.id.textViewShortDesc);
        }
    }
}
