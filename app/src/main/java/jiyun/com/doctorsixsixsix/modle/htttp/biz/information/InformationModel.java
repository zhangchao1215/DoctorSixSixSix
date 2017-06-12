package jiyun.com.doctorsixsixsix.modle.htttp.biz.information;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/12 9:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface InformationModel {
    void getInformation(String typeid, String dir, MyCallBack callBack);

    void shoucang();
}
