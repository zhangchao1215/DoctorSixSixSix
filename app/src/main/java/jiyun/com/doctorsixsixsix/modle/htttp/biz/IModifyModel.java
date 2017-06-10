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
 * 创建时间: 2017/6/10 11:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IModifyModel implements ModifyModel {
    @Override
    public void modify(String value, String pushable, String type, String userid, String keyword, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("value",value);
        map.put("pushable",pushable);
        map.put("type",type);
        map.put("userid",userid);
        map.put("keyword",keyword);
        Factory.create(Factory.OKHTTP).POST(URLUtils.PWDMODIFY,map,null,callBack);
    }
}
