package jiyun.com.doctorsixsixsix.modle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;
    private List<String> strList;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> mList, List<String> strList) {
        super(fm);
        this.mList = mList;
        this.strList = strList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strList.get(position);
    }
}
