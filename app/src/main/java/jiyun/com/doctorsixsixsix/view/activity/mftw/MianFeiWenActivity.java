package jiyun.com.doctorsixsixsix.view.activity.mftw;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 16:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MianFeiWenActivity extends BaseActivity {


    @BindView(R.id.mfy_back)
    ImageView accountBack;
    @BindView(R.id.mfy_Title)
    TextView accountTitle;
    @BindView(R.id.wenyisheng)
    RelativeLayout wenyisheng;
    @BindView(R.id.add_img)
    ImageView addImg;
    @BindView(R.id.tiwenyisheng)
    RelativeLayout tiwenyisheng;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mfwys;
    }

    @Override
    protected void initView() {
        addImg = (ImageView) findViewById(R.id.add_img);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.tiwenyisheng,R.id.mfy_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.tiwenyisheng:
                Intent intent = new Intent(MianFeiWenActivity.this,WenTiActivity.class);
                startActivity(intent);
                break;
            case R.id.mfy_back:
                onBackPressed();
                break;
        }
    }
}
