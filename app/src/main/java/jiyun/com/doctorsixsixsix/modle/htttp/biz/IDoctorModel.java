package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/9 23:26
 * 修改人:  张超
 * 修改内容: 这是我的主页面请求的医生信息
 * 修改时间:
 */

public interface IDoctorModel {
    void getMainDoctor(int Index, MyCallBack callBack);

}
