package com.nitravangla.udgam2k18.guests;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    Fragment f1=new frag1();
    Fragment f2=new frag2();
    Fragment f3=new frag3();

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:return f1;
            case 1:return  f2;
            case 2:return f3;
            default:break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

