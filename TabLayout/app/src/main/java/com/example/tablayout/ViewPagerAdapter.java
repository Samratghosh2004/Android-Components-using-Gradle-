package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position ==0) {
            return new ChatFragment();
        } else  { //position == 1
            return new FeedFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;// total number of tabs
    }


    @Override
    public CharSequence getPageTitle(int position) {
         if(position ==0) {
            return "Chat";
        } else  { //position == 1
            return "Feed";
        }
    }
}
