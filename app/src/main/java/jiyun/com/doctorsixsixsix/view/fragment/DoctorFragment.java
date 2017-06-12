package jiyun.com.doctorsixsixsix.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.MainDoctorGrieViewAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.DcotorMainImpl;
import jiyun.com.doctorsixsixsix.presenter.doctorchao.IDoctorPresenter;
import jiyun.com.doctorsixsixsix.view.MainDoctorView;
import jiyun.com.doctorsixsixsix.view.activity.DoctorDetailActivity;
import jiyun.com.doctorsixsixsix.view.activity.ZiMuZhouActivity;
import jiyun.com.doctorsixsixsix.view.activity.mftw.MianFeiWenActivity;

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
  
    private List<MainDoctorBean.DataBean> mList;
    private MainDoctorGrieViewAdapter adapter;
    private int Index = 1;
    private IDoctorPresenter presenter;
    private MyGridLayout mGridLayout1;
    private Button yes;
    private PopupWindow popupWindow_zhicheng;
    private Button sure_btn1;
    private PopupWindow popupWindow_dengji;
    private List<String> mList1;

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
        DoctorGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainDoctorBean.DataBean bean = mList.get(position);
                Intent intent = new Intent(getContext(), DoctorDetailActivity.class);
                intent.putExtra("app_image", bean.getApp_image());
                intent.putExtra("doc_name", bean.getName());
                intent.putExtra("doc_title", bean.getTitle());
                intent.putExtra("doc_teach", bean.getTeach());
                intent.putExtra("doc_hospital", bean.getHospital());
                intent.putExtra("doc_content", bean.getGoodat());
                intent.putExtra("doc_depart", bean.getDepart());
                intent.putExtra("doc_id",bean.getExpert_id());

                App.activity.startActivity(intent);
            }
        });
    }

    /**
     * //健康询问提示框
     */
    private void show() {
        new AlertDialog.Builder(getActivity()).setTitle("温馨提示").setMessage("您是否要拨打寻医问药的健康电话：400-9700-120").setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create().show();
    }

    private void showTechnical(View view) {
        View inflate = View.inflate(getActivity(), R.layout.activity_dactor_name, null);
        mGridLayout1 = (MyGridLayout) inflate.findViewById(R.id.dragable_myGridLayout);
        yes = (Button) inflate.findViewById(R.id.Yes);
        initDatas();
        popupWindow_zhicheng = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow_zhicheng.setBackgroundDrawable(new ColorDrawable());
        popupWindow_zhicheng.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow_zhicheng.setOutsideTouchable(true);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_zhicheng.dismiss();
            }
        });
    }

    private void initDatas() {
        mGridLayout1.setDragAble(false);
        mList1 = new ArrayList<String>();
        mList1.add("不限");
        mList1.add("主任医师");
        mList1.add("副主任医师");
        mList1.add("主任医生");
        mList1.add("医师");
        mGridLayout1.setItems(mList1);
    }

    private void showHosrank(View view) {

        View inflate = View.inflate(getActivity(), R.layout.activity_hospital_dengji, null);
        mGridLayout1 = (MyGridLayout) inflate.findViewById(R.id.dragable_myGridLayout);
        sure_btn1 = (Button) inflate.findViewById(R.id.sure);
        initDatatwo();
        popupWindow_dengji = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow_dengji.setBackgroundDrawable(new ColorDrawable());
        popupWindow_dengji.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow_dengji.setOutsideTouchable(true);

        sure_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_dengji.dismiss();
            }
        });

    }

    private void initDatatwo() {

        mGridLayout1.setDragAble(false);
        mList1 = new ArrayList<String>();
        mList1.add("不限");
        mList1.add("三级甲等");
        mList1.add("三级乙等");
        mList1.add("三级丙等");
        mList1.add("三级");
        mList1.add("二级甲等");
        mList1.add("二级已等");
        mList1.add("二级丙等");
        mGridLayout1.setItems(mList1);

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


    @OnClick({R.id.province, R.id.doctor_name,R.id.hospital, R.id.sousuo, R.id.chaxun, R.id.add, R.id.mfwys, R.id.jkgw, R.id.gongneng, R.id.Doctor_HuanYiHuan, R.id.doctor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.province:
                getShengFen();
                break;
            case R.id.hospital:
                showHosrank(view);
                break;
            case R.id.doctor_name:
                showTechnical(view);
                break;
            case R.id.sousuo:
                break;
            case R.id.chaxun:
                break;
            case R.id.add:
                break;
            case R.id.mfwys:
                Intent intent = new Intent(getContext(), MianFeiWenActivity.class);
                startActivity(intent);
                break;
            case R.id.jkgw:
                show();
                break;
            case R.id.gongneng:
                break;
            case R.id.Doctor_HuanYiHuan:
                mList.clear();
                Index++;
                presenter.getMainDoctor(Index);
                break;
            case R.id.doctor:
                break;
        }
    }

}
