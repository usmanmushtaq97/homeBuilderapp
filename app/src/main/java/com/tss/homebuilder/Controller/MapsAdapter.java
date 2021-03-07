
package com.tss.homebuilder.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tss.homebuilder.Activities.LabourItemDetails;
import com.tss.homebuilder.Activities.MapsDetails;
import com.tss.homebuilder.Models.MapsModels;
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import spencerstudios.com.bungeelib.Bungee;

public class MapsAdapter
        extends RecyclerView.Adapter< MapsAdapter.ViewHolder > {

    private Context mContext;
    private List< MapsModels > mFoodItems;

    public MapsAdapter(Context context, List< MapsModels > workerItems) {
        this.mContext = context;
        this.mFoodItems = workerItems;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mapitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MapsModels workerItems = mFoodItems.get(position);
        if (position % 2 == 0) {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.secondary_color));

        } else {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.primary_color));
        }
        ///  holder.mListImage.setBackgroundResource(Integer.valueOf(workerItems.getImage()));
        ///Glide.with(mContext).load(workerItems.getwImageUrl()).into(holder.mListImage);
        holder.mListTitle.setText(workerItems.getMtitle());
//        holder.mSubTitle.setText(workerItems.getWtypeofemployee());
//        holder.mListRatingValues.setText(String.valueOf(workerItems.getwRatings()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MapsDetails.class);
                mContext.startActivity(intent);
                Bungee.slideUp(mContext);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFoodItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView mListBG;
        public ImageView mListImage;
        public TextView mListTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mListBG = itemView.findViewById(R.id.card_background);
            mListImage = itemView.findViewById(R.id.imageView_mapid);
            mListTitle = itemView.findViewById(R.id.title_maps);
            // mDescription = itemView.findViewById(R.id.w_sub_title_id);

        }
    }

}
