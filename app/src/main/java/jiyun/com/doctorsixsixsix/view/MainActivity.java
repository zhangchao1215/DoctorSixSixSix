package jiyun.com.doctorsixsixsix.view;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.MainAdapter;
import jiyun.com.doctorsixsixsix.view.fragment.PersonlFragment;
import jiyun.com.doctorsixsixsix.view.fragment.TestFragment;

/**
 * Created by dell on 2017/6/9.
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<BaseFragment> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager= (ViewPager) findViewById(R.id.Main_ViewPager);
        mTabLayout= (TabLayout) findViewById(R.id.Main_Tab);
        mList.add(new TestFragment());
        mList.add(new TestFragment());
        mList.add(new PersonlFragment());
        MainAdapter adapter=new MainAdapter(getSupportFragmentManager(),mList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setCustomView(getText("医生在线",R.mipmap.doctor_head_normal));
        mTabLayout.getTabAt(1).setCustomView(getText("血压管理",R.mipmap.blood_manger_normal));
        mTabLayout.getTabAt(2).setCustomView(getText("个人中心",R.mipmap.persional_normal));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    private TextView getText(String str,int drawableID){
        TextView textView= (TextView) LayoutInflater.from(this).inflate(R.layout.text_item,null).findViewById(R.id.Main_Text);
        Drawable drawable=getResources().getDrawable(drawableID);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setText(str);
        return textView;
    }
}
