package jiyun.com.doctorsixsixsix.view.activity.mftw;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 17:12
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class WenTiActivity extends BaseActivity {


    @BindView(R.id.account_back)
    ImageView accountBack;
    @BindView(R.id.account_Title)
    TextView accountTitle;
    @BindView(R.id.tiwenyisheng)
    RelativeLayout tiwenyisheng;
    @BindView(R.id.jieshao)
    TextView jieshao;
    @BindView(R.id.miaoshu)
    EditText miaoshu;
    @BindView(R.id.Free_man)
    RadioButton FreeMan;
    @BindView(R.id.Free_woman)
    RadioButton FreeWoman;
    @BindView(R.id.DoctorOnline)
    EditText DoctorOnline;
    @BindView(R.id.tiwen_radiogroup)
    RadioGroup tiwenRadiogroup;
    @BindView(R.id.tjgys)
    Button tjgys;
    @BindView(R.id.mfwys_Text)
    TextView mfwysText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mfwys_tw;
    }

    @Override
    protected void initView() {
        miaoshu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mfwysText.setText(s.length()+"/500");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    Handler handler = new Handler();

    @OnClick({R.id.miaoshu, R.id.tjgys, R.id.account_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.miaoshu:
                break;
            case R.id.tjgys:
                String edit = miaoshu.getText().toString().trim();
                if (edit.isEmpty()) {
                    AppUtils.toast("不能为空哦");
                } else {
                    if (edit.length() < 12) {
                        AppUtils.toast("你输入的内容不够12个字哦");
                    } else {
                        AppUtils.dialog();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AppUtils.dismiss();
                                AppUtils.toast("你的网速有点慢哦");
                            }
                        }, 1000);
                    }
                }

                break;
            case R.id.account_back:
                onBackPressed();
                break;
        }
    }


}
