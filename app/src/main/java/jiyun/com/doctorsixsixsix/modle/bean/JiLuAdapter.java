package jiyun.com.doctorsixsixsix.modle.bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.util.AppUtils;

import static android.view.View.X;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/15 14:32
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class JiLuAdapter extends BaseAdapter {
    private List<XueYa> mList;
    private Context context;

    public JiLuAdapter(List<XueYa> mList, Context context) {
        this.mList = mList;
        this.context = context;
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
            convertView= LayoutInflater.from(context).inflate(R.layout.jilu_item,null);
            holder.mtext= (TextView) convertView.findViewById(R.id.jilu_text);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        XueYa xueYa = mList.get(position);
        holder.mtext.setText((int)xueYa.getHigh()+"/"+(int)xueYa.getLow()+"        "+ AppUtils.longToString(xueYa
        .getDatatime()*1000,"MM月dd日 下午hh:mm"));
        return convertView;
    }
    class ViewHolder{
        private TextView mtext;
    }
}
