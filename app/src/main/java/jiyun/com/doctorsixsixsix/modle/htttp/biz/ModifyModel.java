package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/10 11:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface ModifyModel {
    void modify(String value, String pushable, String type, String userid, String keyword, MyCallBack callBack);

}
