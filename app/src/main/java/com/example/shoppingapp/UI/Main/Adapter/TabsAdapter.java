package com.example.shoppingapp.UI.Main.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.shoppingapp.UI.Main.CategoryFragment;
import com.example.shoppingapp.UI.Main.HomeFragment;
import com.example.shoppingapp.UI.Main.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsAdapter extends FragmentStatePagerAdapter {


    List<Fragment> fragmentList;
    public TabsAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fragmentList= new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new ProfileFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

