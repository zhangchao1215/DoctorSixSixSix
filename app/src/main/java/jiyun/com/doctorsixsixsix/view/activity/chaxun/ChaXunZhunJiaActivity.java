package jiyun.com.doctorsixsixsix.view.activity.chaxun;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.doctor.ChaXunAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.presenter.chaxun.ChaXunPreImpl;
import jiyun.com.doctorsixsixsix.presenter.chaxun.IChaXunPresenter;
import jiyun.com.doctorsixsixsix.view.ChaXunZhuanJiaView;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是点击查询专家跳转页面解析数据
 * 创建人: Administrator
 * 创建时间: 2017/6/12 14:29
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ChaXunZhunJiaActivity extends BaseActivity implements ChaXunZhuanJiaView {
    @BindView(R.id.ChaXun_Recycler)
    PullToRefreshRecyclerView pullRecycler;
    @BindView(R.id.chaxun_Back)
    ImageView chaxunBack;
    @BindView(R.id.chaxun_RelaTitle)
    RelativeLayout chaxunRelaTitle;
    private List<MainDoctorBean.DataBean> mList;
    private ChaXunAdapter adapter;
    private IChaXunPresenter presenter;
    private int Index = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.chaxun_pullrecycler;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        pullRecycler.setLayoutManager(manager);

        presenter = new ChaXunPreImpl(this);
        presenter.ChaXun(Index);

        adapter = new ChaXunAdapter(this, mList);
        pullRecycler.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    @Override
    public void ChaXun(List<MainDoctorBean.DataBean> lodaList) {
        mList.addAll(lodaList);
        adapter.notifyDataSetChanged();
    }


    @OnClick(R.id.chaxun_Back)
    public void onViewClicked() {
        onBackPressed();
    }
}
