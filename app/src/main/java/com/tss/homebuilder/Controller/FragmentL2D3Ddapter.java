package com.tss.homebuilder.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tss.homebuilder.Fragments.AllBuilderFragment;
import com.tss.homebuilder.Fragments.AllWorkerFragment;
import com.tss.homebuilder.Fragments.Fragment2D;
import com.tss.homebuilder.Fragments.Fragment3D;

public class FragmentL2D3Ddapter extends FragmentStateAdapter {
    public FragmentL2D3Ddapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new Fragment2D();
        }
        return new Fragment3D();
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
