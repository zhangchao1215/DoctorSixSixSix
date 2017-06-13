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
 * 创建时间: 2017/6/12 9:46
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DocShareModelImpl implements IDocShareModel {

    @Override
    public void DocShare(String id, MyCallBack callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("tag", "BloodAndroid");
        map.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act", "zhuanjia");
        map.put("fun", "Article");
        map.put("source", "cdsb");
        map.put("id", id);
        map.put("page", URLUtils.PAGEINDEX);
        map.put("size", URLUtils.PAGESIZE);
        Factory.create(1).GET(URLUtils.BASEURL, map, null, callBack);

    }
}
