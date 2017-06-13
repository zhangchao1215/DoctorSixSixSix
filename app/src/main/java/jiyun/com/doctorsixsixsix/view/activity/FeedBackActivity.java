package jiyun.com.doctorsixsixsix.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/13 9:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.feed_back)
    ImageView feedBack;
    @BindView(R.id.feed_Title)
    TextView feedtitle;
    @BindView(R.id.feed_title)
    RelativeLayout feedTitle;
    @BindView(R.id.feed_back_edit)
    EditText feedBackEdit;
    @BindView(R.id.feed_fasong)
    TextView feedFasong;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        feedFasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedBackEdit.getText().toString().isEmpty()) {
                    AppUtils.toast("发送的内容不能为空");
                }else{
                    AppUtils.toast("提交成功");
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

}
