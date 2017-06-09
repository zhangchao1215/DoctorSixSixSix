package jiyun.com.doctorsixsixsix.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.presenter.ILoginPresenter;
import jiyun.com.doctorsixsixsix.presenter.LoginPresenter;
import jiyun.com.doctorsixsixsix.view.LoginView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 19:56
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.denglu)
    LinearLayout denglu;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.telephone)
    LinearLayout telephone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.password)
    LinearLayout password;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.zhuce)
    TextView zhuce;
    private LoginPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.login;
    }

    @Override
    protected void initView() {
        presenter=new ILoginPresenter(this);
    }

    @Override
    protected void initListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login(pwd.getText().toString().trim(),phone.getText().toString().trim());
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void login() {
        setResult(0);
        onBackPressed();
    }
}
