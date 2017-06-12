package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯页面
 * 创建人: 马杰
 * 创建时间: 2017/6/12 8:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InformationActivity extends BaseActivity {
    @BindView(R.id.information_back)
    ImageView informationBack;
    @BindView(R.id.information_Title)
    TextView informationtitle;
    @BindView(R.id.information_title)
    RelativeLayout informationTitle;
    @BindView(R.id.information_common)
    TextView informationCommon;
    @BindView(R.id.information_recipes)
    TextView informationRecipes;
    @BindView(R.id.information_prevention)
    TextView informationPrevention;
    @BindView(R.id.information_treatment)
    TextView informationTreatment;
    @BindView(R.id.inspect)
    TextView inspect;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.information_back, R.id.information_common, R.id.information_recipes, R.id.information_prevention, R.id.information_treatment, R.id.inspect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.information_back:
                onBackPressed();
                break;
            case R.id.information_common:
                Intent intent=new Intent(InformationActivity.this,InforDetail.class);
                intent.putExtra("type",1);
                startActivity(intent);
                break;
            case R.id.information_recipes:
                Intent intentOne=new Intent(InformationActivity.this,InforDetail.class);
                intentOne.putExtra("type",2);
                startActivity(intentOne);
                break;
            case R.id.information_prevention:
                Intent intentTwo=new Intent(InformationActivity.this,InforDetail.class);
                intentTwo.putExtra("type",3);
                startActivity(intentTwo);
                break;
            case R.id.information_treatment:
                Intent intentThree=new Intent(InformationActivity.this,InforDetail.class);
                intentThree.putExtra("type",4);
                startActivity(intentThree);
                break;
            case R.id.inspect:
                Intent intentFour=new Intent(InformationActivity.this,InforDetail.class);
                intentFour.putExtra("type",5);
                startActivity(intentFour);
                break;
        }
    }
}
