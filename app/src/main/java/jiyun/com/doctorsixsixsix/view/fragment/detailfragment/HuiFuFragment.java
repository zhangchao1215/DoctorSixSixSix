package jiyun.com.doctorsixsixsix.view.fragment.detailfragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.DoctorDetailAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.DoctorDetailBean;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.DocDetailPreImpl;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.IDocDetailPre;
import jiyun.com.doctorsixsixsix.view.DoctorHuiFuView;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是医生回复的解析数据，那个刷新操作还没写
 * 创建人: 张超
 * 创建时间: 2017/6/11 20:55
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class HuiFuFragment extends BaseFragment implements DoctorHuiFuView {
    @BindView(R.id.pull_recycler)
    PullToRefreshRecyclerView pullRecycler;
    private List<DoctorDetailBean.DataBean> mList;
    private DoctorDetailAdapter adapter;
    private int Index = 1;
    private String expertid;
    private IDocDetailPre docPresenter;
    Handler handler = new Handler();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pullrecycler;
    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();

        docPresenter = new DocDetailPreImpl(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        pullRecycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        pullRecycler.setLayoutManager(manager);

        Intent intent = getActivity().getIntent();
        expertid = intent.getStringExtra("doc_id");

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//            }
//        }, 500);

        adapter = new DoctorDetailAdapter(getContext(), mList);

        pullRecycler.setAdapter(adapter);


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        docPresenter.DocDetail(Integer.parseInt(expertid), Index);

    }

    //这是view层实现的接口
    @Override
    public void DocHuiFu(List<DoctorDetailBean.DataBean> LodaList) {
        mList.addAll(LodaList);
        adapter.notifyDataSetChanged();

    }

}
