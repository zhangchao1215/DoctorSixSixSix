package jiyun.com.doctorsixsixsix.modle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.Information;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

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

    public InforAdapter(List<Information.DataBean> mList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(App.activity).inflate(R.layout.infor_item,null);
        }
        return convertView;
    }

    class ViewHolder{
        private TextView title,order,date;
    }
}
