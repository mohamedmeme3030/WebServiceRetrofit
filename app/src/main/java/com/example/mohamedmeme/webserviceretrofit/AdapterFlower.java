package com.example.mohamedmeme.webserviceretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterFlower extends RecyclerView.Adapter<AdapterFlower.ViewHolder> {

    private Context context;
    private ArrayList<Flower> flowers;

    public AdapterFlower(Context context, ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Flower flower = flowers.get(i);
        viewHolder.tvFlower.setText(flower.getName());
        Glide.with(context)
                .load("http://services.hanselandpetal.com/photos/"+flower.getPhoto())
                .into(viewHolder.ivFlower);





    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFlower;
        ImageView ivFlower;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFlower = itemView.findViewById(R.id.tv_flower);
            ivFlower = itemView.findViewById(R.id.iv_flower);

        }
    }
}
