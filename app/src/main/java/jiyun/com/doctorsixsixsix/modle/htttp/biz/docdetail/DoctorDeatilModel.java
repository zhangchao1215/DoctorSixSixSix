package jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是医生详情页面modle层抽取的接口
 * 创建人: Administrator
 * 创建时间: 2017/6/12 8:08
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface DoctorDeatilModel {

    void DocModel(int expertid,int Index, MyCallBack callBack);

}
