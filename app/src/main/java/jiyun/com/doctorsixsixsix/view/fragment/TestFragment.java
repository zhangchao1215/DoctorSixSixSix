package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.Dao.XueYaDao;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.ViewAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.XueYa;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.RecordView;
import jiyun.com.doctorsixsixsix.view.activity.InformationActivity;
import jiyun.com.doctorsixsixsix.view.activity.RecordActivity;
import jiyun.com.doctorsixsixsix.view.activity.mftw.MianFeiWenActivity;
import jiyun.com.doctorsixsixsix.view.activity.tixing.RemindActivity;

import static android.R.attr.id;
import static android.R.attr.type;

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
    private float[] float1=new float[5];
    private float[] float2=new float[5];
    private String id;

    @Override
    protected int getLayoutId() {
        return R.layout.xueyaguanli;
    }

    @Override
    protected void initView(View view) {
        id=AppUtils.get().getString("id","");
        mList.add(strOne);
        mList.add(strTwo);
        mList.add(strThree);
        mList.add(strFour);
        get();
        adapter=new ViewAdapter(mList,getContext());
        adapter.setA(0);
        adapter.setFloats(float1);
        adapter.setFloats1(float2);
        fragment.setAdapter(adapter);
        fragment.setCurrentItem(0);
    }

    @Override
    protected void initListener() {
        final boolean login= AppUtils.get().getBoolean("login",false);
        shangchuanxueya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login) {
                    Intent intent = new Intent(getActivity(), RecordActivity.class);
                    startActivity(intent);
                }else{
                    AppUtils.toast("请先登录再上传");
                }
            }
        });
        zx.setOnClickListener(new View.OnClickListener() {
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
        tx.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RemindActivity.class);
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

    private void get(){
        List<XueYa> list = App.getDaoInstant().getXueYaDao().queryBuilder().list();
        int a=0;
        for(XueYa x:list){
            long datatime = x.getDatatime();
            long l=System.currentTimeMillis();
            String s1 = AppUtils.longToString(l, "yyyy-MM-dd");
            String s = AppUtils.longToString(datatime * 1000, "yyyy-MM-dd");
            if(s1.equals(s)){
                String hh1 = AppUtils.longToString(datatime * 1000, "HH");
                int i = Integer.parseInt(hh1);
                if(i<=6){
                    float1[0]= (float) x.getHigh();
                    float2[0]= (float) x.getLow();
                }else if(i>6&&i<12){
                    float1[1]= (float) x.getHigh();
                    float2[1]= (float) x.getLow();
                }else if(i>12&&i<18){
                    float1[2]= (float) x.getHigh();
                    float2[2]= (float) x.getLow();
                }else if(i>18&&i<24){
                    float1[3]= (float) x.getHigh();
                    float2[3]= (float) x.getLow();
                }else if(i==24){
                    float1[4]= (float) x.getHigh();
                    float2[4]= (float) x.getLow();
                }
                }
        }
    }
}
