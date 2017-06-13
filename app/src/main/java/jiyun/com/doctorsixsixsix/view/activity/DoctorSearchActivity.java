package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是搜索页面
 * 创建人: Administrator
 * 创建时间: 2017/6/12 21:06
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorSearchActivity extends BaseActivity {
    @BindView(R.id.Search_Back)
    ImageView SearchBack;
    @BindView(R.id.Doctor_Search_Edit)
    EditText mEdit;
    @BindView(R.id.Doctor_Search_QueDing)
    TextView DoctorSearchQueDing;
    @BindView(R.id.Doctor_Search_Listview)
    ListView DoctorSearchListview;
    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_doctor;
    }

    @Override
    protected void initView() {
        mShared = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.Search_Back, R.id.Doctor_Search_QueDing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Search_Back:

                onBackPressed();

                break;
            case R.id.Doctor_Search_QueDing:

                name = mEdit.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(this, "关键字不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("search_content",name);
                    setResult(200,intent);
                    onBackPressed();
                }
                break;
        }
    }



}
