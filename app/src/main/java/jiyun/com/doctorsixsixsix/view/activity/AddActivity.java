package jiyun.com.doctorsixsixsix.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:我的加号页面，先给一个死数据
 * 创建人: 马杰
 * 创建时间: 2017/6/11 21:07
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AddActivity extends BaseActivity {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_Title)
    TextView collectiontitle;
    @BindView(R.id.collection_title)
    RelativeLayout collectionTitle;
    @BindView(R.id.collection_list)
    ListView collectionList;
    @BindView(R.id.collection_text)
    TextView collectionText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initView() {
        collectionList.setVisibility(View.GONE);
        collectionText.setVisibility(View.VISIBLE);
        collectionText.setText("没有获取到数据，请确认您是否加号");
        collectiontitle.setText("我的加号");
    }

    @Override
    protected void initListener() {
        collectionBack.setOnClickListener(new View.OnClickListener() {
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
