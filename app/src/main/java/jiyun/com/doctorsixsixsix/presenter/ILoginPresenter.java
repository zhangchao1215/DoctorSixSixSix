package jiyun.com.doctorsixsixsix.presenter;

import android.content.SharedPreferences;
import android.util.Log;

import jiyun.com.doctorsixsixsix.modle.bean.User;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.ILoginModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.LoginModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.LoginView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
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
                User user= (User) GsonUtils.getBean(GsonData, User.class);
                int state = user.getState();
                if(state==200) {
                    view.login(user);
                    SharedPreferences.Editor put = AppUtils.put();
                    put.putBoolean("login",true);
                    put.commit();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
