package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.ViewAdapter;
import jiyun.com.doctorsixsixsix.util.StatisticsView;
import jiyun.com.doctorsixsixsix.view.activity.InformationActivity;
import jiyun.com.doctorsixsixsix.view.activity.mftw.MianFeiWenActivity;

/**
 * Created by dell on 2017/6/9.
 */

public class TestFragment extends BaseFragment {
    @BindView(R.id.xueyaguanli)
    LinearLayout xueyaguanli;
    @BindView(R.id.shangchuanxueya)
    ImageView shangchuanxueya;
    @BindView(R.id.xueyajilu)
    LinearLayout xueyajilu;
    @BindView(R.id.day)
    RadioButton day;
    @BindView(R.id.week)
    RadioButton week;
    @BindView(R.id.month)
    RadioButton month;
    @BindView(R.id.year)
    RadioButton year;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.fragmentView)
    ViewPager fragment;
    @BindView(R.id.wys)
    RadioButton wys;
    @BindView(R.id.zx)
    RadioButton zx;
    @BindView(R.id.tx)
    RadioButton tx;
    @BindView(R.id.zixun)
    RadioGroup zixun;
    Unbinder unbinder;
    private String[] strOne={"0点","6点","12点","18点","24点"};
    private String[] strTwo={"第一周","第二周","第三周","第四周"};
    private String[] strThree={"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
    private String[] strFour={"2015","2016","2017","2018","2019"};
    private ViewAdapter adapter;
    private List<String[]> mList=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.xueyaguanli;
    }

    @Override
    protected void initView(View view) {
        mList.add(strOne);
        mList.add(strTwo);
        mList.add(strThree);
        mList.add(strFour);
        adapter=new ViewAdapter(mList,getContext());
        adapter.setFloats(new float[]{80f,90f,100f,105f,85f});
        adapter.setA(0);
        fragment.setAdapter(adapter);
        fragment.setCurrentItem(0);
    }

    @Override
    protected void initListener() {
        zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InformationActivity.class);
                startActivity(intent);
            }
        });
        wys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MianFeiWenActivity.class);
                startActivity(intent);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.day:
                        fragment.setCurrentItem(0);
                        break;
                    case R.id.week:
                        fragment.setCurrentItem(1);
                        break;
                    case R.id.month:
                        fragment.setCurrentItem(2);
                        break;
                    case R.id.year:
                        fragment.setCurrentItem(3);
                        break;
                }
            }
        });
        fragment.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        day.setChecked(true);
                        break;
                    case 1:
                        week.setChecked(true);
                        break;
                    case 2:
                        month.setChecked(true);
                        break;
                    case 3:
                        year.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }

}
