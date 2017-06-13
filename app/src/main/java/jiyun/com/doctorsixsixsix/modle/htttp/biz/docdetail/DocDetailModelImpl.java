package jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 8:13
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocDetailModelImpl implements DoctorDeatilModel {

    @Override
    public void DocModel(int expertid,int Index, MyCallBack callBack) {
        Map<String,String> params = new HashMap<>();
        params.put("tag","BloodAndroid");
        params.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        params.put("act","zhuanjia");
        params.put("fun","DoctorRely");
        params.put("expertid",String.valueOf(expertid));
        params.put("pageNum",String.valueOf(Index));
        params.put("pageCount","20");
        Factory.create(1).GET(URLUtils.BASEURL,params,null,callBack);



    }
}
