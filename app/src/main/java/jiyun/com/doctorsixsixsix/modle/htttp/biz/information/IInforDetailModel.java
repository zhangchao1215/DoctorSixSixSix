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
}
