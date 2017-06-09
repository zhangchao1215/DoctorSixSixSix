package jiyun.com.doctorsixsixsix.view;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * Created by dell on 2017/6/9.
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager= (ViewPager) findViewById(R.id.Main_ViewPager);
        mTabLayout= (TabLayout) findViewById(R.id.Main_Tab);

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
