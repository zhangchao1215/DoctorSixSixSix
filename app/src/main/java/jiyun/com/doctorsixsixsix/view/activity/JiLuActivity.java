package jiyun.com.doctorsixsixsix.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.JiLuAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.XueYa;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/15 14:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class JiLuActivity extends BaseActivity {
    @BindView(R.id.jilu_back)
    ImageView jiluBack;
    @BindView(R.id.jilu_Title)
    TextView jilutitle;
    @BindView(R.id.jilu_title)
    RelativeLayout jiluTitle;
    @BindView(R.id.jilu_list)
    ListView jiluList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_jilu;
    }

    @Override
    protected void initView() {
        List<XueYa> list = App.getDaoInstant().getXueYaDao().queryBuilder().list();
        JiLuAdapter adapter=new JiLuAdapter(list,JiLuActivity.this);
        jiluList.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        jiluBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
