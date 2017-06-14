package jiyun.com.doctorsixsixsix.view.activity.chaxun;

import android.content.Intent;
import android.text.Html;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.DoctorWenZhangBean;
import jiyun.com.doctorsixsixsix.presenter.chaxun.DocWenZhangPreImpl;
import jiyun.com.doctorsixsixsix.presenter.chaxun.IDocWenZhangPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.DoctorWenZhangDetail;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 7:59
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocSharedDetailActivity extends BaseActivity implements DoctorWenZhangDetail {


    @BindView(R.id.WZ_ImageBack)
    ImageView WZImageBack;
    @BindView(R.id.WenZhang_RelaTitle)
    RelativeLayout WenZhangRelaTitle;
    @BindView(R.id.Wz_TextTitle)
    TextView WzTextTitle;
    @BindView(R.id.Wz_Content)
    TextView WzContent;
    @BindView(R.id.Wz_Time)
    TextView WzTime;
    private String id;
    private IDocWenZhangPresenter presenter;
    private String dateId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doc_detail_wenzhang;
    }

    @Override
    protected void initView() {
        presenter = new DocWenZhangPreImpl(this);

        Intent intent = getIntent();
        id = intent.getStringExtra("Titleid");

        String title = intent.getStringExtra("title");

        WzTextTitle.setText(title);

        dateId = intent.getStringExtra("cateId");

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter.WenZhang(id, dateId);

    }


    @Override
    public void WenZhang(DoctorWenZhangBean.DataBean beanList) {

        String addtime = beanList.getAddtime();

        Long ll = Long.parseLong(addtime);

        String str = AppUtils.longToString(ll * 1000, "yyyy-M-dd");

        WzTime.setText(str);


        WzContent.setText(Html.fromHtml(beanList.getContents()));

    }


    @OnClick(R.id.WZ_ImageBack)
    public void onViewClicked() {
        onBackPressed();
    }



}

