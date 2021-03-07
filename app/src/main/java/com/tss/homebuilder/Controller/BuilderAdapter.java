
package com.tss.homebuilder.Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tss.homebuilder.Activities.BuiderItemDetails;
import com.tss.homebuilder.Models.BuilderItems;
import com.tss.homebuilder.R;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import spencerstudios.com.bungeelib.Bungee;

public class BuilderAdapter extends RecyclerView.Adapter< BuilderAdapter.ViewHolder > {

    private Context mContext;
    private List< BuilderItems > builderItems;

    public BuilderAdapter(Context context, List< BuilderItems > builderItems) {
        this.mContext = context;
        this.builderItems = builderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.builder_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BuilderItems builderItems = this.builderItems.get(position);
        if (position % 2 == 0) {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.primary_color));
        } else {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.secondary_color));
        }
        ///  holder.mListImage.setBackgroundResource(Integer.valueOf(builderItems.getImage()));
        Glide.with(mContext).load(builderItems.getbImageUrl()).into(holder.mListImage);
        holder.mListTitle.setText(builderItems.getBname());
        holder.mListRatingValues.setText(String.valueOf(builderItems.getBrating()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BuiderItemDetails.class);
//                intent.putExtra("pid", builderItems.getId());
//                intent.putExtra("name", builderItems.getTitle());
//                intent.putExtra("descriptions", builderItems.getDescriptions());
//                intent.putExtra("price", builderItems.getPrice());
//                intent.putExtra("ratings", builderItems.getRating());
//                intent.putExtra("min", builderItems.getMin());
//                intent.putExtra("image_url", builderItems.getImage());
//                Toast.makeText(mContext, "" + builderItems.getTitle(), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
                Bungee.slideUp(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return builderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView mListBG;
        public CircleImageView mListImage;
        public TextView mListTitle;
        public TextView mListRatingValues;
        ImageButton mRatingStars;
        ImageButton mWhatsApp;
        ImageButton mMessage;
        ImageButton mVerifiyProfile;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mListBG = itemView.findViewById(R.id.btcardid);
            mListImage = itemView.findViewById(R.id.bimageid);
            mListTitle = itemView.findViewById(R.id.btitleid);
            mRatingStars = itemView.findViewById(R.id.bratingid);
            mWhatsApp = itemView.findViewById(R.id.bwhatsapp);
            mMessage = itemView.findViewById(R.id.bmessageid);
            mVerifiyProfile = itemView.findViewById(R.id.verifyimagebtn);
            mListRatingValues = itemView.findViewById(R.id.bratingvalue);

        }
    }


}
