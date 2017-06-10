package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.presenter.PerSonlPresenter;
import jiyun.com.doctorsixsixsix.presenter.PersonlPresenterlmp;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.PersonlView;
import jiyun.com.doctorsixsixsix.view.activity.SettingActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/9 16:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonlFragment extends BaseFragment implements PersonlView {
    public PerSonlPresenter presenter;
    @BindView(R.id.my_login)
    Button myLogin;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_beijing)
    RelativeLayout myBeijing;
    @BindView(R.id.my_jiahao)
    TextView myJiahao;
    @BindView(R.id.my_shoucang)
    TextView myShoucang;
    @BindView(R.id.my_ziliao)
    TextView myZiliao;
    @BindView(R.id.my_message)
    TextView myMessage;
    @BindView(R.id.my_setting)
    TextView mySetting;
    Unbinder unbinder;
    private String id;
    private String sign;
    private ImageView mImageView;
    private SharedPreferences sharedPreferences;

    @Override
    public void upLoadImage(String msg) {
        Factory.create(Factory.OKHTTP).loadImage(msg, mImageView, true);
    }

    @Override
    public void dialog() {

    }

    @Override
    public void getPerson() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mycenter;
    }

    @Override
    protected void initView(View view) {
        presenter = new PersonlPresenterlmp(this);
        sharedPreferences = AppUtils.get();
        boolean login = sharedPreferences.getBoolean("login", false);
        id = sharedPreferences.getString("id", "");
        mImageView = (ImageView) view.findViewById(R.id.my_image);
        if(login){
            myLogin.setVisibility(View.GONE);
            mImageView.setVisibility(View.VISIBLE);
            presenter.getPerson(id,"ee3dd4651821d3a45f4329a86d459cb7");
        }else{

        }
    }

    @Override
    protected void initListener() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDialog();
            }
        });
        myLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转登录界面
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,4);
            }
        });
        mySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SettingActivity.class);
                startActivityForResult(intent,4);
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       //跳转回传判断是否登录成功，对控件进行显示隐藏
        switch (requestCode){
            case 4:
                switch (resultCode){
                    case 1:
                        id = sharedPreferences.getString("id", "");
                        myLogin.setVisibility(View.GONE);
                        mImageView.setVisibility(View.VISIBLE);
                        presenter.getPerson(id,"ee3dd4651821d3a45f4329a86d459cb7");
                        break;
                    case 2:
                        myLogin.setVisibility(View.VISIBLE);
                        mImageView.setVisibility(View.GONE);
                        break;
                }
                break;
        }
    }
}
