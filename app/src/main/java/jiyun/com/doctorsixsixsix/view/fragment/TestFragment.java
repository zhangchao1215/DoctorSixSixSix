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
    FrameLayout fragment;
    @BindView(R.id.wys)
    RadioButton wys;
    @BindView(R.id.zx)
    RadioButton zx;
    @BindView(R.id.tx)
    RadioButton tx;
    @BindView(R.id.zixun)
    RadioGroup zixun;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.xueyaguanli;
    }

    @Override
    protected void initView(View view) {

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
    }

    @Override
    protected void initData() {

    }

}
