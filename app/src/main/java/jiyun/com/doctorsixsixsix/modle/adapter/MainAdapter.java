package jiyun.com.doctorsixsixsix.modle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseFragment;

/**
 * Created by dell on 2017/6/9.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mList;

    public MainAdapter(FragmentManager fm, List<BaseFragment> mList) {
        super(fm);
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
