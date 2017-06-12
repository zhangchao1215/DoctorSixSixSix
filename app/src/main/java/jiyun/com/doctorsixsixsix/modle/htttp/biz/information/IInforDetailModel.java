package jiyun.com.doctorsixsixsix.modle.htttp.biz.information;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯详情
 * 创建人: 马杰
 * 创建时间: 2017/6/12 11:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IInforDetailModel implements InforDetailModel {
    @Override
    public void getDetail(String id, String dir, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("act","zixun");
        map.put("fun","getHealthPlazeDetail");
        map.put("version","version2");
        map.put("tag","zj");
        map.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        map.put("id",id);
        map.put("dir",dir);
        Factory.create(Factory.OKHTTP).GET(URLUtils.BASEURL,map,null,callBack);
    }

    @Override
    public void shoucang(String meta,String xywy_userid, String category, String title, String categoryid, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        if(meta!=null) {
            map.put("meta", meta);
        }
        map.put("app_id", "2");
        map.put("tag","zj");
        map.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        map.put("title",title);
        map.put("xywy_userid",xywy_userid);
        map.put("categoryid",categoryid);
        map.put("category",category);
        Factory.create(Factory.OKHTTP).POST(URLUtils.COLLECT,map,null,callBack);
    }

    @Override
    public void isCollect(String xywy_userid, String categoryid, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("xywy_userid",xywy_userid);
        map.put("categoryid",categoryid);
        map.put("app_id","2");
        map.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        map.put("tag","zj");
        Factory.create(Factory.OKHTTP).POST(URLUtils.ISCOLLECT,map,null,callBack);
    }
}
