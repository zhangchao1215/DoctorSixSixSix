package jiyun.com.doctorsixsixsix.view.activity.mftw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 17:12
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class WenTiActivity extends BaseActivity {


    @BindView(R.id.account_back)
    ImageView accountBack;
    @BindView(R.id.account_Title)
    TextView accountTitle;
    @BindView(R.id.tiwenyisheng)
    RelativeLayout tiwenyisheng;
    @BindView(R.id.jieshao)
    TextView jieshao;
    @BindView(R.id.miaoshu)
    EditText miaoshu;
    @BindView(R.id.tjgys)
    Button tjgys;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mfwys_tw;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.miaoshu, R.id.tjgys})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.miaoshu:
                break;
            case R.id.tjgys:
                break;
        }
    }
}
