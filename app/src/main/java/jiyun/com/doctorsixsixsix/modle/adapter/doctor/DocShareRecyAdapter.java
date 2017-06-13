package jiyun.com.doctorsixsixsix.modle.adapter.doctor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.DoctorShareBean;


/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 10:23
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocShareRecyAdapter extends RecyclerView.Adapter<DocShareRecyAdapter.MyShareAdapter> {
    private List<DoctorShareBean.DataBean> mList;
    private OnClickListener onItemClickListener;

    public DocShareRecyAdapter(List<DoctorShareBean.DataBean> mList) {
        this.mList = mList;
    }

    public void setOnItemClickListener(OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public DocShareRecyAdapter.MyShareAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_doctor_recyshare_item, null);

        MyShareAdapter hodler = new MyShareAdapter(view);


        return hodler;
    }

    @Override
    public void onBindViewHolder(DocShareRecyAdapter.MyShareAdapter holder, int position) {
        DoctorShareBean.DataBean bean = mList.get(position);

        holder.mText.setText(bean.getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyShareAdapter extends RecyclerView.ViewHolder {
        private TextView mText;

        public MyShareAdapter(View itemView) {
            super(itemView);

            mText = (TextView) itemView.findViewById(R.id.doc_shareItem_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onItemClickListener.onClick(getLayoutPosition());

                }
            });


        }
    }

    public interface OnClickListener {

        void onClick(int postion);
    }
}
