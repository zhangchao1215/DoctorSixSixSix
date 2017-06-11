package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/9 16:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface PersonlModel {
    void upLoadImage( String file,String button,String cookie, MyCallBack callBack);

    void getPerson(String userid,String sign,MyCallBack callBack);
}
