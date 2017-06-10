package jiyun.com.doctorsixsixsix.presenter;

import jiyun.com.doctorsixsixsix.base.BaseBean;
import jiyun.com.doctorsixsixsix.modle.bean.State;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IModifyModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.ModifyModel;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.ModifyView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/10 11:44
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IModifyPresenter implements ModifyPresenter {
    private ModifyView view;
    private ModifyModel model;
    public IModifyPresenter(ModifyView view){
        this.view=view;
        model=new IModifyModel();
    }
    @Override
    public void modify(String value, String userid) {
        model.modify(value, "1", "3", userid, "password", new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                State sta = (State) GsonUtils.getBean(GsonData, BaseBean.class);
                int state = sta.getState();
                if(state==200){
                    view.modify();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
