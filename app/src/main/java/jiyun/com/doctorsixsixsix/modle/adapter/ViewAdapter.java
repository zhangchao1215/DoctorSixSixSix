package jiyun.com.doctorsixsixsix.modle.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.StatisticsView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/13 11:21
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ViewAdapter extends PagerAdapter {
    private List<String[]> str;
    private float[] floats={};
    private float[] floats1={};

    public void setFloats1(float[] floats1) {
        this.floats1 = floats1;
    }

    private Context context;
    private int a=0;

    public void setA(int a) {
        this.a = a;
    }

    public ViewAdapter(List<String[]> str, Context context) {
        this.str = str;
        this.context=context;
    }

    public void setFloats(float[] floats) {
        this.floats = floats;
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.statis_fragment,null);
        StatisticsView statisticsView= (StatisticsView) view.findViewById(R.id.fragment);
        statisticsView.setBottomStr(str.get(position));
        if(a==position) {
            statisticsView.setValues(floats);
            statisticsView.setValuesOne(floats1);
        }
        statisticsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.toast("讲道理这个页面我不想写，但总感觉不写点什么不太好，所以就写一句话好了——马杰");
            }
        });
        container.addView(view);
        return view;
    }
}
