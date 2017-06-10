package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/9 16:43
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IPersonlModel implements PersonlModel {
    @Override
    public void upLoadImage( String file,String button,String cookie, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("file",file);
        map.put("button",button);
        Factory.create(Factory.OKHTTP).POST(URLUtils.IMAGE,map,cookie,callBack);
    }

    @Override
    public void getPerson(String userid,String sign,MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("act","kbb");
        map.put("fun","users");
        map.put("type","pullAccountInfo");
        map.put("tag","wjk");
        map.put("userid",userid);
        map.put("sign",sign);
        Factory.create(Factory.OKHTTP).GET(URLUtils.USERS,map,null,callBack);
    }

}
