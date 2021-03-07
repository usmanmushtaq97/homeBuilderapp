
package com.tss.homebuilder.Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tss.homebuilder.Activities.BuiderItemDetails;
import com.tss.homebuilder.Models.BuilderItems;
import com.tss.homebuilder.Models.RatingsModels;
import com.tss.homebuilder.R;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import spencerstudios.com.bungeelib.Bungee;

public class RattingAdapter extends RecyclerView.Adapter<RattingAdapter.ViewHolder > {
    private Context mContext;
    private List<RatingsModels > builderItems;

    public RattingAdapter(Context context, List< RatingsModels > builderItems) {
        this.mContext = context;
        this.builderItems = builderItems;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ratingsitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
   RatingsModels ratingsModels = this.builderItems.get(position);

        ///  holder.mListImage.setBackgroundResource(Integer.valueOf(ratingsModels.getImage()));
        Glide.with(mContext).load(ratingsModels.getImageUrl()).into(holder.mListImage);
        holder.mListTitle.setText(ratingsModels.getTitlePerson());
        holder.ReviewComment.setText(ratingsModels.getReviewComments());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return builderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView mListImage;
        public TextView mListTitle;
        TextView ReviewComment;
        public RatingBar  mListRatingValues;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ReviewComment = itemView.findViewById(R.id.reviewcomments);
            mListImage = itemView.findViewById(R.id.profileimageratings);
            mListTitle = itemView.findViewById(R.id.nameprofiles);
            mListRatingValues = itemView.findViewById(R.id.ratingBar);
        }
    }


}
