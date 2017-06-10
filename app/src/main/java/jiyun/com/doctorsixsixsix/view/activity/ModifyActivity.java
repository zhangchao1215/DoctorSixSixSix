package jiyun.com.doctorsixsixsix.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.presenter.IModifyPresenter;
import jiyun.com.doctorsixsixsix.presenter.ModifyPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.ModifyView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/10 11:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ModifyActivity extends BaseActivity implements ModifyView{
    @BindView(R.id.modify_back)
    ImageView modifyBack;
    @BindView(R.id.modify_title)
    RelativeLayout modifyTitle;
    @BindView(R.id.modify_pwd)
    EditText modifyPwd;
    @BindView(R.id.modify_pwdOne)
    EditText modifyPwdOne;
    @BindView(R.id.xiugai)
    Button xiugai;
    private String pwd;
    private ModifyPresenter presenter;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modifypwd;
    }

    @Override
    protected void initView() {
        presenter=new IModifyPresenter(this);
    }

    @Override
    protected void initListener() {
        modifyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.xiugai)
    public void onViewClicked() {
        SharedPreferences sharedPreferences = AppUtils.get();
        editor=AppUtils.put();
        String id = sharedPreferences.getString("id", "");
        pwd=modifyPwd.getText().toString();
        if(modifyPwdOne.getText().toString().equals(modifyPwd.getText().toString())) {
            presenter.modify(modifyPwd.getText().toString(),id);
        }else{
            AppUtils.toast("密码验证错误");
        }
    }

    @Override
    public void modify() {
        AppUtils.toast("密码更改成功");
        editor.putString("pwd",pwd);
        editor.commit();
        onBackPressed();
    }
}
