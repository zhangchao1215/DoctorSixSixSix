package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.DataCleanManager;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/10 8:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.setting_back)
    ImageView settingBack;
    @BindView(R.id.setting_title)
    RelativeLayout settingTitle;
    @BindView(R.id.setting_account)
    TextView settingAccount;
    @BindView(R.id.setting_clear)
    TextView settingClear;
    @BindView(R.id.setting_about)
    TextView settingAbout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
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


    @OnClick(R.id.setting_back)
    public void onSettingBackClicked() {
        onBackPressed();
    }

    @OnClick(R.id.setting_title)
    public void onSettingTitleClicked() {
    }

    @OnClick(R.id.setting_account)
    public void onSettingAccountClicked() {
        Intent intent=new Intent(SettingActivity.this,AccountActivity.class);
        startActivityForResult(intent,100);
    }

    @OnClick(R.id.setting_clear)
    public void onSettingClearClicked() {
        DataCleanManager.cleanInternalCache(SettingActivity.this);
        AppUtils.toast("清理完成");
    }

    @OnClick(R.id.setting_about)
    public void onSettingAboutClicked() {
        Intent intent=new Intent(SettingActivity.this,AboutActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                switch (resultCode){
                    case 200:
                        setResult(2);
                        onBackPressed();
                        break;
                }
                break;
        }
    }
}
