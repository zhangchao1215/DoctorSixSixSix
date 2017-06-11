package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.MyFragmentAdapter;
import jiyun.com.doctorsixsixsix.view.fragment.detailfragment.HuiFuFragment;
import jiyun.com.doctorsixsixsix.view.fragment.detailfragment.SharedFragment;
import jiyun.com.doctorsixsixsix.view.fragment.detailfragment.TimeFragment;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是点击换一换的详情
 * 创建人: Administrator
 * 创建时间: 2017/6/11 20:46
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorDetailActivity extends BaseActivity {

    @BindView(R.id.Doctor_Detail_Back)
    ImageView mImageBack;
    @BindView(R.id.doc_title)
    RelativeLayout docTitle;
    @BindView(R.id.doc_detail_image)
    ImageView docDetailImage;
    @BindView(R.id.doc_detail_name)
    TextView docDetailName;
    @BindView(R.id.doc_detail_hostail)
    TextView docDetailHostail;
    @BindView(R.id.doc_detail_ZhiWei)
    TextView docDetailZhiWei;
    @BindView(R.id.doc_detail_Keshi)
    TextView docDetailKeshi;
    @BindView(R.id.doc_detail_JiaoShow)
    TextView docDetailJiaoShow;
    @BindView(R.id.doc_retail_content)
    RelativeLayout docRetailContent;
    @BindView(R.id.doc_detail_Linear)
    RelativeLayout docDetailLinear;
    @BindView(R.id.doc_detail_TabLayout)
    TabLayout mTab;
    @BindView(R.id.doc_detail_ViewPager)
    ViewPager mPager;
    @BindView(R.id.doc_detail_content)
    TextView docDetailContent;
    private MyFragmentAdapter adapter;
    private List<String> strList;
    private List<Fragment> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_detail;

    }

    @Override
    protected void initView() {
        strList = new ArrayList<>();
        mList = new ArrayList<>();
        mImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getIntentContent();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void initListener() {
        strList.add("专家回复");
        strList.add("出诊时间表");
        strList.add("专家经验分享");
        mList.add(new HuiFuFragment());
        mList.add(new TimeFragment());
        mList.add(new SharedFragment());

        mTab.setTabMode(TabLayout.MODE_FIXED);
        adapter = new MyFragmentAdapter(getSupportFragmentManager(), mList, strList);

        mPager.setAdapter(adapter);

        mTab.setupWithViewPager(mPager);


    }

    @Override
    protected void initData() {

    }

    private void getIntentContent() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("app_image");
        String doc_name = intent.getStringExtra("doc_name");
        String doc_title = intent.getStringExtra("doc_title");
        String doc_teach = intent.getStringExtra("doc_teach");
        String doc_hospital = intent.getStringExtra("doc_hospital");
        String doc_content = intent.getStringExtra("doc_content");
        String doc_depart = intent.getStringExtra("doc_depart");
         //得到姓名
        docDetailName.setText(doc_name);
        //得到医院
        docDetailHostail.setText(doc_hospital);
        //得到职位
        docDetailZhiWei.setText(doc_title);
        // 得到所属科室
        docDetailKeshi.setText(doc_depart);
        // 得到职称
        docDetailJiaoShow.setText(doc_teach);
        // 得到内容
        docDetailContent.setText(doc_content);
        Glide.with(this).load(image).into(docDetailImage);


    }

}
