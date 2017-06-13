package jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 14:37
 * 修改人:  张超
 * 修改内容:
 * 修改时间:zzaa
 */

public interface IChaXunModel {
    void ChaXun(int Index,String province,String title ,String medit, MyCallBack callBack);

}
