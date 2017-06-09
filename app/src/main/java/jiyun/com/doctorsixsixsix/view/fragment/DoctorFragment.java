package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.MainDoctorGrieViewAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.DcotorMainImpl;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.IDoctorPresenter;
import jiyun.com.doctorsixsixsix.view.MainDoctorView;
import jiyun.com.doctorsixsixsix.view.activity.ZiMuZhouActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是第一个页面，解析数据，跳转页面抽取的view接口
 * 创建人: Administrator
 * 创建时间: 2017/6/9 20:04
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorFragment extends BaseFragment implements MainDoctorView {
    @BindView(R.id.yishengzaixian)
    LinearLayout yishengzaixian;
    @BindView(R.id.person)
    TextView person;
    @BindView(R.id.mymap)
    ImageView mymap;
    @BindView(R.id.province)
    RelativeLayout province;
    @BindView(R.id.doctor_name)
    RelativeLayout doctorName;
    @BindView(R.id.hospital)
    RelativeLayout hospital;
    @BindView(R.id.sousuo)
    RelativeLayout sousuo;
    @BindView(R.id.chaxun)
    Button chaxun;
    @BindView(R.id.add)
    LinearLayout add;
    @BindView(R.id.Linear_color1)
    LinearLayout LinearColor1;
    @BindView(R.id.mfwys)
    RadioButton mfwys;
    @BindView(R.id.jkgw)
    RadioButton jkgw;
    @BindView(R.id.gongneng)
    LinearLayout gongneng;
    @BindView(R.id.Linear_color2)
    LinearLayout LinearColor2;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.doctor)
    RelativeLayout doctor;
    @BindView(R.id.Doctor_Gridview)
    GridView DoctorGridview;
    Unbinder unbinder;
    @BindView(R.id.Doctor_HuanYiHuan)
    TextView DoctorHuanYiHuan;
    Unbinder unbinder1;
    Unbinder unbinder2;
    private List<MainDoctorBean.DataBean> mList;
    private MainDoctorGrieViewAdapter adapter;
    private int Index = 1;
    private IDoctorPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.mydoctor;
    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();
        presenter = new DcotorMainImpl(this);

        adapter = new MainDoctorGrieViewAdapter(getContext(), mList);
        DoctorGridview.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        presenter.getMainDoctor(Index);

    }

    @Override
    public void LoadData(List<MainDoctorBean.DataBean> ShowData) {
        mList.addAll(ShowData);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void SendToast(String msg) {

    }

    @Override
    public void onLoadMore(List<MainDoctorBean.DataBean> LoadList) {

    }

    @Override
    public void getShengFen() {
        Intent intent = new Intent(getContext(), ZiMuZhouActivity.class);

        startActivity(intent);
    }

    @Override
    public void getDoctorTitle() {

    }

    @Override
    public void getHospital() {

    }

    @Override
    public void getSearch() {

    }

    @Override
    public void QueryZhuanJia() {

    }

    @Override
    public void AskDoctor() {

    }

    @Override
    public void JiankangDialog() {

    }


    @OnClick({R.id.province, R.id.hospital, R.id.sousuo, R.id.chaxun, R.id.add, R.id.mfwys, R.id.jkgw, R.id.gongneng, R.id.Doctor_HuanYiHuan, R.id.doctor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.province:
                getShengFen();

                break;
            case R.id.hospital:
                break;
            case R.id.sousuo:
                break;
            case R.id.chaxun:
                break;
            case R.id.add:
                break;
            case R.id.mfwys:
                break;
            case R.id.jkgw:
                break;
            case R.id.gongneng:
                break;
            case R.id.Doctor_HuanYiHuan:
                mList.clear();
                presenter.getMainDoctor(Index++);
                break;
            case R.id.doctor:
                break;
        }
    }

}
