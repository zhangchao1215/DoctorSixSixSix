package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.Time;

/**
 * 项目名称: 血压卫士
 * 类描述:RemindActivity的适配器
 * 创建人: admin
 * 创建时间: 2017/6/13 15:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class TiXingAdapter  extends BaseAdapter{


        private List<Time> mList;
        private Context context;

        public TiXingAdapter(Context context,List<Time> mList){
            this.mList = mList;
            this.context = context;
        }

        @Override
        public int getCount() {
            //设置显示条目
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
                holder = new ViewHolder();
                convertView= LayoutInflater.from(App.activity).inflate(R.layout.remind_list_item,null);
                holder.data_time= (TextView) convertView.findViewById(R.id.time);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.number = (TextView) convertView.findViewById(R.id.number);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            Time tt=mList.get(position);

            holder.data_time.setText(tt.getData_time());
            holder.name.setText(tt.getName());
            holder.number.setText(tt.getNumber()+"");
            return convertView;
        }
        public class ViewHolder{
            private TextView data_time,name,number;
        }

}
