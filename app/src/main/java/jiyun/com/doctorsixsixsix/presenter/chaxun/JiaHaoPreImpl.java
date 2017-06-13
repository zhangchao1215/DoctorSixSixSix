package jiyun.com.doctorsixsixsix.presenter.chaxun;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.JiaHaoDocBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun.IJiaHaoDocModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun.JiaHaoModelImpl;
import jiyun.com.doctorsixsixsix.view.JiaHaoDocView;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是解析查询医生详情，里面的加号的解析
 * 创建人: Administrator
 * 创建时间: 2017/6/13 11:27
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class JiaHaoPreImpl implements IJiaHaoPrestener {
    private JiaHaoDocView docView;
    private IJiaHaoDocModel model;

    public JiaHaoPreImpl(JiaHaoDocView docView) {
        this.docView = docView;
        model = new JiaHaoModelImpl();
    }

    @Override
    public void JiaHao(String expertid, String id) {
        model.JiaHao(expertid, id, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {

                Gson gson = new Gson();
                if (GsonData.isEmpty()) {
                    return;
                }
                Log.d("JiaHaoPreImpl", GsonData);
                JiaHaoDocBean bean = null;
                try {
                    bean = gson.fromJson(GsonData, JiaHaoDocBean.class);

                    List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> rdtime = bean.getData().getSchedule().getRdtime();

                    JiaHaoDocBean.DataBean data = bean.getData();

                    if (rdtime.size() < 0)
                        return;

                    docView.JiaHao(rdtime);
                }catch (JsonSyntaxException e){
                    Log.d("失败", "失败");
                }


            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
