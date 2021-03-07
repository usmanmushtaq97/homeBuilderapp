package com.tss.homebuilder.Controller;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tss.homebuilder.Fragments.AllWorkerFragment;
import com.tss.homebuilder.Fragments.AllBuilderFragment;
public class FragmentLWAdapter extends FragmentStateAdapter {
    public FragmentLWAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new AllBuilderFragment();
        }
        return new AllWorkerFragment();
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
