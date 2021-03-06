package jiyun.com.doctorsixsixsix.modle.htttp.biz.chazun;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/12 14:38
 * 修改人:  张超
 * 修改内容:
 * 修改时间:   zzaa
 */

public class ChaXunModelImpl implements IChaXunModel {
    @Override
    public void ChaXun(int Index,String province,String title ,String medit, MyCallBack callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
        map.put("fun","SearchDoctor");
        map.put("pageCount", URLUtils.PAGESIZE);
        map.put("pageNum",URLUtils.PAGEINDEX);
        map.put("province",province);
        map.put("title",title);
        map.put("keyword",medit);
        map.put("illid","%E9%AB%98%E8%A1%80%E5%8E%8B");
        map.put("IsPlus","0");
        map.put("level","");
        Factory.create(1).GET(URLUtils.BASEURL,map,null,callBack);

    }
}
