package jiyun.com.doctorsixsixsix.presenter.doctorchao;

import com.google.gson.Gson;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.DoctorMainImpl;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IDoctorModel;
import jiyun.com.doctorsixsixsix.view.MainDoctorView;

/**
 * 项目名称: 血压卫士
 * 类描述:  解析第一个页面的数据
 * 创建人: Administrator
 * 创建时间: 2017/6/9 23:30
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DcotorMainImpl implements IDoctorPresenter {
    private MainDoctorView mainView;
    private IDoctorModel doctorModel;

    public DcotorMainImpl(MainDoctorView mainView) {
        this.mainView = mainView;
        doctorModel = new DoctorMainImpl();

    }

    @Override
    public void getMainDoctor(int Index) {


        doctorModel.getMainDoctor(Index, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Gson gson = new Gson();
                MainDoctorBean bean = gson.fromJson(GsonData, MainDoctorBean.class);

                List<MainDoctorBean.DataBean> data = bean.getData();
                if (data != null) {
                    mainView.LoadData(data);
                }


            }

            @Override
            public void onError(String errorMsg) {

            }
        });


    }
}
