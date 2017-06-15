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
 * 创建时间: 2017/6/15 16:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IFanModel implements FanModel {
    @Override
    public void fankui(String id, String content, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("userid",id);
        map.put("content",content);
        map.put("apptype","10004");
        Factory.create(Factory.OKHTTP).POST(URLUtils.FANKUI,map,null,callBack);
    }
}
