package jiyun.com.doctorsixsixsix.view.fragment.detailfragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.doctor.DocShareRecyAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.DoctorShareBean;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.DocSharePreImpl;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.IDocSharePresenter;
import jiyun.com.doctorsixsixsix.view.DocShareView;

/**
 * 项目名称: 血压卫士
 * 类描述: 专家的经验分享
 * 创建人: Administrator
 * 创建时间: 2017/6/11 20:56
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class SharedFragment extends BaseFragment implements DocShareView, DocShareRecyAdapter.OnClickListener {
    @BindView(R.id.mRecyclerview)
    RecyclerView mRecyclerview;

    private List<DoctorShareBean.DataBean> mList;
    private DocShareRecyAdapter adapter;
    private IDocSharePresenter sharePresenter;
    private String id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_recycler;
    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();

        sharePresenter = new DocSharePreImpl(this);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));

        Intent intent = getActivity().getIntent();
        id = intent.getStringExtra("doc_id");
        sharePresenter.DocShare(id);

        adapter = new DocShareRecyAdapter(mList);

        mRecyclerview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void DocShare(List<DoctorShareBean.DataBean> lodaList) {
        mList.addAll(lodaList);
        adapter.notifyDataSetChanged();
    }


    //自定义每个item的点击事件
    @Override
    public void onClick(int postion) {

    }


}
