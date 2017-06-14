package jiyun.com.doctorsixsixsix.presenter.chaxun;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import jiyun.com.doctorsixsixsix.modle.bean.DoctorWenZhangBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.DocWenZhangIMpl;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.DoctorWenzhangModel;
import jiyun.com.doctorsixsixsix.view.DoctorWenZhangDetail;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 8:29
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocWenZhangPreImpl implements IDocWenZhangPresenter {
    private DoctorWenZhangDetail detail;
    private DoctorWenzhangModel model;

    public DocWenZhangPreImpl(DoctorWenZhangDetail detail) {
        this.detail = detail;
        model = new DocWenZhangIMpl();
    }

    @Override
    public void WenZhang(String id, String cateid) {

        model.WenZhang(id, cateid, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Gson gson = new Gson();

                DoctorWenZhangBean bean = null;
                try {
                    Log.d("DocWenZhangPreImpl", GsonData);
                    bean = gson.fromJson(GsonData, DoctorWenZhangBean.class);
                    if (bean == null) {
                        return;
                    }
                    DoctorWenZhangBean.DataBean data = bean.getData();
                    detail.WenZhang(data);
                } catch (JsonSyntaxException e) {

                }


            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
