package com.kryptoblocks.homerewardx;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<String> mDataList;
    private Context mContext;

    Bitmap bitmap;


    public RecyclerViewAdapter(Context context, ArrayList<String> dataList) {
        super();
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.card, parent, false);
        //v.setMinimumHeight(500);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        final String data = mDataList.get(position);
        holder.text.setText(data);
        holder.image.setImageResource(R.drawable.flight);
        holder.image.buildDrawingCache();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(mContext, data + " clicked", Toast.LENGTH_SHORT).show();

                Intent i=new Intent(mContext,Product_details.class);
                i.putExtra("image", bitmap);
                mContext.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        Button cartAddBtn;
        ImageView image;
        CardView cardView;
        RecyclerView recyclerView;

        public ViewHolder(View v) {
            super(v);
            cartAddBtn=(Button)v.findViewById(R.id.cart_add_button);
            image=(ImageView)v.findViewById(R.id.cardArticleImage);
            text = (TextView) v.findViewById(R.id.cardArticleTitle);
            cardView = (CardView) v.findViewById(R.id.cardView);
            recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);


        }
    }

}