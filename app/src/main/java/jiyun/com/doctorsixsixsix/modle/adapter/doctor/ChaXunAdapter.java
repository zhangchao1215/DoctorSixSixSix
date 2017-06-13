package jiyun.com.doctorsixsixsix.modle.adapter.doctor;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.view.activity.DoctorDetailActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 14:54
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ChaXunAdapter extends BaseAdapter<MainDoctorBean.DataBean> {
    public ChaXunAdapter(Context context, List<MainDoctorBean.DataBean> datas) {
        super(context, R.layout.chaxunzhuanjia_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final MainDoctorBean.DataBean dataBean) {
        holder.setText(R.id.Doctor_Name, dataBean.getName());
        holder.setText(R.id.Doctor_YiYuan, dataBean.getHospital());
        holder.setText(R.id.Doctor_ZhiCheng, dataBean.getTeach());
        holder.setText(R.id.Doctor_KeShi, dataBean.getDepart());
        holder.setText(R.id.Doctor_JiBie, dataBean.getTitle());
        holder.setText(R.id.Doctor_Content, dataBean.getGoodat());
        ImageView image = holder.getView(R.id.Doctor_Image);

        Glide.with(context).load(dataBean.getApp_image()).into(image);

        holder.setOnclickListener(R.id.ChaXun_RelativeLayout, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorDetailActivity.class);
                intent.putExtra("app_image", dataBean.getApp_image());
                intent.putExtra("doc_name", dataBean.getName());
                intent.putExtra("doc_title", dataBean.getTitle());
                intent.putExtra("doc_teach", dataBean.getTeach());
                intent.putExtra("doc_hospital", dataBean.getHospital());
                intent.putExtra("doc_content", dataBean.getGoodat());
                intent.putExtra("doc_depart", dataBean.getDepart());
                intent.putExtra("doc_id", dataBean.getExpert_id());
                context.startActivity(intent);
            }
        });
    }
}
