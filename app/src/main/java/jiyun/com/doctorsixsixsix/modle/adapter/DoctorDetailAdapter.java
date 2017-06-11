package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.DoctorDetailBean;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是医生详情回复的适配器
 * 创建人: Administrator
 * 创建时间: 2017/6/11 23:06
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorDetailAdapter  extends BaseAdapter<DoctorDetailBean.DataBean>{


    public DoctorDetailAdapter(Context context, List<DoctorDetailBean.DataBean> datas) {
        super(context, R.layout.activity_pullrecycler, datas);
    }

    @Override
    public void convert(ViewHolder holder, DoctorDetailBean.DataBean Bean) {
        holder.setText(R.id.Doctor_Detail_ItemName,Bean.getTitle());
        holder.setText(R.id.DoctorDetail_ItemContent,Bean.getReply());


    }
}
