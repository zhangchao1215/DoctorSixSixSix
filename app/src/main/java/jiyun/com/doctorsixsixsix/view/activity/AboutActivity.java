package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
 * 类描述: 暂时没什么用的一个类，用的账户的布局
 * 创建人: 马杰
 * 创建时间: 2017/6/10 14:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.account_back)
    ImageView accountBack;
    @BindView(R.id.account_title)
    RelativeLayout accountTitle;
    @BindView(R.id.account_phone)
    TextView accountPhone;
    @BindView(R.id.account_pwd)
    TextView accountPwd;
    @BindView(R.id.account_backlogin)
    Button accountBacklogin;
    @BindView(R.id.account_Title)
    TextView accountTitleo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    protected void initView() {
        accountTitleo.setText("关于血压卫士");
        accountPhone.setText("去评分");
        accountPwd.setText("意见反馈");
        accountBacklogin.setVisibility(View.GONE);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.account_back, R.id.account_title, R.id.account_phone, R.id.account_pwd, R.id.account_backlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account_back:
                onBackPressed();
                break;
            case R.id.account_title:
                break;
            case R.id.account_phone:
                break;
            case R.id.account_pwd:
                Intent intent=new Intent(AboutActivity.this,FeedBackActivity.class);
                startActivity(intent);
                break;
            case R.id.account_backlogin:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
