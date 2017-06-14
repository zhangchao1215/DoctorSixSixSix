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
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述: 账号的更改
 * 创建人: 马杰
 * 创建时间: 2017/6/13 17:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PhoneActivity extends BaseActivity {
    @BindView(R.id.phone_back)
    ImageView phoneBack;
    @BindView(R.id.phone_Title)
    TextView phonetitle;
    @BindView(R.id.phone_title)
    RelativeLayout phoneTitle;
    @BindView(R.id.phone_Phone)
    TextView phonePhone;
    @BindView(R.id.phone_text)
    TextView phoneText;
    @BindView(R.id.phone_genghuan)
    Button phoneGenghuan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_phone;
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        String phone = intent.getStringExtra("phone");
        phonePhone.setText(phone);
    }

    @Override
    protected void initListener() {
        phoneBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        phoneGenghuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PhoneActivity.this,VerificationActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {

    }

}
