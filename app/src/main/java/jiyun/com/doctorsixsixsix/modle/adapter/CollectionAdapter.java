package jiyun.com.doctorsixsixsix.modle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.Collection;

/**
 * 项目名称: 血压卫士
 * 类描述:收藏页面的适配器
 * 创建人: 马杰
 * 创建时间: 2017/6/11 20:55
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CollectionAdapter extends BaseAdapter {
    private List<Collection.Databean> mList;

    public CollectionAdapter(List<Collection.Databean> mList) {
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
            convertView= LayoutInflater.from(App.activity).inflate(R.layout.text_item,null);
            holder.mText= (TextView) convertView.findViewById(R.id.Main_Text);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Collection.Databean databean=mList.get(position);
        holder.mText.setText(databean.getTitle());
        return convertView;
    }
    public class ViewHolder{
        private TextView mText;
    }
}
