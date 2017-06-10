package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.User;
import jiyun.com.doctorsixsixsix.presenter.ILoginPresenter;
import jiyun.com.doctorsixsixsix.presenter.LoginPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
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

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.denglu)
    LinearLayout denglu;
    @BindView(R.id.telephone)
    EditText telephone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.three)
    TextView three;
    @BindView(R.id.weixin)
    RadioButton weixin;
    @BindView(R.id.qq)
    RadioButton qq;
    @BindView(R.id.disanfang)
    LinearLayout disanfang;
    private LoginPresenter presenter;
    private SharedPreferences.Editor put = AppUtils.put();

    @Override
    protected int getLayoutId() {
        return R.layout.login;
    }

    @Override
    protected void initView() {
        presenter = new ILoginPresenter(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public void login(User user) {
        put.putString("id", user.getUserid());
        put.putString("phone",user.getPhonenum());
        setResult(1);
        onBackPressed();
    }


    @OnClick({R.id.back, R.id.register, R.id.telephone, R.id.password, R.id.login, R.id.weixin, R.id.qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.register:
                break;
            case R.id.telephone:
                break;
            case R.id.password:
                break;
            case R.id.login:
                put.putString("pwd",password.getText().toString().trim());
                put.commit();
                presenter.login(password.getText().toString().trim(), telephone.getText().toString().trim());
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
                break;
        }
    }
}
