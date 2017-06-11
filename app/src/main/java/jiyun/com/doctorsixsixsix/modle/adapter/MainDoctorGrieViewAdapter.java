package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.view.activity.DoctorDetailActivity;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是主页面医生的适配器，gridview
 * 创建人: Administrator
 * 创建时间: 2017/6/9 23:17
 * 修改人:  张超
 * 修改内容:  传值到医生详情页面
 * 修改时间:
 */

public class MainDoctorGrieViewAdapter extends BaseAdapter {
    private List<MainDoctorBean.DataBean> mList;
    private Context context;

    public MainDoctorGrieViewAdapter(Context context, List<MainDoctorBean.DataBean> mList) {
        this.context = context;
        this.mList = mList;
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

    @Override
    public View getView(int positio, View convertView, ViewGroup parent) {
        MyGVHodler hodler = null;
        if (convertView == null) {
            hodler = new MyGVHodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.chao_mydoctor_gridview_item, null);
            hodler.mTv = (TextView) convertView.findViewById(R.id.Doctor_GV_item_name);
            hodler.mIv = (ImageView) convertView.findViewById(R.id.Doctor_GV_item_image);
            convertView.setTag(hodler);

        } else {
            hodler = (MyGVHodler) convertView.getTag();
        }


        MainDoctorBean.DataBean bean = mList.get(positio);

        //这是把值传递到医生详情页面



        hodler.mTv.setText(bean.getName());

        Glide.with(context).load(bean.getApp_image()).into(hodler.mIv);

        return convertView;
    }

    class MyGVHodler {
        private TextView mTv;
        private ImageView mIv;

    }
}
