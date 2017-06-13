package jiyun.com.doctorsixsixsix.presenter.doctorchao;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.DoctorShareBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.DocShareModelImpl;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.IDocShareModel;
import jiyun.com.doctorsixsixsix.view.DocShareView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 9:54
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocSharePreImpl implements IDocSharePresenter {
    private DocShareView shareView;
    private IDocShareModel model;

    public DocSharePreImpl(DocShareView shareView) {
        this.shareView = shareView;
        model = new DocShareModelImpl();
    }

    @Override
    public void DocShare(String id) {
        model.DocShare(id, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {

                if (GsonData.isEmpty()) {
                    return;
                } else {

                    Log.d("DocSharePreImpl", GsonData);
//                DoctorShareBean bean = (DoctorShareBean) GsonUtils.getBean(GsonData, DoctorShareBean.class);
                    Gson gson = new Gson();
                    DoctorShareBean bean = null;
                    try {
                        bean = gson.fromJson(GsonData, DoctorShareBean.class);
                        List<DoctorShareBean.DataBean> data = bean.getData();
                        shareView.DocShare(data);
                    } catch (JsonSyntaxException e) {
                        Log.e("TAG","失败");
                    }

                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }
}
