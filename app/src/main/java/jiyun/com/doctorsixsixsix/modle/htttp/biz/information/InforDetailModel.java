package jiyun.com.doctorsixsixsix.modle.htttp.biz.information;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/12 11:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface InforDetailModel {

    void getDetail(String id, String dir, MyCallBack callBack);
}
