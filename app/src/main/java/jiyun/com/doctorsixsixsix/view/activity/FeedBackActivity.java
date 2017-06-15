package jiyun.com.doctorsixsixsix.view.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IFanModel;
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
    @BindView(R.id.feed_text)
    TextView feedText;

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
                if (feedBackEdit.getText().toString().isEmpty()) {
                    AppUtils.toast("发送的内容不能为空");
                } else {
                    IFanModel model=new IFanModel();
                    String id = AppUtils.get().getString("id", "");
                    model.fankui(id, feedBackEdit.getText().toString(), new MyCallBack() {
                        @Override
                        public void onSuccess(String GsonData) {
                            AppUtils.toast("发送成功");
                        }

                        @Override
                        public void onError(String errorMsg) {

                        }
                    });
                }
            }
        });
        feedBackEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                feedText.setText(s.length()+"/600");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }

}
