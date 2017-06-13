package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.ZiMuZhouAdapter;

/**
 * 项目名称: 血压卫士
 * 类描述: 实现字母轴的效果
 * 创建人: Administrator
 * 创建时间: 2017/6/9 15:42
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ZiMuZhouActivity extends BaseActivity {


    @BindView(R.id.ZiMu_Back)
    ImageView ZiMuBack;
    @BindView(R.id.ZiMu_ListView)
    ListView ZiMuListView;
    @BindView(R.id.ZiMu_Zhou)
    NavieView ZiMuZhou;
    private ZiMuZhouAdapter adapter;
    private Boolean isCheck = false;
    private List<String> mList;
    private String[] city = {"不限", "北京市", "山东省", "山西省", "河北省",
            "内蒙古自治区", "新疆维吾尔自治区", "云南省", "甘肃省", "陕西省", "重庆市", "四川省",
            "上海市", "湖南省", "湖北省", "吉林省", "黑龙江省", "辽宁省", "天津市", "河南省",
            "海南省", "贵州省", "青海省", "广东省", "宁夏回族自治区", "西藏自治区", "广西壮族自治区", "江苏省", "浙江省", "安徽省", "江西省", "福建省"
    };

    @Override
    protected int getLayoutId() {
        return R.layout.chao_activity_zimuzhou;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        for (int i = 0; i < city.length; i++) {
            mList.add(city[i]);
        }
        adapter = new ZiMuZhouAdapter(this, mList);
        ZiMuListView.setAdapter(adapter);
        //默认为false

        ZiMuZhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZiMuZhou.setBackgroundResource(R.color.colorZiMuChou);

            }
        });

        getClick();


    }

    @Override
    protected void initListener() {
    }

    private void getClick() {
        ZiMuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mList.get(position);

                Intent intent = new Intent();

                setResult(250, intent.putExtra("Province", s));

                onBackPressed();
            }
        });
    }

    @Override
    protected void initData() {

    }


}
