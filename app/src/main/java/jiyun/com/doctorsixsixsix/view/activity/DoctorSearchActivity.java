package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.Dao.DoctorQuery;
import jiyun.com.doctorsixsixsix.Dao.DoctorQueryDao;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;

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
    ListView mListview;
    private List<DoctorQuery> strList;
    private String name;
    private DoctorQuery doctorQuery;
    private DoctorQueryDao queryDao;
    private QueryAdater adater;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_doctor;
    }

    @Override
    protected void initView() {
        strList = new ArrayList<>();
        queryDao = App.getDaoInstant().getDoctorQueryDao();


        adater = new QueryAdater();
        mListview.setAdapter(adater);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        if(strList.size()<0){
            AppUtils.toast("没有数据");
        }else{
            strList = queryDao.queryBuilder().list();
        }
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
                    doctorQuery = new DoctorQuery();
                    doctorQuery.setName(name);

                    queryDao.insert(doctorQuery);

                    Intent intent = new Intent();
                    intent.putExtra("search_content", name);
                    setResult(200, intent);
                    onBackPressed();
                }
                break;
        }
    }

    public class QueryAdater extends BaseAdapter {

        @Override
        public int getCount() {
            return strList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            MyHodler hodler = null;
            if (convertView == null) {
                hodler = new MyHodler();

                convertView = LayoutInflater.from(DoctorSearchActivity.this).inflate(R.layout.activity_doctorquery_item, null);

                hodler.mText = (TextView) convertView.findViewById(R.id.Doctor_query_item);

                convertView.setTag(hodler);
            } else {
                hodler = (MyHodler) convertView.getTag();
            }

            DoctorQuery query = strList.get(position);

            hodler.mText.setText(query.getName() + "");

            return convertView;
        }

        public class MyHodler {
            private TextView mText;
        }

    }


}
