package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.Information;
import jiyun.com.doctorsixsixsix.util.AppUtils;


/**
 * 项目名称: 血压卫士
 * 类描述: 资讯列表的适配器
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforAdapter extends BaseAdapter {
    private List<Information.DataBean> mList;
    private Context mContext;

    public InforAdapter(List<Information.DataBean> mList,Context mContext) {
        this.mList = mList;
        this.mContext=mContext;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.infor_item,null);
            holder.title= (TextView) convertView.findViewById(R.id.inforde_title);
            holder.order= (TextView) convertView.findViewById(R.id.inforde_order);
            holder.date= (TextView) convertView.findViewById(R.id.inforde_date);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Information.DataBean dataBean=mList.get(position);
        holder.title.setText(dataBean.getTitle());
        holder.order.setText(dataBean.getDescription());
        String s = AppUtils.longToString(dataBean.getPubdate()*1000, "yyyy年M月dd日 hh:mm:ss");
        holder.date.setText(s);
        return convertView;
    }

    class ViewHolder{
        private TextView title,order,date;
    }
}
