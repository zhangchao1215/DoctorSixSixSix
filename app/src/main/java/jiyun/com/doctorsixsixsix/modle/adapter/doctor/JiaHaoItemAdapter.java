package jiyun.com.doctorsixsixsix.modle.adapter.doctor;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.JiaHaoDocBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 11:44
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class JiaHaoItemAdapter extends BaseAdapter {
    private Context context;
    private List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> mList;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    public JiaHaoItemAdapter(Context context, List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> mList) {
        this.context = context;
        this.mList = mList;

        mShared = context.getSharedPreferences("data", Context.MODE_PRIVATE);

        mEditor = mShared.edit();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getId() {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mViewHodle hodle = null;
        if (convertView == null) {
            hodle = new mViewHodle();

            convertView = LayoutInflater.from(context).inflate(R.layout.chaxun_jiahao_listviewitem, null);

            hodle.mTime = (TextView) convertView.findViewById(R.id.JiaHao_ItemTime);

            hodle.mCount = (TextView) convertView.findViewById(R.id.JiaHao_ItemCount);

            hodle.mMsg = (TextView) convertView.findViewById(R.id.JiaHao_ItemMsg);

            hodle.mXingqi = (TextView) convertView.findViewById(R.id.JiaHao_ItemXingqi);
            convertView.setTag(hodle);
        } else {
            hodle = (mViewHodle) convertView.getTag();
        }
        JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean bean = mList.get(position);

        hodle.mTime.setText(bean.getTitle());
        hodle.mMsg.setText(bean.getMsg());
        hodle.mCount.setText("(" + "剩余" + bean.getAmount() + "个" + ")");
        return convertView;
    }

    public class mViewHodle {
        private TextView mTime, mXingqi, mMsg, mCount;


    }

}
