package com.tss.homebuilder.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tss.homebuilder.Models.ScreenIntroModel;
import com.tss.homebuilder.R;
import java.util.List;

public  class InfoViewPgAdpater extends PagerAdapter {
    //View view;
    private Context mContext;
    private List< ScreenIntroModel > mscreenlist;


    public InfoViewPgAdpater(Context mContext, List<ScreenIntroModel> mscreenlist) {
        this.mContext = mContext;
        this.mscreenlist = mscreenlist;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // View view= LayoutInflater.from(mContext).inflate(R.layout.layoutscreen,null);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=  inflater.inflate(R.layout.layoutscreen,null);
        ImageView imageslide=view.findViewById(R.id.imageintro);
        TextView title=view.findViewById(R.id.title);
        TextView disc=view.findViewById(R.id.discription);
        ScreenIntroModel introModel=mscreenlist.get(position);
        imageslide.setImageResource(introModel.getScreenimg());
        title.setText(introModel.getTitle());
        disc.setText(introModel.getDescription());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return mscreenlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager) container;
        View view= (View) object;
        viewPager.removeView(view);
    }
}
