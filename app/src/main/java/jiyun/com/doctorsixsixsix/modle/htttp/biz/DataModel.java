package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/11 18:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface DataModel {
    void upLoadData(String userid, String height, String app_id, String sex, String birthday, String keyword, String accountstr, MyCallBack callBack);
}
