package jiyun.com.doctorsixsixsix.view.activity;

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
import jiyun.com.doctorsixsixsix.util.AppUtils;

/**
 * 项目名称: 血压卫士
 * 类描述: 验证手机验证码
 * 创建人: 马杰
 * 创建时间: 2017/6/14 7:59
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class VerificationActivity extends BaseActivity {

    @BindView(R.id.Verification_back)
    ImageView VerificationBack;
    @BindView(R.id.Verification_Title)
    TextView Verificationtitle;
    @BindView(R.id.Verification_title)
    RelativeLayout VerificationTitle;
    @BindView(R.id.Verification_order)
    TextView VerificationOrder;
    @BindView(R.id.Verification_Edit)
    EditText VerificationEdit;
    @BindView(R.id.Verification_Btn)
    Button VerificationBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.verification_phone;
    }

    @Override
    protected void initView() {
        String phone = AppUtils.get().getString("phone", "");
        VerificationOrder.setText(VerificationOrder.getText().toString()+phone);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.Verification_back, R.id.Verification_Title, R.id.Verification_title, R.id.Verification_order, R.id.Verification_Edit, R.id.Verification_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Verification_back:
                onBackPressed();
                break;
            case R.id.Verification_Title:
                break;
            case R.id.Verification_title:
                break;
            case R.id.Verification_order:
                break;
            case R.id.Verification_Edit:
                break;
            case R.id.Verification_Btn:
                AppUtils.toast("当前无法发送验证码");
                break;
        }
    }
}
