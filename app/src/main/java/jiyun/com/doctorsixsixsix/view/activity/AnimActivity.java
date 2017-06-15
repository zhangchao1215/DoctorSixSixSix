package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.view.MainActivity;

/**
 * 项目名称: 血压卫士
 * 类描述: 项目开始动画
 * 创建人: 马杰
 * 创建时间: 2017/6/15 8:15
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class AnimActivity extends BaseActivity {
    @BindView(R.id.anim_img)
    ImageView animImg;
    private Animation anim;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_anim;
    }

    @Override
    protected void initView() {
        anim= AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        animImg.setAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(AnimActivity.this, MainActivity.class);
                startActivity(intent);
                onBackPressed();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
