package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是省份，字母轴的适配器
 * 创建人: Administrator
 * 创建时间: 2017/6/9 19:45
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ZiMuZhouAdapter extends BaseAdapter {
    private List<String> mList;
    private Context context;

    public ZiMuZhouAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.chao_activity_zimuzhou_item, null);

            hodler.mTv = (TextView) convertView.findViewById(R.id.Zimu_itemText);

            convertView.setTag(hodler);
        } else {
            hodler = (MyHodler) convertView.getTag();
        }
        String s = mList.get(position);

        hodler.mTv.setText(s + "");


        return convertView;
    }

    class MyHodler {

        private TextView mTv;

    }
}
