
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
import com.tss.homebuilder.Models.WorkerItems;
import com.tss.homebuilder.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import spencerstudios.com.bungeelib.Bungee;

public class WorkerAdapter
        extends RecyclerView.Adapter< WorkerAdapter.ViewHolder> {

    private Context mContext;
    private List< WorkerItems > mFoodItems;
    public WorkerAdapter(Context context, List<WorkerItems> workerItems) {
        this.mContext = context;
        this.mFoodItems = workerItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.worker_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkerItems workerItems = mFoodItems.get(position);
        if (position % 2 == 0) {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.secondary_color));

        } else {
            holder.mListBG.setCardBackgroundColor(ContextCompat.getColor(mContext,R.color.primary_color));
        }
      ///  holder.mListImage.setBackgroundResource(Integer.valueOf(workerItems.getImage()));
        Glide.with(mContext).load(workerItems.getwImageUrl()).into(holder.mListImage);
        holder.mListTitle.setText(workerItems.getwName());
        holder.mSubTitle.setText(workerItems.getWtypeofemployee());
        holder.mListRatingValues.setText(String.valueOf(workerItems.getwRatings()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LabourItemDetails.class);
//                intent.putExtra("pid",workerItems.getId());
//                intent.putExtra("name",workerItems.getTitle());
//                intent.putExtra("descriptions",workerItems.getDescriptions());
//                intent.putExtra("price",workerItems.getPrice());
//                intent.putExtra("ratings",workerItems.getRating());
//                intent.putExtra("min",workerItems.getMin());
//                intent.putExtra("image_url",workerItems.getImage());
//                Toast.makeText(mContext, ""+workerItems.getTitle(), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
                Bungee.slideUp(mContext);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFoodItems.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public CardView mListBG;
        public CircleImageView mListImage;
        public TextView mListTitle;
        TextView mSubTitle;
        public TextView mListRatingValues;
        ImageButton mRatingStars;
        ImageButton mWhatsApp;
        ImageButton mMessage;
        ImageButton mVerifiyProfile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mListBG = itemView.findViewById(R.id.wcarid);
            mListImage = itemView.findViewById(R.id.wimageprofile);
            mListTitle = itemView.findViewById(R.id.wtnameid);
            mSubTitle = itemView.findViewById(R.id.w_sub_title_id);
            mRatingStars = itemView.findViewById(R.id.w_rating_pic_id);
            mWhatsApp = itemView.findViewById(R.id.wwhatsappid);
            mMessage = itemView.findViewById(R.id.wmessageid);
            mVerifiyProfile = itemView.findViewById(R.id.wverifiystatus);
            mListRatingValues = itemView.findViewById(R.id.wratingvalue);

        }
    }

}
