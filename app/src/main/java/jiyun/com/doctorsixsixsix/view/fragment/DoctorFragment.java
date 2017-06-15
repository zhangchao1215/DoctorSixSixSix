package jiyun.com.doctorsixsixsix.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
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
import android.widget.ScrollView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

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
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.MainDoctorView;
import jiyun.com.doctorsixsixsix.view.activity.DoctorDetailActivity;
import jiyun.com.doctorsixsixsix.view.activity.DoctorSearchActivity;
import jiyun.com.doctorsixsixsix.view.activity.ZiMuZhouActivity;
import jiyun.com.doctorsixsixsix.view.activity.chaxun.ChaXunZhunJiaActivity;
import jiyun.com.doctorsixsixsix.view.activity.mftw.MianFeiWenActivity;

import static jiyun.com.doctorsixsixsix.R.id.Search_Text;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是第一个页面，解析数据，跳转页面抽取的view接口
 * 创建人: Administrator
 * 创建时间: 2017/6/9 20:04
 * 修改人:  张超
 * 修改内容:
 * 修改时间:2017
 */
public class DoctorFragment extends BaseFragment implements MainDoctorView {

    @BindView(R.id.yishengzaixian)
    LinearLayout yishengzaixian;
    @BindView(R.id.person)
    TextView person;
    @BindView(R.id.Doc_right)
    ImageView DocRight;
    @BindView(R.id._Doctor_province)
    TextView mDoctorProvince;
    @BindView(R.id.Doctor_Province)
    RelativeLayout DoctorProvince;
    @BindView(R.id.mymap)
    ImageView mymap;
    @BindView(R.id.province)
    LinearLayout province;
    @BindView(R.id.DocZhiCheng_Back)
    ImageView DocZhiChengBack;
    @BindView(R.id.Doc_ZhiCheng_Text)
    TextView DocZhiChengText;
    @BindView(R.id.doctor_name)
    RelativeLayout doctorName;
    @BindView(R.id.Doc_Back_Dengji)
    ImageView DocBackDengji;
    @BindView(R.id.Doc_Dengji_Text)
    TextView DocDengjiText;
    @BindView(R.id.hospital)
    RelativeLayout hospital;
    @BindView(R.id.Search_Text)
    TextView SearchText;
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
    @BindView(R.id.Doctor_HuanYiHuan)
    TextView DoctorHuanYiHuan;
    @BindView(R.id.doctor)
    RelativeLayout doctor;
    @BindView(R.id.Doctor_Gridview)
    GridView DoctorGridview;
    @BindView(R.id.doctor_scroll)
    ScrollView doctorScroll;
    Unbinder unbinder;
    private List<MainDoctorBean.DataBean> mList;
    private MainDoctorGrieViewAdapter adapter;
    private int Index = 1;
    private IDoctorPresenter presenter;
    private MyGridLayout mGridLayout1, mGridLayout2;
    private Button yes;
    private PopupWindow popupWindow_zhicheng;
    private Button sure_btn1;
    private PopupWindow popupWindow_dengji;
    private List<String> mList1;
    private List<String> mList2;
    private String province1;
    private String content;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();


    @Override
    protected int getLayoutId() {
        return R.layout.mydoctor;
    }

    @Override
    protected void initView(View view) {
        mLocationClient = new LocationClient(getContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        mList = new ArrayList<>();
        mList2 = new ArrayList<>();
        presenter = new DcotorMainImpl(this);

        adapter = new MainDoctorGrieViewAdapter(getContext(), mList);
        DoctorGridview.setAdapter(adapter);
        handler.post(new Runnable() {
            @Override
            public void run() {
                doctorScroll.smoothScrollTo(0, 0);
            }
        });


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
                intent.putExtra("doc_id", bean.getExpert_id());
                intent.putExtra("document_id", bean.getDocument_id());
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
        }).setPositiveButton("确定", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "15735971710"));
                        startActivity(intent);
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

                DocZhiChengText.setText(mGridLayout1.getLastView().getText());

                popupWindow_zhicheng.dismiss();
            }
        });


    }

    private void initDatas() {
        mList1 = new ArrayList<String>();
        mList1.add("不限");
        mList1.add("主任医师");
        mList1.add("副主任医师");
        mList1.add("主任医生");
        mList1.add("医师");
        mGridLayout1.setmList(mList1);
    }

    private void showHosrank(View view) {

        View inflate = View.inflate(getActivity(), R.layout.activity_hospital_dengji, null);
        mGridLayout2 = (MyGridLayout) inflate.findViewById(R.id.DocDengJi_myGridLayout);
        sure_btn1 = (Button) inflate.findViewById(R.id.sure);
        initDatatwo();
        popupWindow_dengji = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow_dengji.setBackgroundDrawable(new ColorDrawable());
        popupWindow_dengji.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow_dengji.setOutsideTouchable(true);

        sure_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DocDengjiText.setText(mGridLayout2.getLastView().getText());

                popupWindow_dengji.dismiss();
            }

        });
        mList2.clear();
    }

    private void initDatatwo() {

        mList2.add("不限");
        mList2.add("三级甲等");
        mList2.add("三级乙等");
        mList2.add("三级丙等");
        mList2.add("三级");
        mList2.add("二级甲等");
        mList2.add("二级已等");
        mList2.add("二级丙等");
        mGridLayout2.setmList(mList2);

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


    //跳转字母轴页面
    @Override
    public void getShengFen() {

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

    /**
     * 搜索页面的跳转回传。
     *
     * @param requestCode 跳转的返回值
     * @param resultCode  回传的返回值
     * @param data        得到的结果
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300 && resultCode == 200) {
            content = data.getStringExtra("search_content");
            SearchText.setText(content);
        }
        if (requestCode == 400 & resultCode == 250) {
            province1 = data.getStringExtra("Province");
            mDoctorProvince.setText(province1);
        }

    }

    @OnClick({R.id.mymap, R.id.Doctor_Province, Search_Text, R.id.province, R.id.doctor_name, R.id.hospital, R.id.sousuo, R.id.chaxun, R.id.add, R.id.mfwys, R.id.jkgw, R.id.gongneng, R.id.Doctor_HuanYiHuan, R.id.doctor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Doctor_Province:

                Intent Zintent = new Intent(getContext(), ZiMuZhouActivity.class);
                startActivityForResult(Zintent, 400);
                break;
            case Search_Text:
                Intent sintent = new Intent(getContext(), DoctorSearchActivity.class);
                startActivityForResult(sintent, 300);
                break;


            case R.id.province:
                getShengFen();
                break;
            case R.id.mymap:
                myMapDialog();
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
                Intent Cintent = new Intent(getContext(), ChaXunZhunJiaActivity.class);
                Cintent.putExtra("province", province1);
                Cintent.putExtra("content", content);
                Cintent.putExtra("dengji", DocDengjiText.getText().toString());

                startActivity(Cintent);
                break;
            case R.id.add:
                break;
            case R.id.mfwys:
                Intent intent1 = new Intent(getContext(), MianFeiWenActivity.class);
                startActivity(intent1);
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

    private Handler handler = new Handler();


    private void myMapDialog() {
        new AlertDialog.Builder(getActivity()).setTitle("温馨提示").setMessage("您是否允许健康血压使用定位功能.").setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("确定", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AppUtils.dialog();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AppUtils.dismiss();
                                initLocation();
                                mLocationClient.start();

                                AppUtils.toast("定位成功");
                            }
                        }, 1000);
                    }

                }).create().show();

    }




    //百度地图
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

        int span = 5000;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }

    private String dingprovince;
    public class MyLocationListener implements BDLocationListener {



        @Override
        public void onReceiveLocation(final BDLocation location) {

            //获取定位结果
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation) {

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息



                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        dingprovince = location.getProvince();
                        Log.d("MyLocationListener", location.getProvince().toString());
                        mDoctorProvince.setText(dingprovince.toString());

                    }
                });

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }

            Log.i("BaiduLocationApiDem", sb.toString());

        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

}
