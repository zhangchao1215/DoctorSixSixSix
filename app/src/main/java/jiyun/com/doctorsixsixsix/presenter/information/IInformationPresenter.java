package jiyun.com.doctorsixsixsix.presenter.information;

import android.util.Log;

import jiyun.com.doctorsixsixsix.modle.bean.Information;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.information.IInformationModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.information.InformationModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.InformationView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:21
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IInformationPresenter implements InformationPresenter {
    private InformationModel model;
    private InformationView view;

    public IInformationPresenter(InformationView view) {
        this.view = view;
        model=new IInformationModel();
    }

    @Override
    public void getList(String typeid, String dir) {
        model.getInformation(typeid, dir, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Information information= (Information) GsonUtils.getBean(GsonData,Information.class);
                int code = information.getCode();
                if(code==10000){
                    view.getList(information.getData());
                }else{
                    AppUtils.toast("数据请求失败");
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void shoucang() {

    }
}
