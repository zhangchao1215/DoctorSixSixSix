package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.util.StatisticsView;
import jiyun.com.doctorsixsixsix.view.activity.InformationActivity;

/**
 * Created by dell on 2017/6/9.
 */

public class TestFragment extends BaseFragment {
    @BindView(R.id.xueyaguanli)
    LinearLayout xueyaguanli;
    @BindView(R.id.img)
    ImageView img;
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
    @BindView(R.id.fragment)
    StatisticsView fragment;
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

    @Override
    protected int getLayoutId() {
        return R.layout.xueyaguanli;
    }

    @Override
    protected void initView(View view) {
        fragment.setBottomStr(strOne);
    }

    @Override
    protected void initListener() {
        wys.setChecked(false);
        zx.setChecked(false);
        tx.setChecked(false);
        zixun.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.wys:
                        break;
                    case R.id.zx:
                        Intent intent=new Intent(getActivity(), InformationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.tx:
                        break;
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.day:
                        fragment.setBottomStr(strOne);
                        break;
                    case R.id.week:
                        fragment.setBottomStr(strTwo);
                        break;
                    case R.id.month:
                        fragment.setBottomStr(strThree);
                        break;
                    case R.id.year:
                        fragment.setBottomStr(strFour);
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

}
