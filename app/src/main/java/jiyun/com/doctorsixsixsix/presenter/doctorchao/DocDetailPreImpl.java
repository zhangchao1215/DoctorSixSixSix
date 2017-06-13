package jiyun.com.doctorsixsixsix.presenter.doctorchao;

import android.util.Log;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.DoctorDetailBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.DocDetailModelImpl;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail.DoctorDeatilModel;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.DoctorHuiFuView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 8:42
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocDetailPreImpl implements IDocDetailPre{
    private DoctorDeatilModel deatilModel;

    private DoctorHuiFuView huiFuView;

    public DocDetailPreImpl(DoctorHuiFuView huiFuView) {
        this.huiFuView = huiFuView;

        deatilModel = new DocDetailModelImpl();
    }

    @Override
    public void DocDetail(int expertid, int Index) {

        deatilModel.DocModel(expertid, Index, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Log.d("DocDetailPreImpl", GsonData);

                DoctorDetailBean bean = (DoctorDetailBean) GsonUtils.getBean(GsonData, DoctorDetailBean.class);

                List<DoctorDetailBean.DataBean> data = bean.getData();

                huiFuView.DocHuiFu(data);



            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
