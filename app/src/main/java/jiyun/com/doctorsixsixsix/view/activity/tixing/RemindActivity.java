package jiyun.com.doctorsixsixsix.view.activity.tixing;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.Dao.TimeDao;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.TiXingAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.Time;
import jiyun.com.doctorsixsixsix.view.activity.tixing.db.MyHepler;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/12 10:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class RemindActivity extends BaseActivity {


    @BindView(R.id.remind_back)
    ImageView remindBack;
    @BindView(R.id.remind_Title)
    TextView remindTitle;
    @BindView(R.id.remind_add)
    ImageView remindAdd;
    @BindView(R.id.remind_relative)
    RelativeLayout remindRelative;
    private MyHepler myHelper;
    private List<Time> lists;
    private ListView lv;
    private TiXingAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_remind;
    }

    @Override
    protected void initView() {
        myHelper = new MyHepler(getApplicationContext());
        myHelper.getReadableDatabase();

        lists = new ArrayList<Time>();
        //找到控件
        lv = (ListView) findViewById(R.id.lv_List);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        TimeDao dbDao = App.getDaoInstant().getTimeDao();
        lists = dbDao.loadAll();
        if (lists.size() == 0) {

        } else {

            adapter = new TiXingAdapter(RemindActivity.this , lists);

            lv.setAdapter(adapter);

            adapter.notifyDataSetChanged();

            Log.e("DB", "AA：" + lists.toString());
            Log.e("DB", "AA：" + lists.size());
        }


    }


    @OnClick({R.id.remind_back, R.id.remind_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.remind_back:
                onBackPressed();
                break;
            case R.id.remind_add:
                Intent intent = new Intent(RemindActivity.this,AddRemindActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


}
