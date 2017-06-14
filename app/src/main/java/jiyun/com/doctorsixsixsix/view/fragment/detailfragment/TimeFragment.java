package jiyun.com.doctorsixsixsix.view.fragment.detailfragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.bean.OutCallBeans;
import jiyun.com.doctorsixsixsix.view.activity.kechengbiao.IOutCallView;
import jiyun.com.doctorsixsixsix.view.activity.kechengbiao.IoutcallPrestener;
import jiyun.com.doctorsixsixsix.view.activity.kechengbiao.KeChengAdapter;
import jiyun.com.doctorsixsixsix.view.activity.kechengbiao.OutCallPreImpl;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/11 20:55
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class TimeFragment extends BaseFragment implements IOutCallView {
    @BindView(R.id.courceDetail)
    GridView courceDetail;
    private String[][] contents = {{"1", "8", "15"}, {"2", "9", "16"}, {"3", "10", "17"}, {"4", "11", "18"}, {"5", "12", "19"}, {"6", "13", "20"}, {"7", "14", "21"}};
    private IoutcallPrestener prestener;
    private List<String> list = new ArrayList<>();
    private String id;
    private KeChengAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kechengbiao;
    }

    @Override
    protected void initView(View view) {
        Intent intent = getActivity().getIntent();

        id = intent.getStringExtra("document_id");

        prestener = new OutCallPreImpl(this);
        prestener.KeCheng(id);

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
    }

    /**
     * 准备数据
     */
    private List<String> init(String st) {
        String day = st.substring(11, 14);
        String hour = st.substring(15, 17);
        int day1 = getDay(day, hour);
        list.remove(day1);
        list.add(day1, "专家门诊");
        return list;
    }

    private int getDay(String day, String mhour) {
        switch (day) {
            case "星期一":
                return Integer.parseInt(contents[0][getHour(mhour)]);
            case "星期二":
                return Integer.parseInt(contents[0][getHour(mhour)]);
            case "星期三":
                return Integer.parseInt(contents[1][getHour(mhour)]);
            case "星期四":
                return Integer.parseInt(contents[2][getHour(mhour)]);
            case "星期五":
                return Integer.parseInt(contents[3][getHour(mhour)]);
            case "星期六":
                return Integer.parseInt(contents[4][getHour(mhour)]);
            case "星期日":
                return Integer.parseInt(contents[5][getHour(mhour)]);
        }

        return 0;
    }

    private int getHour(String mhour) {
        switch (mhour) {
            case "上午":
                return 0;
            case "下午":
                return 1;
            case "晚上":
                return 2;
        }
        return 0;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void loadData(OutCallBeans outCallBeans) {
        OutCallBeans.DataBean data = outCallBeans.getData();
        List<OutCallBeans.DataBean.ScheduleBean.RdtimeBean> rdtime = data.getSchedule().getRdtime();
        for (OutCallBeans.DataBean.ScheduleBean.RdtimeBean rdtimeBean : rdtime) {
            Log.d("ExpertOutCall", rdtimeBean.getTitle());
            if (!rdtimeBean.getTitle().equals(""))
                init(rdtimeBean.getTitle());
        }
        adapter = new KeChengAdapter(getContext(), list);
        courceDetail.setAdapter(adapter);


    }


}
