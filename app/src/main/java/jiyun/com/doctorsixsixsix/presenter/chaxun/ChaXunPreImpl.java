package jiyun.com.doctorsixsixsix.presenter.chaxun;

import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun.ChaXunModelImpl;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun.IChaXunModel;
import jiyun.com.doctorsixsixsix.view.ChaXunZhuanJiaView;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是查询医生的P层,得到所有的内容，进行查询
 * 创建人: 张超
 * 创建时间: 2017/6/12 14:48
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class ChaXunPreImpl implements IChaXunPresenter {
    private IChaXunModel model;
    private ChaXunZhuanJiaView view;

    public ChaXunPreImpl(ChaXunZhuanJiaView view) {
        this.view = view;
        model = new ChaXunModelImpl();
    }

    @Override
    public void ChaXun(int Index,String province,String title ,String medit) {
        model.ChaXun(Index,province,title,medit, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
//                MainDoctorBean bean = (MainDoctorBean) GsonUtils.getBean(GsonData, MainDoctorBean.class);

                Gson gson = new Gson();
                MainDoctorBean bean = gson.fromJson(GsonData, MainDoctorBean.class);
                List<MainDoctorBean.DataBean> data = bean.getData();

                Log.d("ChaXunPreImpl", "data:" + data);

                view.ChaXun(data);

            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }
}
