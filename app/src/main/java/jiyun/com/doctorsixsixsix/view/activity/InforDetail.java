package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.Information;
import jiyun.com.doctorsixsixsix.presenter.information.IInformationPresenter;
import jiyun.com.doctorsixsixsix.presenter.information.InformationPresenter;
import jiyun.com.doctorsixsixsix.view.InformationView;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯的详情页面
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:10
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforDetail extends BaseActivity implements InformationView {
    @BindView(R.id.inforDetail_back)
    ImageView inforDetailBack;
    @BindView(R.id.inforDetail_Title)
    TextView inforDetailtitle;
    @BindView(R.id.inforDetail_title)
    RelativeLayout inforDetailTitle;
    @BindView(R.id.inforDetail_list)
    ListView inforDetailList;
    private InformationPresenter presenter;
    private List<Information.DataBean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_infordetail;
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        intent.getIntExtra("type",0);
        presenter=new IInformationPresenter(this);
        presenter.getList("18031","zhuanti_nk");
    }

    @Override
    protected void initListener() {
        inforDetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getList(List<Information.DataBean> list) {
        mList=list;
    }

    @Override
    public void shoucang(boolean boo) {

    }

}
