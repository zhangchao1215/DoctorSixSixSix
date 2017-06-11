package jiyun.com.doctorsixsixsix.presenter;

import jiyun.com.doctorsixsixsix.modle.bean.State;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.DataModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IDataModel;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.DataView;

/**
 * 项目名称: 血压卫士
 * 类描述:个人资料的上传
 * 创建人: 马杰
 * 创建时间: 2017/6/11 19:08
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IDataPresenter implements DataPresenter {
    private DataModel model;
    private DataView view;
    public IDataPresenter(DataView view){
        this.view=view;
        model=new IDataModel();
    }
    @Override
    public void upLoadData(String userid, String height, String app_id, String sex, String birthday, String keyword, String accountstr) {
        model.upLoadData(userid, height, app_id, sex, birthday, keyword, accountstr, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                State state= (State) GsonUtils.getBean(GsonData, State.class);
                int state1 = state.getState();
                if(state1==200){
                    view.upLoadData();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
