package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.InforDetailBean;
import jiyun.com.doctorsixsixsix.modle.bean.Information;
import jiyun.com.doctorsixsixsix.presenter.information.DetailPresenter;
import jiyun.com.doctorsixsixsix.presenter.information.IDetailPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;

/**
 * 项目名称: 血压卫士
 * 类描述: 详情主页面
 * 创建人: 马杰
 * 创建时间: 2017/6/12 11:59
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DetailInfor extends BaseActivity implements DetailView {
    @BindView(R.id.infor_title)
    TextView inforTitle;
    @BindView(R.id.infor_order)
    TextView inforOrder;
    @BindView(R.id.infor_date)
    TextView inforDate;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.Detail_back)
    ImageView DetailBack;
    @BindView(R.id.Detail_Title)
    TextView Detailtitle;
    @BindView(R.id.Detail_shoucang)
    ImageView DetailShoucang;
    @BindView(R.id.Detail_title)
    RelativeLayout DetailTitle;
    private DetailPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.infor_itemone;
    }

    @Override
    protected void initView() {
        textView2.setVisibility(View.GONE);
        DetailShoucang.setVisibility(View.VISIBLE);
        presenter = new IDetailPresenter(this);
    }

    @Override
    protected void initListener() {
        DetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        DetailShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String typeid = intent.getStringExtra("typeid");
        String dir = intent.getStringExtra("dir");
        presenter.getData(typeid, dir);
    }


    @Override
    public void getData(final InforDetailBean.DataBean dataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                inforTitle.setText(dataBean.getTitle());
                inforOrder.setText(dataBean.getBody());
                inforDate.setText(AppUtils.longToString(dataBean.getPubdate(), "yyyy年M月dd日 hh:mm:ss"));
            }
        });
    }

}
