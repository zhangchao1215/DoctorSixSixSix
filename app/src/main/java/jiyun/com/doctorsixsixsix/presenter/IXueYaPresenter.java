package jiyun.com.doctorsixsixsix.presenter;

import android.util.Log;

import jiyun.com.doctorsixsixsix.modle.bean.Record;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IXueYaModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.XueYaModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.RecordView;

/**
 * 项目名称: 血压卫士
 * 类描述: 血压上传的P层
 * 创建人: 马杰
 * 创建时间: 2017/6/14 11:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IXueYaPresenter implements XueYaPresenter {
    private XueYaModel model;
    private RecordView view;

    public IXueYaPresenter(RecordView view) {
        this.view = view;
        model=new IXueYaModel();
    }

    @Override
    public void uploadXueYa(String datatime, String uid, String data,String sn) {
        model.uploadXueYa(uid, data, datatime, sn,new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Log.e("aaa0",GsonData);
                Record record= (Record) GsonUtils.getBean(GsonData,Record.class);
                int status = record.getStatus();
                if(status==0){
                    view.upLoadPressure();
                }else{
                    AppUtils.toast("上传失败");
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
