package jiyun.com.doctorsixsixsix.view.activity.chaxun;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.doctor.JiaHaoItemAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.JiaHaoDocBean;
import jiyun.com.doctorsixsixsix.presenter.chaxun.IJiaHaoPrestener;
import jiyun.com.doctorsixsixsix.presenter.chaxun.JiaHaoPreImpl;
import jiyun.com.doctorsixsixsix.view.JiaHaoDocView;

/**
 * 项目名称: 血压卫士
 * 类描述: 点击添加加号
 * 创建人: Administrator
 * 创建时间: 2017/6/13 9:15
 * 修改人:  张超
 * 修改内容:
 * 修改时间:  怎么回事 这是加号 啊啊啊
 */

public class JiaHaoActivity extends BaseActivity implements JiaHaoDocView {
    @BindView(R.id.JiaHao_Doctor_Image)
    ImageView JiaHaoDoctorImage;
    @BindView(R.id.JiaHao_Doctor_Name)
    TextView JiaHaoDoctorName;
    @BindView(R.id.JaiHao_Doctor_YiYuan)
    TextView JaiHaoDoctorYiYuan;
    @BindView(R.id.JiaHao_Doctor_JiBie)
    TextView JiaHaoDoctorJiBie;
    @BindView(R.id.JiaHao_Doctor_KeShi)
    TextView JiaHaoDoctorKeShi;
    @BindView(R.id.center)
    LinearLayout center;
    @BindView(R.id.JiaHao_Doctor_ZhiCheng)
    TextView JiaHaoDoctorZhiCheng;
    @BindView(R.id.JiaHao_Content)
    TextView JiaHaoContent;
    @BindView(R.id.JiaHao_LinearLayout)
    LinearLayout JiaHaoLinearLayout;
    @BindView(R.id.JiaHao_Listview)
    ListView JiaHaoListview;
    @BindView(R.id.ChaXun_RelativeLayout)
    RelativeLayout ChaXunRelativeLayout;
    @BindView(R.id.JiaHao_ImageBack)
    ImageView JiaHaoImageBack;
    @BindView(R.id.JiaHao_RelaTitle)
    RelativeLayout JiaHaoRelaTitle;
    @BindView(R.id.JiHao_LinearTitle)
    LinearLayout JiHaoLinearTitle;
    private IJiaHaoPrestener prestener;
    private List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> mList;
    private JiaHaoItemAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.chaxunzhuanjia_jiahao_item;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        prestener = new JiaHaoPreImpl(this);


        getIntContent();

        adapter = new JiaHaoItemAdapter(this, mList);
        JiaHaoListview.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    private void getIntContent() {

        Intent intent = getIntent();
        String content = intent.getStringExtra("doc_content");
        JiaHaoContent.setText(content);

        String name = intent.getStringExtra("doc_name");
        JiaHaoDoctorName.setText(name);

        //这是主任医师
        String title = intent.getStringExtra("doc_title");
        JiaHaoDoctorJiBie.setText(title);

        //这是医院
        String hospital = intent.getStringExtra("doc_hospital");
        JiaHaoDoctorZhiCheng.setText(hospital);

        //这是教授
        String teach = intent.getStringExtra("doc_teach");
        JiaHaoDoctorKeShi.setText(teach);

        //这是所属科室
        String depart = intent.getStringExtra("doc_depart");
        JaiHaoDoctorYiYuan.setText(depart);


        String image = intent.getStringExtra("app_image");

        Glide.with(this).load(image).into(JiaHaoDoctorImage);

        String id = intent.getStringExtra("doc_id");

        String mId = intent.getStringExtra("document_id");

        prestener.JiaHao(id, mId);

        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void JiaHao(List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> lodaList) {
        mList.addAll(lodaList);

        adapter.notifyDataSetChanged();

    }


    @OnClick(R.id.JiaHao_ImageBack)
    public void onViewClicked() {
        onBackPressed();
    }
}
