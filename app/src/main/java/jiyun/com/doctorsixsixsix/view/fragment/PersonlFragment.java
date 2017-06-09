package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.presenter.PerSonlPresenter;
import jiyun.com.doctorsixsixsix.presenter.PersonlPresenterlmp;
import jiyun.com.doctorsixsixsix.view.PersonlView;

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
    private String path;
    private ImageView mImageView;

    @Override
    public void upLoadImage(String msg) {
        Factory.create(Factory.OKHTTP).loadImage(msg, mImageView, true);
    }

    @Override
    public void dialog() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mycenter;
    }

    @Override
    protected void initView(View view) {
        presenter = new PersonlPresenterlmp(this);
        mImageView = (ImageView) view.findViewById(R.id.my_image);
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
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,4);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 4:
                switch (resultCode){
                    case 0:
                        myLogin.setVisibility(View.GONE);
                        mImageView.setVisibility(View.VISIBLE);
                        break;
                }
                break;
        }
    }
}
