package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述: 请求收藏数据
 * 创建人: 马杰
 * 创建时间: 2017/6/11 20:39
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ICollectionModel implements CollectionModel {
    @Override
    public void getCollection(String xywy_userid, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("xywy_userid",xywy_userid);
        map.put("app_id","2");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("tag","BloodAndroid");
        Factory.create(Factory.OKHTTP).POST(URLUtils.COLLECTION,map,null,callBack);
    }
}
