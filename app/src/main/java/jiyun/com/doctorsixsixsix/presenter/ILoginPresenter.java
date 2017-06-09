package jiyun.com.doctorsixsixsix.presenter;

import android.util.Log;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.ILoginModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.LoginModel;
import jiyun.com.doctorsixsixsix.view.LoginView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/9 20:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ILoginPresenter implements LoginPresenter {
    private LoginModel model;
    private LoginView view;
    public ILoginPresenter(LoginView view){
        this.view=view;
        model=new ILoginModel();
    }
    @Override
    public void login(String password, String phonenum) {
        model.login(password, phonenum, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Log.e("aa",GsonData);
                view.login();
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
