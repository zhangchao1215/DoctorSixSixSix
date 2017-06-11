package jiyun.com.doctorsixsixsix.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;

/**
 * 项目名称: 血压卫士
 * 类描述: 个人账号信息
 * 创建人: dell
 * 创建时间: 2017/6/10 10:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AccountActivity extends BaseActivity {

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    protected void initView() {
        SharedPreferences sharedPreferences = AppUtils.get();
        String phone = sharedPreferences.getString("phone", "");
        accountPhone.setText("手机号码"+"           "+phone);
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
                getDialogTwo();
                break;
            case R.id.account_backlogin:
                getDialog();
                break;
        }
    }
    private void getDialog(){
        AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("退出登录")
                .setMessage("退出不会删除任何数据，下次登录可使用本账号")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNeutralButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setResult(200);
                        onBackPressed();
                    }
                }).create();
        dialog.show();
    }
    private void getDialogTwo(){
        View view= LayoutInflater.from(this).inflate(R.layout.dialog_edit,null);
        final EditText edit= (EditText) view.findViewById(R.id.dialog_pwd);
        AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("验证密码")
                .setMessage("验证原密码，更新新密码前，请输入旧密码来保证您的账户安全")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNeutralButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences sharedPreferences = AppUtils.get();
                        String pwd = sharedPreferences.getString("pwd", "");
                        if(edit.getText().toString().trim().equals(pwd)){
                            Intent intent=new Intent(AccountActivity.this,ModifyActivity.class);
                            startActivity(intent);
                            AppUtils.toast("密码验证成功");
                        }else{
                            AppUtils.toast("密码输入错误");
                            dialog.dismiss();
                        }

                    }
                }).create();
        dialog.show();
    }
}
