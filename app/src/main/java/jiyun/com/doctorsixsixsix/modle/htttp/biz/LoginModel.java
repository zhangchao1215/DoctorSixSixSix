package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是登陆抽取的接口
 * 创建人: dell
 * 创建时间: 2017/6/9 20:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface LoginModel {
    void login(String password, String phonenum, MyCallBack callBack);
}
